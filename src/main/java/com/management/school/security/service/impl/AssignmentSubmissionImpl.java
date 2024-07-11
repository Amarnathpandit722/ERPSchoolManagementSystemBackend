package com.management.school.security.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.school.security.dto.AssignmentSubmissionDto;
import com.management.school.security.dto.converter.AssignmentSubmissionDtoConverter;
import com.management.school.security.dto.request.assignment.submission.CreateSubmissionAssigningRequest;
import com.management.school.security.dto.request.assignment.submission.UpdateSubmissionAssignmentRequest;
import com.management.school.security.exception.AssignmentNotfound;
import com.management.school.security.exception.AssignmentSubmissionNotFound;
import com.management.school.security.exception.StudentNotFoundException;
import com.management.school.security.model.Assignment;
import com.management.school.security.model.AssignmentSubmission;
import com.management.school.security.model.Status;
import com.management.school.security.model.Student;
import com.management.school.security.repository.AssignmentRepository;
import com.management.school.security.repository.AssignmentSubmissionRepository;
import com.management.school.security.repository.StudentRepository;
import com.management.school.security.repository.TeacherRepository;
import com.management.school.security.service.AssignmentSubmissionService;

@Service
public class AssignmentSubmissionImpl implements AssignmentSubmissionService {

	@Autowired
	private AssignmentSubmissionRepository assignmentSubmissionRepository;

	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private AssignmentSubmissionDtoConverter submissionDtoConverter;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private AssignmentRepository assignmentRepository;

	@Override
	public void createAssignmentSubmission(CreateSubmissionAssigningRequest request,String submissionId) {
		
		AssignmentSubmission assignmentSubmission = assignmentSubmissionRepository.findById(submissionId).orElseThrow(()->new AssignmentSubmissionNotFound("Not found with this ID"+submissionId));
		
		// Fetch Assignment entity from repository
		Assignment assignment = assignmentRepository.findById(request.getAssignmentId()).orElseThrow(
				() -> new AssignmentNotfound("Assignment not found with id: " + request.getAssignmentId()));

		// Fetch Student entity from repository
		Student student = studentRepository.findById(request.getStudentId()).orElseThrow(
				() -> new StudentNotFoundException("Student not found with id: " + request.getStudentId()));

		assignmentSubmission.setAssignment(assignment);
		assignmentSubmission.setStudent(student);
		assignmentSubmission.setSubmissionText(request.getSubmissionText());
		Date localdate = new Date(System.currentTimeMillis());
		assignmentSubmission.setSubmittedAt(localdate);
		assignmentSubmission.setStatus(Status.PENDING);

		// Save AssignmentSubmission entity to repository
		assignmentSubmissionRepository.save(assignmentSubmission);

	}

	@Override
	public AssignmentSubmissionDto getAssignemntById(String id) {
		AssignmentSubmission submission = assignmentSubmissionRepository.findById(id)
				.orElseThrow(() -> new AssignmentNotfound("Assignment Submission not found with id: " + id));

		// Convert Entity to DTO using Converter
		return submissionDtoConverter.convert(submission);
	}

	@Override
	public List<AssignmentSubmissionDto> getAllAssignment() {
		List<AssignmentSubmission> submissions = assignmentSubmissionRepository.findAll();
		// Convert List of Entities to List of DTOs using Converter
		return submissionDtoConverter.convert(submissions);
	}

	@Override
	public void updateAssignmentSubmission(String id, UpdateSubmissionAssignmentRequest request) {
		AssignmentSubmission submission = assignmentSubmissionRepository.findById(id).orElse(null);
		Assignment assigment = assignmentRepository.findById(request.getAssignmentId()).orElse(null);

		if (submission != null && assigment != null) {

			submission.setSubmissionText(request.getSubmissionText());
			Date localdate = new Date(System.currentTimeMillis());
			submission.setSubmittedAt(localdate);
			submission.setStatus(Status.PENDING);
			assignmentSubmissionRepository.save(submission);


		}

	}

	@Override
	public void makeVerifiedAssignmentByTeacher(String id) {
		AssignmentSubmission submission = assignmentSubmissionRepository.findById(id).orElse(null);

		if (submission != null) {
			submission.setStatus(Status.VERIFIED);
			assignmentSubmissionRepository.save(submission);
		}
	}

	@Override
	public void makeUnVerifiedAssignmentByTeacher(String id) {
		AssignmentSubmission submission = assignmentSubmissionRepository.findById(id).orElse(null);

		if (submission != null) {
			submission.setStatus(Status.DISCREPENCANY_FOUND);
			assignmentSubmissionRepository.save(submission);

		}
	}

	@Override
	public List<AssignmentSubmissionDto> getPendingAssignment(String id) {
		List<AssignmentSubmission> assignmentSubmission = assignmentSubmissionRepository.findByStudentAndStatusPending(id);
		return submissionDtoConverter.convert(assignmentSubmission);
		 
	}

}
