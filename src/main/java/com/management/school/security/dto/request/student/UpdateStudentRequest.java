package com.management.school.security.dto.request.student;

import java.util.Objects;

import com.management.school.security.helper.ValidationMessage;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
//@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStudentRequest  extends BaseStudentRequest {

	@NotNull(message = ValidationMessage.Student.STUDENT_CLASSROOM_ID_NOT_EMPTY)
    @NotEmpty(message = ValidationMessage.Student.STUDENT_CLASSROOM_ID_NOT_EMPTY)
    private String classroomId;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UpdateStudentRequest other = (UpdateStudentRequest) obj;
		return Objects.equals(classroomId, other.classroomId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(classroomId);
	}
	
}
