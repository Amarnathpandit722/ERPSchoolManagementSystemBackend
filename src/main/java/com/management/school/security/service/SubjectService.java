package com.management.school.security.service;

import java.util.List;

import com.management.school.security.dto.SubjectDto;
import com.management.school.security.dto.request.subject.CreateSubjectRequest;
import com.management.school.security.dto.request.subject.UpdateSubjectRequest;

public interface SubjectService {
	
	
	void createSubject(CreateSubjectRequest request);

    void updateSubject(String id, UpdateSubjectRequest request);

    void deleteSubject(String id);

    SubjectDto findSubjectById(String id);

    List<SubjectDto> findAllSubjects();

}
