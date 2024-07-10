package com.management.school.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.school.security.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,String>{

	
	boolean existsByNationalId(Object unknownAttr1);

	Teacher findTeacherById(String teacherId);
}