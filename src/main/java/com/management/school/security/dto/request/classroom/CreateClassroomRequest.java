package com.management.school.security.dto.request.classroom;

import java.util.Objects;

import com.management.school.security.dto.request.subject.CreateSubjectRequest;
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
public class CreateClassroomRequest extends BaseClassroomRequest{

	
	@NotNull(message = ValidationMessage.Classroom.CLASSROOM_NAME_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Classroom.CLASSROOM_NAME_NOT_EMPTY)
    private String name;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateClassroomRequest other = (CreateClassroomRequest) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(name);
		return result;
	}
}
