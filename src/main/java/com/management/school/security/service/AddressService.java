package com.management.school.security.service;

import java.util.List;

import com.management.school.security.dto.AddressDto;
import com.management.school.security.dto.request.address.CreateAddressRequest;
import com.management.school.security.dto.request.address.UpdateAddressRequest;

public interface AddressService {
	
	public void createAddress(CreateAddressRequest request);

	public void updateAddress(String id, UpdateAddressRequest request);
	
	public void deleteAddress(String id);

	public AddressDto findAddressById(String id);

	public List<AddressDto> findAllAddresses();

}
