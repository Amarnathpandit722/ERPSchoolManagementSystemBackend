package com.management.school.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.school.security.dto.AssignementDto;
import com.management.school.security.dto.request.assignment.assigning.CreateAssigningAssignmentRequest;
import com.management.school.security.dto.request.assignment.assigning.UpdateAssigningAssignmentRequest;
import com.management.school.security.service.AssignmentService;
import com.management.school.security.service.AssignmentSubmissionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/assignments")
@Tag(name = "Assignemnt", description = "Assignment API")
@CrossOrigin
public class AssignmentController {
	
	@Autowired
	private AssignmentService assignmentService;
	
	@Autowired AssignmentSubmissionService assignmentSubmissionService;
	

	@Operation(summary = "Create a CreateAssigningAssignmentRequest", description = "Create a CreateAssigningAssignmentRequest", tags = { "Assignment" })
    @PostMapping("/create")
    public ResponseEntity<String> createAssignment(@Valid @ModelAttribute CreateAssigningAssignmentRequest request) {
		try {
	        assignmentService.createAssignment(request);
	        return ResponseEntity.status(HttpStatus.CREATED).body("Assignment successfully created");
	    } catch (Exception e) {
	        // Log the exception (optional)
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to save data");
	    }
    }

	@Operation(summary = "Update a Assignment", description = "Update a Assignment by id", tags = { "Assignment" })
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAssignment(@PathVariable String id, @Valid @RequestBody UpdateAssigningAssignmentRequest request) {
//        assignmentService.updateAssignment(id, request);
        return ResponseEntity.ok("Assignment updated successfully");
    }

	@Operation(summary = "Delete a Assignment", description = "Delete a Assignment by id", tags = { "Assignment" })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAssignment(@PathVariable String id) {
        assignmentService.deleteAssignment(id);
        return ResponseEntity.ok("Assignment deleted successfully");
    }

	@Operation(summary = "Get a Assignment", description = "Get a Assignment by id", tags = { "Assignment" })
    @GetMapping("/{id}")
    public ResponseEntity<AssignementDto> getAssignmentById(@PathVariable String id) {
        AssignementDto assignment = assignmentService.getAssignmentById(id);
        if (assignment != null) {
            return ResponseEntity.ok(assignment);
        }
        return ResponseEntity.notFound().build();
    }

	@Operation(summary = "Get all Assignment", description = "Get all Assignment", tags = { "Assignment" })
    @GetMapping("/all")
    public ResponseEntity<List<AssignementDto>> getAllAssignments() {
		 List<AssignementDto> assignments = assignmentService.getAllAssignments();
		    
		    if (assignments == null || assignments.isEmpty()) {
		        return ResponseEntity.noContent().build();
		    } else {
		        return ResponseEntity.ok(assignments);
		    }
    }

    // GET endpoint to retrieve assignments by teacher ID
    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<AssignementDto>> getAssignmentsByTeacher(@PathVariable String teacherId) {
        List<AssignementDto> assignments = assignmentService.getAssignmentsByTeacher(teacherId);
        if (assignments == null || assignments.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.ok(assignments);
	    }
    }

    // GET endpoint to retrieve assignments by subject ID
    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<List<AssignementDto>> getAssignmentsBySubject(@PathVariable String subjectId) {
        List<AssignementDto> assignments = assignmentService.getAssignmentsBySubject(subjectId);
        if (assignments == null || assignments.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.ok(assignments);
	    }
    }

    // GET endpoint to check if assignment is submitted by student
    @GetMapping("/submitted/{assignmentId}/{studentId}")
    public ResponseEntity<Boolean> isAssignmentSubmitted(
            @PathVariable String assignmentId,
            @PathVariable String studentId) {
        boolean submitted = assignmentService.isAssignmentSubmitted(assignmentId, studentId);
        return ResponseEntity.ok(submitted);
    }

    @PostMapping("/assigned/{assignmentId}/{studentId}")
    public ResponseEntity<String> assignmentAssignedToStudent(
            @PathVariable String assignmentId,
            @PathVariable String studentId) {
    	 try {
    	        assignmentService.assignedToStudent(assignmentId, studentId);
    	        return ResponseEntity.ok("Assignment successfully assigned to student");
    	    } catch (Exception e) {
    	        // Log the exception (optional)
    	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to save data");
    	    }
    }
    
}
