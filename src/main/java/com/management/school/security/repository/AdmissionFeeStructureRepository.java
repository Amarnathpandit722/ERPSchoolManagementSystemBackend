package com.management.school.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.school.security.model.AdmissionFeeStructure;

public interface AdmissionFeeStructureRepository extends JpaRepository<AdmissionFeeStructure, String> {

    List<AdmissionFeeStructure> findByFyYearId(String fyYearId);
	
	

}
