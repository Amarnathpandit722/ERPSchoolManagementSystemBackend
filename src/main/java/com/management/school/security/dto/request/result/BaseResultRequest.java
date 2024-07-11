package com.management.school.security.dto.request.result;

import java.util.List;

import com.management.school.security.dto.request.subjectresult.CreateSubjectResultRequest;
import com.management.school.security.helper.ValidationMessage;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResultRequest {

    @NotNull(message = ValidationMessage.Result.RESULT_CLASSROOM_ID_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Result.RESULT_CLASSROOM_ID_NOT_EMPTY)
    private String classroomId;
    
    @NotNull(message = ValidationMessage.Result.SUBJECT_RESULT_DTO_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Result.SUBJECT_RSULT_DTO_NOT_EMPTY)
    private List<CreateSubjectResultRequest> subjectResult;
    
}
