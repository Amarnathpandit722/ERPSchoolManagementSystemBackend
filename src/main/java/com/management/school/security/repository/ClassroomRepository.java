package com.management.school.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.school.security.model.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, String> {

	Classroom findClassroomById(String classroomId);
	
	

}
