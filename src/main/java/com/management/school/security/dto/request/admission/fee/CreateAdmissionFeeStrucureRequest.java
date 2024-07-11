package com.management.school.security.dto.request.admission.fee;


import com.management.school.security.helper.ValidationMessage;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
//@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateAdmissionFeeStrucureRequest extends BaseAdmissionFeeStructureRequest {
	
	@NotNull(message = ValidationMessage.Admission.CLASS_LEVEL_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Admission.CLASS_LEVEL_NOT_EMPTY)
	private String classLevel;
	

}
