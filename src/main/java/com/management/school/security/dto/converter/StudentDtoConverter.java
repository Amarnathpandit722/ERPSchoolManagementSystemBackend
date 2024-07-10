package com.management.school.security.dto.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.management.school.security.dto.StudentDto;
import com.management.school.security.model.Student;

@Component
public class StudentDtoConverter {
	private final AddressDtoConverter addressDtoConverter;

    public StudentDtoConverter(AddressDtoConverter addressDtoConverter) {
        this.addressDtoConverter = addressDtoConverter;
    }

    public StudentDto convert(Student from) {
        return new StudentDto(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getNationalId(),
                from.getStudentNumber(),
                from.getFatherName(),
                from.getFatherPhone(),
                from.getMotherName(),
                from.getMotherPhone(),
                addressDtoConverter.convert(from.getAddressList()),
                from.getClassroom() != null ? from.getClassroom().getName() : null
        );
    }

    public List<StudentDto> convert(List<Student> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }

}
