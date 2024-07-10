package com.management.school.security.dto.request.classroom;

import com.management.school.security.helper.ValidationMessage;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseClassroomRequest {
	
	
	@NotNull(message = ValidationMessage.Classroom.CLASSROOM_DESCRIPTION_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Classroom.CLASSROOM_DESCRIPTION_NOT_EMPTY)
    private String description;

    @NotNull(message = ValidationMessage.Classroom.CLASSROOM_TEACHER_ID_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Classroom.CLASSROOM_TEACHER_ID_NOT_EMPTY)
    private String teacherId;
	
}
