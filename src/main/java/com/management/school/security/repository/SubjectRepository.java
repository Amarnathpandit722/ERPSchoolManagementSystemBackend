package com.management.school.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.school.security.model.Subject;

@Repository
public interface SubjectRepository  extends JpaRepository<Subject, String>{

	Subject findSubjectById(String subjectId);

}
