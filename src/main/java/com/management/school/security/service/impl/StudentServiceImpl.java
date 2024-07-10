package com.management.school.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.school.security.dto.StudentDto;
import com.management.school.security.dto.converter.StudentDtoConverter;
import com.management.school.security.dto.request.student.CreateStudentRequest;
import com.management.school.security.dto.request.student.UpdateStudentRequest;
import com.management.school.security.exception.StudentAlreadyExistException;
import com.management.school.security.exception.StudentNotFoundException;
import com.management.school.security.helper.BusinessMessage;
import com.management.school.security.helper.DateHelper;
import com.management.school.security.helper.GenerateStudentNumber;
import com.management.school.security.helper.LogMessage;
import com.management.school.security.model.Student;
import com.management.school.security.repository.StudentRepository;
import com.management.school.security.service.ClassroomService;
import com.management.school.security.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ClassroomService classroomService;
	@Autowired
	private StudentDtoConverter converter;

	@Override
	public void createStudent(CreateStudentRequest request) {
		checkIfStudentExists(request.getNationalId());
		checkIfStudentFatherPhoneExists(request.getFatherPhone());
		checkIfStudentMotherPhoneExists(request.getMotherPhone());

		Student student = new Student();
		student.setFirstName(request.getFirstName());
		student.setLastName(request.getLastName());
		student.setNationalId(request.getNationalId());
		student.setStudentNumber(GenerateStudentNumber.generate());
		student.setFatherName(request.getFatherName());
		student.setFatherPhone(request.getFatherPhone());
		student.setMotherName(request.getMotherName());
		student.setMotherPhone(request.getMotherPhone());
		student.setCreatedDate(DateHelper.getCurrentDate());
		student.setUpdatedDate(DateHelper.getCurrentDate());

		studentRepository.save(student);
		log.info(LogMessage.Student.StudentCreated());
	}

	@Override
	public void updateStudent(String id, UpdateStudentRequest request) {
		Student student = findStudentByStudentId(id);

		if (!student.getFatherPhone().equals(request.getFatherPhone())) {
			checkIfStudentFatherPhoneExists(request.getFatherPhone());
		}
		if (!student.getMotherPhone().equals(request.getMotherPhone())) {
			checkIfStudentMotherPhoneExists(request.getMotherPhone());
		}

		student.setFirstName(request.getFirstName());
		student.setLastName(request.getLastName());
		student.setFatherName(request.getFatherName());
		student.setFatherPhone(request.getFatherPhone());
		student.setMotherName(request.getMotherName());
		student.setMotherPhone(request.getMotherPhone());
		student.setClassroom(classroomService.findClassroomByClassroomId(request.getClassroomId()));
		student.setUpdatedDate(DateHelper.getCurrentDate());

		studentRepository.save(student);
		log.info(LogMessage.Student.StudentUpdated(id));

	}

	@Override
	public void addStudentToClassroom(String id, String classroomId) {
		 Student student = findStudentByStudentId(id);
	        student.setClassroom(classroomService.findClassroomByClassroomId(classroomId));
	        student.setUpdatedDate(DateHelper.getCurrentDate());

	        studentRepository.save(student);
	        log.info(LogMessage.Student.StudentAddedToClassroom(id, classroomId));

	}
	// One More MEthod neeed to implement UpdateStudentTOClassroom

	@Override
	public void removeStudentFromClassroom(String id) {
		 Student student = findStudentByStudentId(id);
	        student.setClassroom(null);
	        student.setUpdatedDate(DateHelper.getCurrentDate());

	        studentRepository.save(student);
	        log.info(LogMessage.Student.StudentRemovedFromClassroom(id));

	}

	@Override
	public void deleteStudent(String id) {
		 Student student = findStudentByStudentId(id);
	        student.setClassroom(null);
	        student.setUpdatedDate(DateHelper.getCurrentDate());

	        studentRepository.save(student);
	        log.info(LogMessage.Student.StudentRemovedFromClassroom(id));

	}

	@Override
	public StudentDto findStudentById(String id) {
		Student student = findStudentByStudentId(id);

        log.info(LogMessage.Student.StudentFound(id));
        return converter.convert(student);
	}

	@Override
	public List<StudentDto> findAllStudents() {
		  List<Student> studentList = studentRepository.findAll();

	        if (studentList.isEmpty()) {
	            log.error(LogMessage.Student.StudentListEmpty());
	            throw new StudentNotFoundException(BusinessMessage.Student.STUDENT_LIST_EMPTY);
	        }

	        log.info(LogMessage.Student.StudentListed());
	        return converter.convert(studentList);
	}

	private void checkIfStudentExists(String nationalId) {
		if (studentRepository.existsByNationalId(nationalId)) {
			log.error(LogMessage.Student.StudentAlreadyExists(nationalId));
			throw new StudentAlreadyExistException(BusinessMessage.Student.STUDENT_ALREADY_EXISTS);
		}
	}

	private void checkIfStudentFatherPhoneExists(String fatherPhone) {
		if (studentRepository.existsByFatherPhone(fatherPhone)) {
			log.error(LogMessage.Student.FatherPhoneAlreadyExists(fatherPhone));
			throw new StudentAlreadyExistException(BusinessMessage.Student.STUDENT_FATHER_PHONE_ALREADY_EXISTS);
		}
	}

	private void checkIfStudentMotherPhoneExists(String motherPhone) {
		if (studentRepository.existsByMotherPhone(motherPhone)) {
			log.error(LogMessage.Student.MotherPhoneAlreadyExists(motherPhone));
			throw new StudentAlreadyExistException(BusinessMessage.Student.STUDENT_MOTHER_PHONE_ALREADY_EXISTS);
		}
	}
	@Override
	 public Student findStudentByStudentId(String id) {
	        return studentRepository.findById(id)
	                .orElseThrow(() -> {
	                    log.error(LogMessage.Student.StudentNotFound(id));
	                    return new StudentNotFoundException(BusinessMessage.Student.STUDENT_NOT_FOUND);
	                });
	    }

}
