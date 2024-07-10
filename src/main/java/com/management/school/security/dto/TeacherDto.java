package com.management.school.security.dto;

import java.util.List;

public record TeacherDto(
		String id,
        String firstName,
        String lastName,
        String nationalId,
        String phone,
        List<TeacherClassroomDto> classroomList) {

}
