package com.management.school.security.dto.converter;


import org.springframework.stereotype.Component;

import com.management.school.security.dto.ResultDto;
import com.management.school.security.model.Result;

@Component
public class ResultDtoConverter {
	
	private final  SubjectResultDtoConverter resultDtoConverter;
	
	public ResultDtoConverter(SubjectResultDtoConverter resultDtoConverter) {
		this.resultDtoConverter=resultDtoConverter;
	}

	public ResultDto convert(Result from) {
		return new ResultDto(
				from.getId(),
				from.getCreatedDate(),
				from.getUpdatedDate(),
				from.getClassroom()!=null ? from.getClassroom().getName():null,
					resultDtoConverter.convert(from.getSubjectResults()),
					from.getStudent()!=null ? from.getStudent().getFirstName()+" "+from.getStudent().getLastName():null
		);
	}

}
