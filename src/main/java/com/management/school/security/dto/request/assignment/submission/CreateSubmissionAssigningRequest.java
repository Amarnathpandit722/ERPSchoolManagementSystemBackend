package com.management.school.security.dto.request.assignment.submission;


import com.management.school.security.helper.ValidationMessage;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubmissionAssigningRequest extends BaseSubmissionAssignmentRequest {
	
	
	@NotNull(message=ValidationMessage.Assignment.STUDENT_ID_NOT_NULL)
	private String studentId;
	
	
	
	

}
