package com.management.school.security.dto.request.student;

import java.util.Objects;

import com.management.school.security.helper.ValidationMessage;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor

public class CreateStudentRequest extends BaseStudentRequest {
	 @NotNull(message = ValidationMessage.Student.STUDENT_NATIONAL_ID_NOT_NULL)
	    @NotEmpty(message = ValidationMessage.Student.STUDENT_NATIONAL_ID_NOT_EMPTY)
	    @Pattern(regexp = ValidationMessage.General.NATIONAL_ID_REGEX,
	            message = ValidationMessage.Student.STUDENT_NATIONAL_ID_NOT_VALID)
	    private String nationalId;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateStudentRequest other = (CreateStudentRequest) obj;
		return Objects.equals(nationalId, other.nationalId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nationalId);
	}

}
