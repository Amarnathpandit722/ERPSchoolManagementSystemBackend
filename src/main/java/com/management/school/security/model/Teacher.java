package com.management.school.security.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor

@NoArgsConstructor
@Table(name="tbl_teacher")
public class Teacher {
	
	  	@Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	    private String id;
	    private String firstName;
	    private String lastName;
	    private String nationalId;
	    private Date createdDate;
	    private Date updatedDate;
	    private String phone;

	    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
	    private List<Classroom> classroomList;

}
