package com.management.school.security.dto;

import java.util.Date;
import java.util.List;

public record AssignmentSubmissionDto(
			String id,
			String assignmentId,
			List<String> studentId,
			String sumissionText,
			Date sumittedAt
		
		
		
		
		) {

}
