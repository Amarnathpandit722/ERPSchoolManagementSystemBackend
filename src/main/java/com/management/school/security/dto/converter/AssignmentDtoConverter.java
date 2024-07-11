package com.management.school.security.dto.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.management.school.security.dto.AssignementDto;
import com.management.school.security.model.Assignment;



@Component
public class AssignmentDtoConverter {

	
	public AssignementDto convert(Assignment  from) {
		return new AssignementDto(
		        from.getId(),
		        from.getTitle(),
		        from.getDescription(),
		        from.getSubject()!= null? from.getSubject().getName() : null,
		        from.getTeacher()!= null? from.getTeacher().getFirstName()+" "+from.getTeacher().getLastName() : null,
		        from.getDeadline()
		        
		    );
	}
	public List<AssignementDto> convert(List<Assignment> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
