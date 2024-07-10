package com.management.school.security.dto;

import java.util.List;

public record StudentDto(
		 String id,
	        String firstName,
	        String lastName,
	        String nationalId,
	        String studentNumber,
	        String fatherName,
	        String fatherPhone,
	        String motherName,
	        String motherPhone,
	        List<AddressDto> addressList,
	        String classroomId) {

}
