package com.management.school.security.model;

import java.util.Date;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="tbl_assignment_submission")
public class AssignmentSubmission {

	 	@Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	    private String id;
	 
	 	@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "assignment_id")
	    private Assignment assignment;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "student_id")
	    private Student student;

	    @Column( columnDefinition = "TEXT")
	    private String submissionText;

	
	    private Date submittedAt;
	    
	    @Enumerated(EnumType.STRING)
	 
	    private Status status;

}
