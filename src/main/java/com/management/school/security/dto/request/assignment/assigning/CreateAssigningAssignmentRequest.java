package com.management.school.security.dto.request.assignment.assigning;

import java.util.Objects;

import com.management.school.security.helper.ValidationMessage;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
//@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateAssigningAssignmentRequest extends BaseAssigningAssignmetRequest {
	
	@NotNull(message = ValidationMessage.Assignment.SUBJECT_TEACHER_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Assignment.SUBJECT_TEACHER_NOT_EMPTY)
    private String teacherId;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateAssigningAssignmentRequest other = (CreateAssigningAssignmentRequest) obj;
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
