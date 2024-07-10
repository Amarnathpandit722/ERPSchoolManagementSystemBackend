package com.management.school.security.service.impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.school.security.dto.SubjectDto;
import com.management.school.security.dto.converter.SubjectDtoConverter;
import com.management.school.security.dto.request.subject.CreateSubjectRequest;
import com.management.school.security.dto.request.subject.UpdateSubjectRequest;
import com.management.school.security.helper.GenerateSubjectName;
import com.management.school.security.helper.SubjectNotFoundException;
import com.management.school.security.model.Classroom;
import com.management.school.security.model.Subject;
import com.management.school.security.model.Teacher;
import com.management.school.security.repository.SubjectRepository;
import com.management.school.security.service.ClassroomService;
import com.management.school.security.service.SubjectService;
import com.management.school.security.service.TeacherService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private SubjectDtoConverter converter;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private ClassroomService classroomService;

	@Transactional
	@Override
	public void createSubject(CreateSubjectRequest request) {
		Subject subject = new Subject();
		subject.setName(request.getSubjectName());
		String subjectName = GenerateSubjectName.generate();
		StringBuilder sb = new StringBuilder(subjectName);
		sb.append("-");
		sb.append(request.getSubjectCode());
		sb.append("-");
		sb.append(request.getSubjectName());
		subject.setSubjectCode(sb.toString());
		subject.setDescription(request.getDescription());
		Teacher teacher = teacherService.findTeacherByTeacherId(request.getTeacherId());

		subject.setTeacher(teacher);

		Classroom clasroom = classroomService.findClassroomByClassroomId(request.getClassroomId());
		subject.setClassroom(clasroom);
		subject.setCreatedDate(new Date(System.currentTimeMillis()));
		subject.setUpdatedDate(new Date(System.currentTimeMillis()));

		 try {
	            subjectRepository.save(subject);
	            } catch (Exception e) {
	            throw new RuntimeException("Failed to save subject", e);
	        }
		
	}

	@Override
	public void updateSubject(String id, UpdateSubjectRequest request) {
		Subject subject = subjectRepository.findById(id)
				.orElseThrow(() -> new SubjectNotFoundException("Subject not found with id: " + id));
		
		subject.setTeacher(subject.getTeacher());
		String subjectName = GenerateSubjectName.generate();
		StringBuilder sb = new StringBuilder(subjectName);
		sb.append("-");
		sb.append(request.getSubjectCode());
		sb.append("-");
		sb.append(request.getSubjectName());
		subject.setSubjectCode(sb.toString());
		subject.setName(request.getSubjectName());
		subject.setUpdatedDate(new Date(System.currentTimeMillis()));
		subject.setDescription(request.getDescription());
		subjectRepository.save(subject);

		
	}

	@Override
	public void deleteSubject(String id) {
		Subject subject = subjectRepository.findById(id)
				.orElseThrow(() -> new SubjectNotFoundException("Subject not found with id: " + id));

		subjectRepository.delete(subject);

	}

	@Override
	public SubjectDto findSubjectById(String id) {
		Subject subject = subjectRepository.findById(id)
				.orElseThrow(() -> new SubjectNotFoundException("Subject not found with id: " + id));

		return converter.convert(subject);
	}

	@Override
	public List<SubjectDto> findAllSubjects() {
		List<Subject> subjects = subjectRepository.findAll();
		return subjects.stream().map(converter::convert).collect(Collectors.toList());
	}

}
