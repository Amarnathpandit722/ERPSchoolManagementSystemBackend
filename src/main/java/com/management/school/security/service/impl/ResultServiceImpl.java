package com.management.school.security.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.school.security.dto.ResultDto;
import com.management.school.security.dto.SubjectResultDto;
import com.management.school.security.dto.converter.ResultDtoConverter;
import com.management.school.security.dto.request.result.CreateResultRequest;
import com.management.school.security.dto.request.result.UpdateResultRequest;
import com.management.school.security.dto.request.subjectresult.BaseSubjectResultRequest;
import com.management.school.security.dto.request.subjectresult.CreateSubjectResultRequest;
import com.management.school.security.exception.ClassroomNotFoundException;
import com.management.school.security.exception.ResultNotFoundException;
import com.management.school.security.exception.StudentNotFoundException;
import com.management.school.security.exception.TeacherNotFoundException;
import com.management.school.security.model.Classroom;
import com.management.school.security.model.Result;
import com.management.school.security.model.SubjectResult;
import com.management.school.security.model.Student;
import com.management.school.security.model.Subject;
import com.management.school.security.model.Teacher;
import com.management.school.security.repository.ClassroomRepository;
import com.management.school.security.repository.ResultRepository;
import com.management.school.security.repository.StudentRepository;
import com.management.school.security.repository.SubjectRepository;
import com.management.school.security.repository.TeacherRepository;
import com.management.school.security.service.ResultService;
import com.management.school.security.service.StudentService;
import com.management.school.security.service.SubjectService;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultRepository resultRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ClassroomRepository classroomRepository;
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private TeacherRepository teacherRespository;

	@Autowired
	private ResultDtoConverter converter;

	@Override
	public void createResult(CreateResultRequest request) {
		Result result = new Result();
		Optional<Student> optionalStudent = studentRepository.findById(request.getStudentId());
		if (optionalStudent.isEmpty()) {
			throw new StudentNotFoundException("Student Not found with Id : " + request.getStudentId());
		}
		result.setStudent(optionalStudent.get());

		result.setClassroom(classroomRepository.findClassroomById(request.getClassroomId()));
		result.setCreatedDate(new Date(System.currentTimeMillis()));
		result.setUpdatedDate(new Date(System.currentTimeMillis()));

		List<SubjectResult> subjectResults = new ArrayList<>();

		for (CreateSubjectResultRequest srRequest : request.getSubjectResult()) {
			SubjectResult subjectResult = new SubjectResult();
			subjectResult.setGrade(srRequest.getGrade());
			subjectResult.setRemarks(srRequest.getRemarks());
			subjectResult.setSubject(subjectRepository.findSubjectById(srRequest.getSubjectId()));
			subjectResult.setTeacher(teacherRespository.findTeacherById(srRequest.getTeacherId()));
			subjectResult.setResult(result);
			subjectResults.add(subjectResult);
		}

		result.setSubjectResults(subjectResults);
		resultRepository.save(result);

	}

	@Override
	public void updateResult(String id, UpdateResultRequest request) {
		Result result = resultRepository.findById(id)
				.orElseThrow(() -> new ResultNotFoundException("Result not found with id: " + id));

		List<SubjectResult> subjectResults = new ArrayList<>();
		for (CreateSubjectResultRequest srRequest : request.getSubjectResult()) {
			SubjectResult subjectResult = new SubjectResult();
			subjectResult.setGrade(srRequest.getGrade());
			subjectResult.setRemarks(srRequest.getRemarks());
			subjectResult.setSubject(subjectRepository.findSubjectById(srRequest.getSubjectId()));
			subjectResult.setTeacher(teacherRespository.findTeacherById(srRequest.getTeacherId()));
			subjectResult.setResult(result);
			subjectResults.add(subjectResult);

		}
		result.setSubjectResults(subjectResults);

		result.setUpdatedDate(new Date(System.currentTimeMillis()));

		resultRepository.save(result);

	}

	@Override
	public void deleteResult(String id) {
		Result result = resultRepository.findById(id)
				.orElseThrow(() -> new ResultNotFoundException("Result not found with id: " + id));

		resultRepository.delete(result);

	}

	@Override
	public ResultDto findResultById(String id) {
		Result result = resultRepository.findById(id)
				.orElseThrow(() -> new ResultNotFoundException("Result not found with id: " + id));

		return converter.convert(result);
	}

	@Override
	public List<ResultDto> findAllResults() {
		List<Result> results = resultRepository.findAll();

		return results.stream().map(converter::convert) // Using converter to map each Result to ResultDto
				.collect(Collectors.toList());
	}

	@Override
	public List<ResultDto> findAllResultsByClassAndStudent(String classroomId, String studentId) {
		Classroom classroom = classroomRepository.findById(classroomId).orElseThrow(()-> new ClassroomNotFoundException("Classroom not found with Id :"+classroomId));
		Student  student  =studentRepository.findById(studentId).orElseThrow(()->new StudentNotFoundException("Student Not Found with Id: "+studentId));
		
        List<Result> results = resultRepository.findByClassroomAndStudent(classroom, student);
        
        return results.stream().map(converter::convert) // Using converter to map each Result to ResultDto
				.collect(Collectors.toList());
		
		
		
	}

}
