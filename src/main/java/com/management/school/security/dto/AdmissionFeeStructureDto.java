package com.management.school.security.dto;

import java.math.BigDecimal;

public record AdmissionFeeStructureDto(
		String id,
		String classLevel,
		BigDecimal admissionFee,
		BigDecimal registrationFee,
		BigDecimal tutionFee,
		BigDecimal libraryFee,
		BigDecimal laborartoryFee,
		BigDecimal sportsFee,
		String fyYear
		
		
		) {

}
