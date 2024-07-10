package com.management.school.security.dto.request.subjectresult;

import com.management.school.security.helper.ValidationMessage;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubjectResultRequest extends BaseSubjectResultRequest {
	
	
	
	@NotNull(message = ValidationMessage.SubjectResult.TEACHER_ID_MUST_NOT_NULL)
	@NotEmpty(message = ValidationMessage.SubjectResult.TEACHER_ID_MUST_NOT_EMPTY)
	private String teacherId;
}
