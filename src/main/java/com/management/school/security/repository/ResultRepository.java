package com.management.school.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.school.security.model.Classroom;
import com.management.school.security.model.Result;
import com.management.school.security.model.Student;

public interface ResultRepository  extends JpaRepository<Result, String>{

    List<Result> findByClassroomAndStudent(Classroom classroom, Student student);

}
