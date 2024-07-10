package com.management.school.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.school.security.model.Address;

public interface AddressRepository extends JpaRepository<Address, String> {

}
