package com.management.school.security.dto.request.address;

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
public class CreateAddressRequest extends BaseAddressRequest {
    @NotNull(message = ValidationMessage.Address.ADDRESS_STUDENT_ID_NOT_NULL)
    @NotEmpty(message = ValidationMessage.Address.ADDRESS_STUDENT_ID_NOT_EMPTY)
    private String studentId;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateAddressRequest other = (CreateAddressRequest) obj;
		return Objects.equals(studentId, other.studentId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentId);
	}
	
	
}
