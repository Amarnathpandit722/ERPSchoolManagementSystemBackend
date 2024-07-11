package com.management.school.security.service;

import java.util.List;

import com.management.school.security.dto.AssignmentSubmissionDto;
import com.management.school.security.dto.request.assignment.submission.CreateSubmissionAssigningRequest;
import com.management.school.security.dto.request.assignment.submission.UpdateSubmissionAssignmentRequest;

public interface AssignmentSubmissionService {

	public void createAssignmentSubmission(CreateSubmissionAssigningRequest request,String submissionId);
	
	public AssignmentSubmissionDto getAssignemntById(String id);
	
	public List<AssignmentSubmissionDto> getAllAssignment();
	
	public void updateAssignmentSubmission(String id, UpdateSubmissionAssignmentRequest request);
	
	public void makeVerifiedAssignmentByTeacher(String id);
	
	public void makeUnVerifiedAssignmentByTeacher(String id);
	
	public List<AssignmentSubmissionDto> getPendingAssignment(String id);
	
	
}
