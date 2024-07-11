package com.management.school.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.school.security.model.FyYear;

public interface FyYearRepository extends JpaRepository<FyYear, String>{

	Optional<FyYear> findByFyYear(String newfyYear);
	

}
