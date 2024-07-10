package com.management.school.security.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_result")
public class Result {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

  @NotNull
  private  Date createdDate;

  @NotNull
  private  Date updatedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_id", referencedColumnName = "id")
    private Classroom classroom;

    @OneToMany(mappedBy = "result", cascade = CascadeType.ALL)
    private List<SubjectResult> subjectResults;
}
