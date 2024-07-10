package com.management.school.security.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_address")
public class Address {
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String street;
    private String city;
    private String state;
    private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

}
