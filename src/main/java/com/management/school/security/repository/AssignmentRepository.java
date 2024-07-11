package com.management.school.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.school.security.model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, String>{

	List<Assignment> findByTeacherId(String teacherId);

	List<Assignment> findBySubjectId(String subjectId);

	
}
