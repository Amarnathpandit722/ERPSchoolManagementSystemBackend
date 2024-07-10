package com.management.school.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.school.security.model.Student;

public interface StudentRepository extends JpaRepository<Student, String>{

	boolean existsByMotherPhone(String motherPhone);
    boolean existsByFatherPhone(String fatherPhone);
    boolean existsByNationalId(String nationalId);
	
}
