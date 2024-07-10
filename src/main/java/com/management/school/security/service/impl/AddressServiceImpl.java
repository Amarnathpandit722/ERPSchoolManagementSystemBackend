package com.management.school.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.school.security.dto.AddressDto;
import com.management.school.security.dto.converter.AddressDtoConverter;
import com.management.school.security.dto.request.address.CreateAddressRequest;
import com.management.school.security.dto.request.address.UpdateAddressRequest;
import com.management.school.security.exception.AddressNotFoundException;
import com.management.school.security.helper.BusinessMessage;
import com.management.school.security.helper.LogMessage;
import com.management.school.security.model.Address;
import com.management.school.security.model.Student;
import com.management.school.security.repository.AddressRepository;
import com.management.school.security.service.AddressService;
import com.management.school.security.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private StudentService studentService;
	@Autowired
	private AddressDtoConverter converter;
	
	
	
	@Override
	public void createAddress(CreateAddressRequest request) {
		Address address = new Address();
        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setZipCode(request.getZipCode());
        address.setStudent(studentService.findStudentByStudentId(request.getStudentId()));

        addressRepository.save(address);
        log.info(LogMessage.Address.AddressCreated());

	}

	@Override
	public void updateAddress(String id, UpdateAddressRequest request) {
		Address address = findAddressByAddressId(id);

        address.setStreet(request.getStreet());
        address.setCity(request.getCity());
        address.setState(request.getState());
        address.setZipCode(request.getZipCode());

        addressRepository.save(address);
        log.info(LogMessage.Address.AddressUpdated(id));
	}

	@Override
	public void deleteAddress(String id) {
		 Address address = findAddressByAddressId(id);
		    try {
		    	Student student = address.getStudent();
		        if (student!= null) {
		        	String studentId = student.getId();
		        	studentService.deleteStudent(studentId);
		        	
		        }
		        
		        addressRepository.delete(address);
		        log.info(LogMessage.Address.AddressDeleted(id));
		    } catch (Exception e) {
		        log.error("Error deleting address", e);
		    }

	}

	@Override
	public AddressDto findAddressById(String id) {
		Address address = findAddressByAddressId(id);

        log.info(LogMessage.Address.AddressFound(id));
        return converter.convert(address);
	}

	@Override
	public List<AddressDto> findAllAddresses() {
		 List<Address> addressList = addressRepository.findAll();

	        if (addressList.isEmpty()) {
	            log.error(LogMessage.Address.AddressListEmpty());
	            throw new AddressNotFoundException(BusinessMessage.Address.ADDRESS_LIST_EMPTY);
	        }

	        log.info(LogMessage.Address.AddressListed());
	        return converter.convert(addressList);
	}
	protected Address findAddressByAddressId(String id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> {
                    log.error(LogMessage.Address.AddressNotFound(id));
                    throw new AddressNotFoundException(LogMessage.Address.AddressNotFound(id));
                });
    }
}
