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

import com.management.school.security.dto.StudentDto;
import com.management.school.security.dto.request.student.CreateStudentRequest;
import com.management.school.security.dto.request.student.UpdateStudentRequest;
import com.management.school.security.exception.StudentNotFoundException;
import com.management.school.security.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/students")
@Tag(name = "Student", description = "Student API")
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Operation(summary = "Create Student", description = "Create Student", tags = { "Student" })
	@PostMapping("add-student")
	public ResponseEntity<String> createStudent(@Valid @RequestBody CreateStudentRequest request) {
		try {
			studentService.createStudent(request);
			return ResponseEntity.ok("Student successfully created");
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to save data");
		}
	}

	@Operation(summary = "Update Student", description = "Update Student by id", tags = { "Student" })
	@PutMapping("/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable String id, @Valid UpdateStudentRequest request) {

		try {
			studentService.updateStudent(id, request);
			return ResponseEntity.ok("Student successfully updated");
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to save data");
		}
	}

	@Operation(summary = "Add Student to Classroom", description = "Add Student to Classroom by student id and classroom id", tags = {
			"Student" })
	@PutMapping("/{id}/classroom/{classroomId}")
	public ResponseEntity<String> addStudentToClassroom(@PathVariable String id, @PathVariable String classroomId) {
		try {
			studentService.addStudentToClassroom(id, classroomId);
			return ResponseEntity.ok("Student successfully added to classroom");
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to add student to classroom");
		}
	}

	@Operation(summary = "Remove Student from Classroom", description = "Remove Student from Classroom by student id", tags = {
			"Student" })
	@PutMapping("/{id}/classroom/remove")
	public ResponseEntity<String> removeStudentFromClassroom(@PathVariable String id) {

		try {
			studentService.removeStudentFromClassroom(id);
			return ResponseEntity.ok("Student successfully remove from classroom");
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to add student to classroom");
		}
	}

	@Operation(summary = "Delete Student", description = "Delete Student by id", tags = { "Student" })
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable String id) {
		try {
			studentService.deleteStudent(id);
			return ResponseEntity.ok("Student successfully deleted");
		} catch (StudentNotFoundException ex) {
			return ResponseEntity.noContent().build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to delete student");
		}
	}

	@Operation(summary = "Get Student", description = "Get Student by id", tags = { "Student" })
	@GetMapping("/{id}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable String id) {
		try {
			StudentDto student = studentService.findStudentById(id);
			if (student == null) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(student);
		} catch (StudentNotFoundException ex) {
			return ResponseEntity.noContent().build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@Operation(summary = "Get All Students", description = "Get All Students", tags = { "Student" })
	@GetMapping("/all")
	public ResponseEntity<List<StudentDto>> getAllStudents() {
		List<StudentDto> students = studentService.findAllStudents();
		if (students.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(students);
	}

}
