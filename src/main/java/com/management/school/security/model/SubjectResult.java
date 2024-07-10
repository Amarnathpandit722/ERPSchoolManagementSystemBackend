package com.management.school.security.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_subject_result")
public class SubjectResult {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private  String id;
    
    @NotNull
    @Column(nullable = false)
    private  double grade;
    
    @Size(max = 255)
    private  String remarks;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "result_id", referencedColumnName = "id")
    private Result result;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private  Teacher teacher;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private  Subject subject;
    
    
    
}