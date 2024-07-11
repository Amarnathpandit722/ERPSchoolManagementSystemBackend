package com.management.school.security.dto.request.assignment.submission;


import com.management.school.security.helper.ValidationMessage;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseSubmissionAssignmentRequest {

	@NotNull(message=ValidationMessage.Assignment.SUBMISSION_TEXT_ID_NOT_NULL)
	private String submissionText;

	@NotNull(message = ValidationMessage.Assignment.ASSIGNMENT_ID_NOT_NULL)
	private String assignmentId;


}
