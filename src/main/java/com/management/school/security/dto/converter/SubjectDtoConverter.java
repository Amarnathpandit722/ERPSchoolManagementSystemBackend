package com.management.school.security.dto.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.management.school.security.dto.SubjectDto;
import com.management.school.security.model.Subject;

@Component
public class SubjectDtoConverter {
	
	public SubjectDto convert(Subject  from) {
		return new SubjectDto(
		        from.getId(),
		        from.getName(),
		        from.getDescription(),
		        from.getSubjectCode(),
		        from.getTeacher()!= null? from.getTeacher().getId() : null,
		        from.getClassroom()!= null? from.getClassroom().getId() : null,
		        from.getCreatedDate(),
		        from.getUpdatedDate()
		    );
	}
	public List<SubjectDto> convert(List<Subject> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
	
}
