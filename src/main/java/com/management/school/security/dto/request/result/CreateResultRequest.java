package com.management.school.security.dto.request.result;


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
public class CreateResultRequest extends BaseResultRequest {

	@NotNull(message = ValidationMessage.Result.RESULT_STUDENT_ID_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Result.RESULT_STUDENT_ID_NOT_EMPTY)
    private String studentId;

  
}
