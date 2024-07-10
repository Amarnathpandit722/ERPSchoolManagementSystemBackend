package com.management.school.security.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.school.security.dto.ClassroomDto;
import com.management.school.security.dto.StudentDto;
import com.management.school.security.dto.converter.ClassroomDtoConverter;
import com.management.school.security.dto.converter.StudentDtoConverter;
import com.management.school.security.dto.request.classroom.CreateClassroomRequest;
import com.management.school.security.dto.request.classroom.UpdateClassroomRequest;
import com.management.school.security.exception.ClassroomNotFoundException;
import com.management.school.security.helper.BusinessMessage;
import com.management.school.security.helper.GenerateClassroomName;
import com.management.school.security.helper.LogMessage;
import com.management.school.security.model.Classroom;
import com.management.school.security.model.Student;
import com.management.school.security.repository.ClassroomRepository;
import com.management.school.security.service.ClassroomService;
import com.management.school.security.service.TeacherService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClassroomServiceImpl implements ClassroomService {
	@Autowired
	private ClassroomRepository classroomRepository;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private ClassroomDtoConverter converter;
	@Autowired
	private StudentDtoConverter studentDtoConverter;
	
	
	@Override
	public void createClassroom(CreateClassroomRequest request) {
		 Classroom classroom = new Classroom();
	        
		 	String  name = GenerateClassroomName.generate();
		 	StringBuilder sb = new StringBuilder(name);
		 	sb.append("-");
		 	sb.append(request.getName());
		 	
		 	classroom.setClassroomCode(sb.toString());
		 	classroom.setName(request.getName());
	        
	        classroom.setDescription(request.getDescription());
	        classroom.setTeacher(teacherService.findTeacherByTeacherId(request.getTeacherId()));

	        classroomRepository.save(classroom);
	        log.info(LogMessage.Classroom.ClassroomCreated());

	}

	@Override
	public void updateClassroom(String id, UpdateClassroomRequest request) {
		 Classroom classroom = findClassroomByClassroomId(id);

	        classroom.setDescription(request.getDescription());
	        classroom.setTeacher(teacherService.findTeacherByTeacherId(request.getTeacherId()));

	        classroomRepository.save(classroom);
	        log.info(LogMessage.Classroom.ClassroomUpdated(id));

	}

	@Override
	public void deleteClassroom(String id) {
		Classroom classroom = findClassroomByClassroomId(id);

        classroomRepository.delete(classroom);
        log.info(LogMessage.Classroom.ClassroomDeleted(id));

	}
	

	@Override
	public ClassroomDto findClassroomById(String id) {
		Classroom classroom = findClassroomByClassroomId(id);

        log.info(LogMessage.Classroom.ClassroomFound(id));
        return converter.convert(classroom);
	}

	@Override
	public List<ClassroomDto> findAllClassrooms() {
		 List<Classroom> classroomList = classroomRepository.findAll();

	        if (classroomList.isEmpty()) {
	            log.error(LogMessage.Classroom.ClassroomListEmpty());
	            throw new ClassroomNotFoundException(BusinessMessage.Classroom.CLASSROOM_LIST_EMPTY);
	        }

	        log.info(LogMessage.Classroom.ClassroomListed());
	        return converter.convert(classroomList);
	}
	@Override
	public Classroom findClassroomByClassroomId(String id) {
        return classroomRepository.findById(id).orElseThrow(() -> {
            log.error(LogMessage.Classroom.ClassroomNotFound(id));
            throw new ClassroomNotFoundException(BusinessMessage.Classroom.CLASSROOM_NOT_FOUND);
        });
    }

	@Override
	public List<StudentDto> getStudentsByClassroomId(String classroomId) {
		 Optional<Classroom> optionalClassroom = classroomRepository.findById(classroomId);
	        if (optionalClassroom.isPresent()) {
	            Classroom classroom = optionalClassroom.get();
	            List<Student> students = classroom.getStudentList();
	            return studentDtoConverter.convert(students); // Assuming studentDtoConverter is implemented
	        } else {
	            throw new ClassroomNotFoundException("Classroom not found with id: " + classroomId);
	        }
	}

}
