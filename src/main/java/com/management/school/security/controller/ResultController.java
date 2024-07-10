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

import com.management.school.security.dto.ResultDto;
import com.management.school.security.dto.request.result.CreateResultRequest;
import com.management.school.security.dto.request.result.UpdateResultRequest;
import com.management.school.security.exception.ClassroomNotFoundException;
import com.management.school.security.exception.ResultNotFoundException;
import com.management.school.security.exception.StudentNotFoundException;
import com.management.school.security.exception.TeacherNotFoundException;
import com.management.school.security.service.ResultService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/result")
@Tag(name = "Result", description = "Result API")
@CrossOrigin
public class ResultController {
	@Autowired
	 private ResultService resultService;
	
	@Operation(summary = "Create Result", description = "Create a new Result", tags = {"Result"})
    @PostMapping("/add-new-result")
    public ResponseEntity<String> createResult(@Valid @RequestBody CreateResultRequest request) {
		try {
            resultService.createResult(request);
            return ResponseEntity.ok("Result Added Successsfully");
        } catch (StudentNotFoundException ex) {            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to save data Due to Student Not Found");
        }
		catch (ClassroomNotFoundException ex) {            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to save data Due to Invalid Classroom");
        }
		catch (TeacherNotFoundException ex) {            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to save data Due to Teacher is Not Available");
        }
		
    }

    @Operation(summary = "Update Result", description = "Update an existing Result by ID", tags = {"Result"})
    @PutMapping("/{id}")
    public ResponseEntity<String> updateResult(@PathVariable String id, @Valid @RequestBody UpdateResultRequest request) {
    	 try {
             resultService.updateResult(id, request);
             return ResponseEntity.ok("Result Updated Successfully");
         } catch (ResultNotFoundException ex) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to save data");
         } catch (Exception ex) {
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
    }

    @Operation(summary = "Delete Result", description = "Delete a Result by ID", tags = {"Result"})
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResult(@PathVariable String id) {
    	 try {
             resultService.deleteResult(id);
             return ResponseEntity.ok("Result Deleted Succcessfully ");
         } catch (ResultNotFoundException ex) {
             // Handle case where result with given ID is not found
             return ResponseEntity.notFound().build();
         } catch (Exception e) {
             // Handle other exceptions like database errors, unexpected errors, etc.
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }    }

    @Operation(summary = "Get Result by ID", description = "Retrieve a Result by ID", tags = {"Result"})
    @GetMapping("/{id}")
    public ResponseEntity<ResultDto> findResultById(@PathVariable String id) {
    	 ResultDto resultDto = resultService.findResultById(id);

         if (resultDto != null) {
             return ResponseEntity.ok(resultDto);
         } else {
             return ResponseEntity.notFound().build();
         }
    }

    @Operation(summary = "Get All Results", description = "Retrieve all Results", tags = {"Result"})
    @GetMapping("/all")
    public ResponseEntity<List<ResultDto>> findAllResults() {
    	 List<ResultDto> resultDtos = resultService.findAllResults();

         if (resultDtos.isEmpty()) {
             return ResponseEntity.noContent().build();
         } else {
             return ResponseEntity.ok(resultDtos);
         }
    }

    @Operation(summary = "Get All Results By Clasromm & Student", description = "Retrieve all Results", tags = {"Result"})
    @GetMapping("/all/{classroomId}/{studentId}")
    public ResponseEntity<List<ResultDto>> findAllResultsByClassroomAndStudent(@PathVariable String classroomId,@PathVariable String studentId) {
    	 List<ResultDto> resultDtos = resultService.findAllResultsByClassAndStudent(classroomId,studentId);

         if (resultDtos.isEmpty()) {
             return ResponseEntity.noContent().build();
         } else {
             return ResponseEntity.ok(resultDtos);
         }
    }

	
	
	
	

}
