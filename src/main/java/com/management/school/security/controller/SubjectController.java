package com.management.school.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.school.security.dto.SubjectDto;
import com.management.school.security.dto.request.subject.CreateSubjectRequest;
import com.management.school.security.dto.request.subject.UpdateSubjectRequest;
import com.management.school.security.exception.SubjectNotFoundException;
import com.management.school.security.service.SubjectService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/subject")
@Tag(name = "Subject", description = "Subject API")
@CrossOrigin
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	 @PostMapping("/add-new-subject")
	    public ResponseEntity<String> createSubject(@Valid @RequestBody CreateSubjectRequest request) {
		 try {
	            subjectService.createSubject(request);
	            return ResponseEntity.ok("Subject Created Successfully");
	        } catch (Exception ex) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<String> updateSubject(@PathVariable String id, @Valid @RequestBody UpdateSubjectRequest request) {
	    	try {
	            subjectService.updateSubject(id, request);
	            return ResponseEntity.ok("Subject Update Successfully");
	        } catch (SubjectNotFoundException ex) {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteSubject(@PathVariable String id) {
	    	try {
	            subjectService.deleteSubject(id);
	            return ResponseEntity.ok().build();
	        } catch (SubjectNotFoundException ex) {
	            return ResponseEntity.notFound().build();
	        } 
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<SubjectDto> findSubjectById(@PathVariable String id) {
	    	 try {
	    	        SubjectDto subjectDto = subjectService.findSubjectById(id);
	    	        if (subjectDto != null) {
	    	            return ResponseEntity.ok(subjectDto);
	    	        } else {
	    	            return ResponseEntity.noContent().build();
	    	        }
	    	    } catch (SubjectNotFoundException ex) {
	    	        return ResponseEntity.notFound().build();
	    	    } catch (Exception ex) {
	    	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    	    }
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<SubjectDto>> findAllSubjects() {
	    	 try {
	    	        List<SubjectDto> subjectDtos = subjectService.findAllSubjects();
	    	        if (!subjectDtos.isEmpty()) {
	    	            return ResponseEntity.ok(subjectDtos);
	    	        } else {
	    	            return ResponseEntity.noContent().build();
	    	        }
	    	    } catch (Exception ex) {
	    	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    	    }
	    }
	
	

}
