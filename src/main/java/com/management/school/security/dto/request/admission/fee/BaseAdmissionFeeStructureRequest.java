package com.management.school.security.dto.request.admission.fee;

import java.math.BigDecimal;

import com.management.school.security.helper.ValidationMessage;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BaseAdmissionFeeStructureRequest {
	
	@NotNull(message = ValidationMessage.Admission.ADMISSION_FEE_NOT_NULL)
    @Positive(message = ValidationMessage.Admission.ADMISSION_FEE_POSITIVE)
    private BigDecimal admissionFee;

    @NotNull(message = ValidationMessage.Admission.REGISTRATION_FEE_NOT_NULL)
    @Positive(message = ValidationMessage.Admission.REGISTRATION_FEE_POSITIVE)
    private BigDecimal registrationFee;

    @NotNull(message = ValidationMessage.Admission.TUITION_FEE_NOT_NULL)
    @Positive(message = ValidationMessage.Admission.TUITION_FEE_POSITIVE)
    private BigDecimal tuitionFee;

    @NotNull(message = ValidationMessage.Admission.LIBRARY_FEE_NOT_NULL)
    @Positive(message = ValidationMessage.Admission.LIBRARY_FEE_POSITIVE)
    private BigDecimal libraryFee;

    @NotNull(message = ValidationMessage.Admission.LABORATORY_FEE_NOT_NULL)
    @Positive(message = ValidationMessage.Admission.LABORATORY_FEE_POSITIVE)
    private BigDecimal laboratoryFee;

    @NotNull(message = ValidationMessage.Admission.SPORTS_FEE_NOT_NULL)
    @Positive(message = ValidationMessage.Admission.SPORTS_FEE_POSITIVE)
    private BigDecimal sportsFee;

    @NotNull(message = ValidationMessage.Admission.FY_ID_NOT_NULL)
    private String fyId;
	
	
	
	

}
