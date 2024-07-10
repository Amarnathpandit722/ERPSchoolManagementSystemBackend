package com.management.school.security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_subject")
public class Subject {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private  String id;
    
    @NotNull
    @Column(nullable = false)
    private  String name;
    
    @NotNull
    @Column(nullable = false)
    private  String subjectCode;
    
    @Size(max = 255)
    private  String description;
    
    private Date createdDate;
    private Date updatedDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private  Teacher teacher;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_id", referencedColumnName = "id")
    private  Classroom classroom;
}
