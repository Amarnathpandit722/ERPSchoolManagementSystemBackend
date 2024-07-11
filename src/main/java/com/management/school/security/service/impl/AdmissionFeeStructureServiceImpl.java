package com.management.school.security.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.school.security.dto.AdmissionFeeStructureDto;
import com.management.school.security.dto.converter.AdmissionFeeStrucureDtoConverter;
import com.management.school.security.dto.request.admission.fee.CreateAdmissionFeeStrucureRequest;
import com.management.school.security.dto.request.admission.fee.UpdateAdmissionFeeStructureRequest;
import com.management.school.security.exception.AdmissionFeeStructureNotFound;
import com.management.school.security.model.AdmissionFeeStructure;
import com.management.school.security.model.FyYear;
import com.management.school.security.repository.AdmissionFeeStructureRepository;
import com.management.school.security.repository.FyYearRepository;
import com.management.school.security.service.AdmissionFeeStructureService;

@Service
public class AdmissionFeeStructureServiceImpl  implements AdmissionFeeStructureService{

	@Autowired
	private AdmissionFeeStructureRepository admissionFeeStructureRepository;
	
	@Autowired
	private AdmissionFeeStrucureDtoConverter adminAdmissionFeeStrucureDtoConverter;

	@Autowired
	private FyYearRepository fyYearRepository;
	
	@Override
	public void createAdmissionFeeStructure(CreateAdmissionFeeStrucureRequest request) {
		 FyYear fyYear = fyYearRepository.findById(request.getFyId())
	                .orElseThrow(() -> new FyYearNotFoundException("Fiscal year not found with id: " + request.getFyId()));

		
		AdmissionFeeStructure admissionFeeStructure = new AdmissionFeeStructure();
        admissionFeeStructure.setAdmissionFee(request.getAdmissionFee());
        admissionFeeStructure.setRegistrationFee(request.getRegistrationFee());
        admissionFeeStructure.setTuitionFee(request.getTuitionFee());
        admissionFeeStructure.setLibraryFee(request.getLibraryFee());
        admissionFeeStructure.setLaboratoryFee(request.getLaboratoryFee());
        admissionFeeStructure.setSportsFee(request.getSportsFee());
        admissionFeeStructure.setClassLevel(request.getClassLevel());
        admissionFeeStructure.setFyYear(fyYear);

        admissionFeeStructure = admissionFeeStructureRepository.save(admissionFeeStructure);
        
	}

	@Override
	public void updateAdmissionFeeStrcutre(String id,UpdateAdmissionFeeStructureRequest request) {
		
		Optional<AdmissionFeeStructure> optionalAdmissionFeeStructure = admissionFeeStructureRepository.findById(id);
        if (!optionalAdmissionFeeStructure.isPresent()) {
            throw new AdmissionFeeStructureNotFound("Admission fee structure not found with id: " + id);
        }
        FyYear fyYear = fyYearRepository.findById(request.getFyId())
                .orElseThrow(() -> new FyYearNotFoundException("Fiscal year not found with id: " + request.getFyId()));

	

        AdmissionFeeStructure admissionFeeStructure = optionalAdmissionFeeStructure.get();
        admissionFeeStructure.setAdmissionFee(request.getAdmissionFee());
        admissionFeeStructure.setRegistrationFee(request.getRegistrationFee());
        admissionFeeStructure.setTuitionFee(request.getTuitionFee());
        admissionFeeStructure.setLibraryFee(request.getLibraryFee());
        admissionFeeStructure.setLaboratoryFee(request.getLaboratoryFee());
        admissionFeeStructure.setSportsFee(request.getSportsFee());
        admissionFeeStructure.setFyYear(fyYear);

        admissionFeeStructureRepository.save(admissionFeeStructure);
        
	}

	@Override
	public AdmissionFeeStructureDto getAdmissionFeeById(String Id) {
		 AdmissionFeeStructure admissionFeeStructure = admissionFeeStructureRepository.findById(Id)
	                .orElseThrow(() -> new AdmissionFeeStructureNotFound("Admission fee structure not found with id: " + Id));
	        return adminAdmissionFeeStrucureDtoConverter.convert(admissionFeeStructure);
	}

	@Override
	public List<AdmissionFeeStructureDto> getAllAdmisssionFee() {
		 List<AdmissionFeeStructure> feeStructures = admissionFeeStructureRepository.findAll();
	        return feeStructures.stream()
	                .map(adminAdmissionFeeStrucureDtoConverter::convert)
	                .collect(Collectors.toList());
	}

	@Override
	public void deleteAdmissionFeeStructure(String id) {
		 if (!admissionFeeStructureRepository.existsById(id)) {
	            throw new AdmissionFeeStructureNotFound("Admission fee structure not found with id: " + id);
	        }
	        admissionFeeStructureRepository.deleteById(id);
		
	}

	@Override
	public void saveFyYear(String newFyYear) {
		 if (fyYearRepository.findByFyYear(newFyYear).isPresent()) {
	            throw new FyYearAlreadyExistsException("Fiscal year already exists: " + newFyYear);
	        }
	        
	        FyYear fyYear = new FyYear();
	        fyYear.setFyYear(newFyYear);
	        fyYearRepository.save(fyYear);
		
	}

	@Override
	public List<FyYear> getAllfyYear() {
		return fyYearRepository.findAll();
	}

	@Override
	public List<AdmissionFeeStructure> getAllfyYearByYearWise(String fyYearId) {
		List<AdmissionFeeStructure> optionalAdmissionFeeStructure = admissionFeeStructureRepository.findByFyYearId(fyYearId);
		if(optionalAdmissionFeeStructure.isEmpty()) {
			throw new FyYearNotFoundException("Not Found with this Id "+fyYearId);
		}
		return optionalAdmissionFeeStructure.stream().collect(Collectors.toList());
	}
	
	
	
	
}
