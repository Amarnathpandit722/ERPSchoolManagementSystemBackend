package com.management.school.security.dto.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.management.school.security.dto.SubjectResultDto;
import com.management.school.security.model.SubjectResult;

@Component
public class SubjectResultDtoConverter {

	public SubjectResultDto convert(SubjectResult from) {
		return new SubjectResultDto(
		from.getId(),
		from.getGrade(),
		from.getRemarks(),
		from.getSubject()!=null ? from.getSubject().getName():null,
		from.getTeacher()!=null ? from.getTeacher().getFirstName()+" "+from.getTeacher().getLastName():null
		);
	}
	public List<SubjectResultDto> convert(List<SubjectResult> subjectResults) {
        return subjectResults.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
	
	
}
