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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.management.school.security.dto.AdmissionFeeStructureDto;
import com.management.school.security.dto.request.admission.fee.CreateAdmissionFeeStrucureRequest;
import com.management.school.security.dto.request.admission.fee.UpdateAdmissionFeeStructureRequest;
import com.management.school.security.model.AdmissionFeeStructure;
import com.management.school.security.model.FyYear;
import com.management.school.security.service.AdmissionFeeStructureService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/admissionFeeStrucure")
@Tag(name = "admissionFeeStrucure", description = "admissionFeeStrucure API")
public class AdmissionFeeStructureController {
	
	@Autowired
	private AdmissionFeeStructureService admissionFeeStructureService;
	
	 @PostMapping("/add")
	    public ResponseEntity<String> createAdmissionFeeStructure(@Valid @RequestBody CreateAdmissionFeeStrucureRequest request) {
	        try {
	            admissionFeeStructureService.createAdmissionFeeStructure(request);
	            return ResponseEntity.status(HttpStatus.CREATED).body("Admission fee structure successfully created.");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to save admission fee structure.");
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<String> updateAdmissionFeeStructure(@PathVariable String id, @Valid @RequestBody UpdateAdmissionFeeStructureRequest request) {
	        try {
	            admissionFeeStructureService.updateAdmissionFeeStrcutre(id, request);
	            return ResponseEntity.ok("Admission fee structure successfully updated.");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to update admission fee structure.");
	        }
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<AdmissionFeeStructureDto> getAdmissionFeeById(@PathVariable String id) {
	        try {
	            AdmissionFeeStructureDto admissionFeeStructureDto = admissionFeeStructureService.getAdmissionFeeById(id);
	            return ResponseEntity.ok(admissionFeeStructureDto);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	        }
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<AdmissionFeeStructureDto>> getAllAdmissionFeeStructures() {
	        List<AdmissionFeeStructureDto> admissionFeeStructures = admissionFeeStructureService.getAllAdmisssionFee();
	        return ResponseEntity.ok(admissionFeeStructures);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteAdmissionFeeStructure(@PathVariable String id) {
	        try {
	            admissionFeeStructureService.deleteAdmissionFeeStructure(id);
	            return ResponseEntity.ok("Admission fee structure successfully deleted.");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to delete admission fee structure.");
	        }
	    }
	
	    
	    @PostMapping("/addFyYear")
	    public ResponseEntity<String> saveFyYear(@RequestParam String fyYear) {
	    	try {
	    	
	    	admissionFeeStructureService.saveFyYear(fyYear);	    	
	    	 return ResponseEntity.ok("Fy Year Successfully Added");
	    	 } catch (Exception e) {
		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to delete admission fee structure.");
		        }
	    }
	    
	    @GetMapping("/fyYear/all")
	    public List<FyYear> getAllFyYear() {
	    	return admissionFeeStructureService.getAllfyYear();
	    }
	    
	    @GetMapping("/fee")
	    public List<AdmissionFeeStructure> getAllFyYearByFyYearWise( @RequestParam("fyYearId") String fyYearId) {
	    	return admissionFeeStructureService.getAllfyYearByYearWise(fyYearId);
	    }
	    
	
	

}
