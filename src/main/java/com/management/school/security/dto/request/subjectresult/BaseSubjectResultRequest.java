package com.management.school.security.dto.request.subjectresult;

import com.management.school.security.helper.ValidationMessage;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseSubjectResultRequest {
	

	@NotNull(message = ValidationMessage.SubjectResult.SUBJECT_ID_MUST_NOT_NULL)
	@NotEmpty(message = ValidationMessage.SubjectResult.SUBJECT_ID_MUST_NOT_EMPTY)
	private String subjectId;

	@NotNull(message = ValidationMessage.SubjectResult.GRADE_MUST_NOT_NULL)
	@NotEmpty(message = ValidationMessage.SubjectResult.GRADE_MUST_NOT_EMPTY)
	private double grade;
	@NotNull(message = ValidationMessage.SubjectResult.REMARKS_MUST_NOT_NULL)
	@NotEmpty(message = ValidationMessage.SubjectResult.REMARKS_MUST_NOT_EMPTY)
	private String remarks;

	

}
