package com.management.school.security.service;

import java.util.List;

import com.management.school.security.dto.TeacherDto;
import com.management.school.security.dto.request.techer.CreateTeacherRequest;
import com.management.school.security.dto.request.techer.UpdateTeacherRequest;
import com.management.school.security.model.Teacher;

public interface TeacherService {
	
	public void createTeacher(CreateTeacherRequest request);
	
	public void updateTeacher(String id, UpdateTeacherRequest request);

	
	public void deleteTeacher(String id);
	
	public TeacherDto findTeacherById(String id);
	
	public List<TeacherDto> findAllTeachers();

	public Teacher findTeacherByTeacherId(String teacherId);
	
	
}
