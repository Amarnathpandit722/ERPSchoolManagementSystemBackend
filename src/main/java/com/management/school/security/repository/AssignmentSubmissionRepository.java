package com.management.school.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.management.school.security.model.AssignmentSubmission;

@Repository
public interface AssignmentSubmissionRepository extends JpaRepository<AssignmentSubmission, String> {

	
	AssignmentSubmission findByAssignmentIdAndStudentId(String assignmentId, String studentId);

	@Query("SELECT a FROM AssignmentSubmission a WHERE a.student.id = :id AND a.status = 'PENDING'")
	List<AssignmentSubmission> findByStudentAndStatusPending(@Param("id") String id);


}
