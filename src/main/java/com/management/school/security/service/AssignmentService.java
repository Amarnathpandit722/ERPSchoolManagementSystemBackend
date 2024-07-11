package com.management.school.security.service;

import java.util.List;

import com.management.school.security.dto.AssignementDto;
import com.management.school.security.dto.request.assignment.assigning.CreateAssigningAssignmentRequest;


public interface AssignmentService {
	
	
	public void createAssignment(CreateAssigningAssignmentRequest assignment);

    public AssignementDto getAssignmentById(String id);

    List<AssignementDto> getAllAssignments();

    List<AssignementDto> getAssignmentsByTeacher(String teacherId);

    List<AssignementDto> getAssignmentsBySubject(String subjectId);

    void deleteAssignment(String id);

    boolean isAssignmentSubmitted(String assignmentId, String studentId);

	public String assignedToStudent(String assignmentId, String studentId);

}
