package com.management.school.security.dto.request.assignment.assigning;




import com.management.school.security.helper.ValidationMessage;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BaseAssigningAssignmetRequest {

	
	@NotNull(message = ValidationMessage.Assignment.TITLE_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Assignment.TITLE_NOT_EMPTY)
    private String title;

    @NotNull(message = ValidationMessage.Assignment.DESCRIPTION_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Assignment.DESCRIPTION_NOT_EMPTY)
    private String description;

    @NotNull(message = ValidationMessage.Assignment.DEADLINE_DATE_NOT_NULL)
//    @NotEmpty(message = ValidationMessage.Assignment.DEADLINE_DATE_NOT_EMPTY)
    private String  deadline;
    
    @NotNull(message = ValidationMessage.Assignment.SUBJECT_ID_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Assignment.SUBJECT_ID_NOT_EMPTY)
    private String subjectId;
}
