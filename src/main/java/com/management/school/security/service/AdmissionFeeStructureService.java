package com.management.school.security.service;

import java.util.List;


import com.management.school.security.dto.AdmissionFeeStructureDto;
import com.management.school.security.dto.request.admission.fee.CreateAdmissionFeeStrucureRequest;
import com.management.school.security.dto.request.admission.fee.UpdateAdmissionFeeStructureRequest;
import com.management.school.security.model.AdmissionFeeStructure;
import com.management.school.security.model.FyYear;

public interface AdmissionFeeStructureService {

	
    public void createAdmissionFeeStructure(CreateAdmissionFeeStrucureRequest request);

    public void updateAdmissionFeeStrcutre(String id, UpdateAdmissionFeeStructureRequest request);
    
    
    public AdmissionFeeStructureDto getAdmissionFeeById(String Id);
    
    public List<AdmissionFeeStructureDto> getAllAdmisssionFee();
    
    public void deleteAdmissionFeeStructure(String id) ;

	public void saveFyYear(String fyYear);

	public List<FyYear> getAllfyYear();

	public List<AdmissionFeeStructure> getAllfyYearByYearWise(String fyYearId);
    
    
    
}
