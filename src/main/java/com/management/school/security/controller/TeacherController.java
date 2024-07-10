package com.management.school.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.school.security.dto.TeacherDto;
import com.management.school.security.dto.request.techer.CreateTeacherRequest;
import com.management.school.security.dto.request.techer.UpdateTeacherRequest;
import com.management.school.security.exception.TeacherNotFoundException;
import com.management.school.security.service.TeacherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/teachers")
@Tag(name = "Teacher", description = "Teacher API")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;

	@Operation(summary = "Create Teacher", description = "Create Teacher", tags = { "Teacher" })
	@PostMapping("/add-teacher")
	public ResponseEntity<String> createTeacher(@Valid @RequestBody CreateTeacherRequest request) {
		try {
			teacherService.createTeacher(request);
			return ResponseEntity.ok("Teacher successfully created");
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to create teacher");
		}
	}

	@Operation(summary = "Update Teacher", description = "Update Teacher by id", tags = { "Teacher" })
	@PutMapping("/{id}")
	public ResponseEntity<String> updateTeacher(@PathVariable String id,
			@Valid @RequestBody UpdateTeacherRequest request) {
		try {
			teacherService.updateTeacher(id, request);
			return ResponseEntity.ok("Teacher successfully updated");
		} catch (TeacherNotFoundException ex) {
			return ResponseEntity.noContent().build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to update teacher");
		}
	}

	@Operation(summary = "Delete Teacher", description = "Delete Teacher by id", tags = { "Teacher" })
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTeacher(@PathVariable String id) {
		try {
			teacherService.deleteTeacher(id);
			return ResponseEntity.ok("Teacher successfully deleted");
		} catch (TeacherNotFoundException ex) {
			return ResponseEntity.noContent().build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to delete teacher");
		}
	}

	@Operation(summary = "Get Teacher", description = "Get Teacher by id", tags = { "Teacher" })
	@GetMapping("/{id}")
	public ResponseEntity<TeacherDto> findTeacherById(@PathVariable String id) {
		try {
			TeacherDto teacher = teacherService.findTeacherById(id);
			if (teacher == null) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(teacher);
		} catch (TeacherNotFoundException ex) {
			return ResponseEntity.noContent().build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@Operation(summary = "Get All Teachers", description = "Get All Teachers", tags = { "Teacher" })
	@GetMapping("/all")
	public ResponseEntity<List<TeacherDto>> findAllTeachers() {
		try {
			List<TeacherDto> teachers = teacherService.findAllTeachers();
			if (teachers.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(teachers);
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

}
