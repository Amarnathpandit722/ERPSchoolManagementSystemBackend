package com.management.school.security.dto.request.subject;

import com.management.school.security.helper.ValidationMessage;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseSubjectRequest {

	
	@NotNull(message = ValidationMessage.Subject.SUBJECT_NAME_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Subject.SUBJECT_NAME_NOT_EMPTY)
    private String subjectName;

    @NotNull(message = ValidationMessage.Subject.SUBJECT_CODE_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Subject.SUBJECT_CODE_NOT_EMPTY)
    private String subjectCode;

    @NotNull(message = ValidationMessage.Subject.SUBJECT_DESCRIPTION_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Subject.SUBJECT_DESCRIPTION_NOT_EMPTY)
    private String description;
    
    @NotNull(message = ValidationMessage.Subject.CLASSROOM_ID_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Subject.CLASSROOM_ID_NOT_EMPTY)
    private String classroomId;

}
