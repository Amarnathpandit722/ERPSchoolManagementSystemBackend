package com.management.school.security.model;

import java.math.BigDecimal;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="tbl_fee_structure")
public class AdmissionFeeStructure {


	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
	
	
	    @Column(name = "class_level")
	    private String classLevel;

	 
	    @Column(name = "admission_fee")
	    private BigDecimal admissionFee;
	    
	    @Column(name = "registration_fee")
	    private BigDecimal registrationFee;

	 
	    @Column(name = "tuition_fee")
	    private BigDecimal tuitionFee;

	    @Column(name = "library_fee")
	    private BigDecimal libraryFee;

	    @Column(name = "laboratory_fee")
	    private BigDecimal laboratoryFee;

	    
	    @Column(name = "sports_fee")
	    private BigDecimal sportsFee;
	    
	    @ManyToOne
	    @JoinColumn(name = "fy_id")
	    private FyYear fyYear;
	    
	   
	
	    
	    
	    
	    
}
