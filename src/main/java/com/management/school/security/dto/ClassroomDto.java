package com.management.school.security.dto;

import java.util.List;

public record ClassroomDto(
		String id,
	    String name,
	    String description,
	    String teacherId,
	    List<ClassroomStudentDto> studentList) {

}
