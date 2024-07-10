package com.management.school.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.school.security.model.SubjectResult;

public interface SubjectResultRepository  extends JpaRepository<SubjectResult,String>{

	Optional<SubjectResult> findByResultId(String id);
	

}
