package com.management.school.security.model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_classroom")
public class Classroom {
	 @Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	    private String id;
	    private String name;
	    private String description;
	    private String classroomCode;

	    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
	    private List<Student> studentList;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
	    private Teacher teacher;
	    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
	    private List<Subject> subjects;
}
