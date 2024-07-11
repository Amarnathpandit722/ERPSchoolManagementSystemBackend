package com.management.school.security.dto.converter;

import org.springframework.stereotype.Component;

import com.management.school.security.dto.AdmissionFeeStructureDto;
import com.management.school.security.model.AdmissionFeeStructure;

@Component
public class AdmissionFeeStrucureDtoConverter {

	public AdmissionFeeStructureDto convert(AdmissionFeeStructure from) {
		return new AdmissionFeeStructureDto(from.getId(), 
				from.getClassLevel(), from.getAdmissionFee(), 
				from.getRegistrationFee(), from.getTuitionFee(),
				from.getLibraryFee(), from.getLaboratoryFee(), 
				from.getSportsFee(),  from.getFyYear() != null ? from.getFyYear().getFyYear() : null
				
				);
	}
	
	
	
	
	
}
