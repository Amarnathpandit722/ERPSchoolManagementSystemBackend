package com.management.school.security.dto;


import java.util.Date;

public record SubjectDto(
		String id,
		String name,
		String description,
		String subjectCode,
		String teacherId,
		String classroomId,
		Date createdDate,
		Date updatedDate
		
		
		) {

}
