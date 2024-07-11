package com.management.school.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.management.school.security.dto.AssignmentSubmissionDto;
import com.management.school.security.dto.request.assignment.submission.CreateSubmissionAssigningRequest;
import com.management.school.security.dto.request.assignment.submission.UpdateSubmissionAssignmentRequest;
import com.management.school.security.service.AssignmentSubmissionService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/assignment-submissions")
@Validated
@Tag(name = "Assignemnt Submission", description = "Assignment Submission")
@CrossOrigin
public class AssignmentSubmissionController {

	@Autowired
	private  AssignmentSubmissionService assignmentSubmissionService;

	
	 @PostMapping("/add")
	    public ResponseEntity<String> createAssignmentSubmission(
	            @ModelAttribute @Valid CreateSubmissionAssigningRequest request,
	            @RequestParam String submissionId) {
	        try {
	            assignmentSubmissionService.createAssignmentSubmission(request, submissionId);
	            return ResponseEntity.status(HttpStatus.CREATED).body("Assignment submission successfully created");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to save data");
	        }
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<AssignmentSubmissionDto> getAssignmentById(@PathVariable String id) {
	        AssignmentSubmissionDto assignmentSubmissionDto = assignmentSubmissionService.getAssignemntById(id);
	        if (assignmentSubmissionDto != null) {
	            return ResponseEntity.ok(assignmentSubmissionDto);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<AssignmentSubmissionDto>> getAllAssignments() {
	        List<AssignmentSubmissionDto> assignments = assignmentSubmissionService.getAllAssignment();
	        return ResponseEntity.ok(assignments);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<String> updateAssignmentSubmission(
	            @PathVariable String id,
	            @RequestBody @Valid UpdateSubmissionAssignmentRequest request) {
	        try {
	            assignmentSubmissionService.updateAssignmentSubmission(id, request);
	            return ResponseEntity.ok("Assignment submission successfully updated");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to update data");
	        }
	    }

	    @PutMapping("/verify/{id}")
	    public ResponseEntity<String> makeVerifiedAssignmentByTeacher(@PathVariable String id) {
	        try {
	            assignmentSubmissionService.makeVerifiedAssignmentByTeacher(id);
	            return ResponseEntity.ok("Assignment successfully verified");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to verify assignment");
	        }
	    }

	    @PutMapping("/unverify/{id}")
	    public ResponseEntity<String> makeUnVerifiedAssignmentByTeacher(@PathVariable String id) {
	        try {
	            assignmentSubmissionService.makeUnVerifiedAssignmentByTeacher(id);
	            return ResponseEntity.ok("Assignment successfully unverified");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to unverify assignment");
	        }
	    }

	    @GetMapping("/pending/{studentId}")
	    public ResponseEntity<List<AssignmentSubmissionDto>> getPendingAssignments(@PathVariable String studentId) {
	        List<AssignmentSubmissionDto> pendingAssignments = assignmentSubmissionService.getPendingAssignment(studentId);
	        return ResponseEntity.ok(pendingAssignments);
	    }
	
	
}
