package com.management.school.security.service;

import java.util.List;

import com.management.school.security.dto.ClassroomDto;
import com.management.school.security.dto.StudentDto;
import com.management.school.security.dto.request.classroom.CreateClassroomRequest;
import com.management.school.security.dto.request.classroom.UpdateClassroomRequest;
import com.management.school.security.model.Classroom;

public interface ClassroomService {
	
	public void createClassroom(CreateClassroomRequest request);
	
	 public void updateClassroom(String id, UpdateClassroomRequest request);

	 public void deleteClassroom(String id);
	 
	 public ClassroomDto findClassroomById(String id);
	 
	 public List<ClassroomDto> findAllClassrooms();

	public Classroom findClassroomByClassroomId(String classroomId);

	public List<StudentDto> getStudentsByClassroomId(String classroomId);
}
