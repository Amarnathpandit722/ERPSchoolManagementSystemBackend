package com.management.school.security.dto.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.management.school.security.dto.AssignmentSubmissionDto;
import com.management.school.security.model.AssignmentSubmission;

@Component
public class AssignmentSubmissionDtoConverter {

	public AssignmentSubmissionDto convert(AssignmentSubmission from) {
		return new AssignmentSubmissionDto(
		from.getId(),
		from.getAssignment()!=null ? from.getAssignment().getId():null,
		from.getStudent()!=null ? (List<String>) from.getStudent():null,
		from.getSubmissionText(),
		from.getSubmittedAt()
		);
	}
	public List<AssignmentSubmissionDto> convert(List<AssignmentSubmission> asssignment) {
        return asssignment.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
	
}
