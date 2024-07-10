package com.management.school.security.dto;

import java.util.Date;
import java.util.List;

public record ResultDto(
		String id,
		Date createdDate,
		Date updatedDate,
		String classroomId,
			List<SubjectResultDto> subjectResult,
			String studentId
		) {

}
