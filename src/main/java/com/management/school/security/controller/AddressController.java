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

import com.management.school.security.dto.AddressDto;
import com.management.school.security.dto.request.address.CreateAddressRequest;
import com.management.school.security.dto.request.address.UpdateAddressRequest;
import com.management.school.security.exception.AddressNotFoundException;
import com.management.school.security.service.AddressService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/addresses")
@Tag(name = "Address", description = "Address API")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	 @Operation(summary = "Create Address",
	            description = "Create Address",
	            tags = {"Address"})
@PostMapping("/add-new-address")
public ResponseEntity<String> createAddress(@RequestBody @Valid CreateAddressRequest request) {
	
    try {
    	addressService.createAddress(request);
        return ResponseEntity.ok("Address successfully created");
    } catch (AddressNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to save data");
    }
    
}

	 @Operation(summary = "Update Address",
	            description = "Update Address by id",
	            tags = {"Address"})
	    @PutMapping("/{id}")
	    public ResponseEntity<String> updateAddress(@PathVariable String id,
	                                              @Valid UpdateAddressRequest request) {
	        try {
	        	addressService.updateAddress(id, request);
	            return ResponseEntity.ok("Address Updated successfully ");
	        } catch (AddressNotFoundException ex) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable to save data");
	        }
	    }

	    @Operation(summary = "Delete Address",
	            description = "Delete Address by Id",
	            tags = {"Address"})
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteAddress(@PathVariable String id) {
	    	try {
	            addressService.deleteAddress(id);
	            return ResponseEntity.ok("Address Deleted successfully ");
	        } catch (AddressNotFoundException ex) {
	            return ResponseEntity.noContent().build();
	        }
	    }

	    @Operation(summary = "Get Address",
	            description = "Get Address by Id",
	            tags = {"Address"})
	    @GetMapping("/{id}")
	    public ResponseEntity<AddressDto> findAddressById(@PathVariable String id) {
	    	 try {
	             AddressDto address = addressService.findAddressById(id);
	             return ResponseEntity.ok(address);
	         } catch (AddressNotFoundException ex) {
	             return ResponseEntity.noContent().build();
	         }
	    }

	    @Operation(summary = "Get All Addresses",
	            description = "Get All Addresses",
	            tags = {"Address"})
	    @GetMapping("/all")
	    public ResponseEntity<List<AddressDto>> findAllAddresses() {
			try {
				List<AddressDto> addresses = addressService.findAllAddresses();
				return ResponseEntity.ok(addresses);
			} catch (AddressNotFoundException ex) {
				return ResponseEntity.noContent().build();
			}
	    }
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
