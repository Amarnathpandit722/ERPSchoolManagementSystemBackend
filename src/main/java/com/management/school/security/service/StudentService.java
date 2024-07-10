package com.management.school.security.service;

import java.util.List;

import com.management.school.security.dto.StudentDto;
import com.management.school.security.dto.request.student.CreateStudentRequest;
import com.management.school.security.dto.request.student.UpdateStudentRequest;
import com.management.school.security.model.Student;

public interface StudentService {
	
	public void createStudent(CreateStudentRequest request);
	
	public void updateStudent(String id, UpdateStudentRequest request) ;

	public void addStudentToClassroom(String id, String classroomId);
	
	 public void removeStudentFromClassroom(String id);
	 
	 public void deleteStudent(String id);
	 
	 public StudentDto findStudentById(String id);
	 
	 public List<StudentDto> findAllStudents();

	public Student findStudentByStudentId(String studentId);
	

}
