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

import com.management.school.security.dto.ClassroomDto;
import com.management.school.security.dto.StudentDto;
import com.management.school.security.dto.request.classroom.CreateClassroomRequest;
import com.management.school.security.dto.request.classroom.UpdateClassroomRequest;
import com.management.school.security.exception.AddressNotFoundException;
import com.management.school.security.exception.ClassroomNotFoundException;
import com.management.school.security.service.ClassroomService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/classrooms")
@Tag(name = "Classroom", description = "Classroom API")
@CrossOrigin
public class ClassroomController {

	@Autowired
	private ClassroomService classroomService;

	@Operation(summary = "Create a classroom", description = "Create a classroom", tags = { "Classroom" })
	@PostMapping("/add-new-classroom")
	public ResponseEntity<String> createClassroom(@Valid @RequestBody CreateClassroomRequest request) {

		try {
			classroomService.createClassroom(request);
			return ResponseEntity.ok("Classroom successfully created");
		} catch (ClassroomNotFoundException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to save data");

		}
	}

	@Operation(summary = "Update a classroom", description = "Update a classroom by id", tags = { "Classroom" })
	@PutMapping("/{id}")
	public ResponseEntity<String> updateClassroom(@PathVariable String id, @Valid UpdateClassroomRequest request) {
		try {
			classroomService.updateClassroom(id, request);
			return ResponseEntity.ok("Address Updated successfully");
		} catch (ClassroomNotFoundException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to save data");

		}

	}

	@Operation(summary = "Delete a classroom", description = "Delete a classroom by id", tags = { "Classroom" })
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteClassroom(@PathVariable String id) {

		try {
			classroomService.deleteClassroom(id);
			return ResponseEntity.ok("Classroom Deleted successfully ");
		} catch (AddressNotFoundException ex) {
			return ResponseEntity.noContent().build();
		}
	}

	@Operation(summary = "Get a classroom", description = "Get a classroom by id", tags = { "Classroom" })
	@GetMapping("/{id}")
	public ResponseEntity<ClassroomDto> findClassroomById(@PathVariable String id) {
		try {
			ClassroomDto classroom = classroomService.findClassroomById(id);
			return ResponseEntity.ok(classroom);
		} catch (ClassroomNotFoundException ex) {
			return ResponseEntity.noContent().build();
		}
	}

	@Operation(summary = "Get all classrooms", description = "Get all classrooms", tags = { "Classroom" })
	@GetMapping("/all")
	public ResponseEntity<List<ClassroomDto>> findAllClassrooms() {
		try {
			List<ClassroomDto> classromms = classroomService.findAllClassrooms();
			return ResponseEntity.ok(classromms);
		} catch (AddressNotFoundException ex) {
			return ResponseEntity.noContent().build();
		}
	}
	 @GetMapping("/{classroomId}/students")
	    public ResponseEntity<List<StudentDto>> getStudentsByClassroomId(@PathVariable("classroomId") String classroomId) {
		 List<StudentDto> students = classroomService.getStudentsByClassroomId(classroomId);
	        if (students.isEmpty()) {
	            return ResponseEntity.noContent().build();
	        }
	        return ResponseEntity.ok(students);
	    }
}
