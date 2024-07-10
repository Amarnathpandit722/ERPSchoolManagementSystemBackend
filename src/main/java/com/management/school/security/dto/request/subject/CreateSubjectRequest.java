package com.management.school.security.dto.request.subject;

import java.util.Objects;

import com.management.school.security.helper.ValidationMessage;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubjectRequest extends BaseSubjectRequest {
    
    @NotNull(message = ValidationMessage.Subject.SUBJECT_TEACHER_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Subject.SUBJECT_TEACHER_NOT_EMPTY)
    private String teacherId;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateSubjectRequest other = (CreateSubjectRequest) obj;
		return Objects.equals(teacherId, other.teacherId);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(teacherId);
		return result;
	}
    
    
}
