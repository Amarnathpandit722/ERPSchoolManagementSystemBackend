package com.management.school.security.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.school.security.dto.AssignementDto;
import com.management.school.security.dto.converter.AssignmentDtoConverter;
import com.management.school.security.dto.request.assignment.assigning.CreateAssigningAssignmentRequest;
import com.management.school.security.exception.AssignmentNotfound;
import com.management.school.security.exception.StudentNotFoundException;
import com.management.school.security.model.Assignment;
import com.management.school.security.model.AssignmentSubmission;
import com.management.school.security.model.Status;
import com.management.school.security.model.Student;
import com.management.school.security.model.Subject;
import com.management.school.security.model.Teacher;
import com.management.school.security.repository.AssignmentRepository;
import com.management.school.security.repository.AssignmentSubmissionRepository;
import com.management.school.security.repository.StudentRepository;
import com.management.school.security.repository.SubjectRepository;
import com.management.school.security.repository.TeacherRepository;
import com.management.school.security.service.AssignmentService;

@Service
public class AssignmentServiceImpl  implements AssignmentService{

	
	@Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private AssignmentSubmissionRepository assignmentSubmissionRepository;
    @Autowired
    private AssignmentDtoConverter assignmentDtoConverter;
    @Autowired
    private TeacherRepository teacherRespository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private StudentRepository studentRepository;
    
	@Override
	public void createAssignment(CreateAssigningAssignmentRequest newAssignment) {
		
		Assignment assignment = new Assignment();
        assignment.setTitle(newAssignment.getTitle());
        assignment.setDescription(newAssignment.getDescription());
        assignment.setDeadline(newAssignment.getDeadline());
        Teacher teacher = teacherRespository.findTeacherById(newAssignment.getTeacherId());
        assignment.setTeacher(teacher);
        Subject subject= subjectRepository.findById(newAssignment.getSubjectId()).orElse(null);
        assignment.setSubject(subject);
        assignment.setStatus(Status.CREATED);
        assignmentRepository.save(assignment);
		
	}

	@Override
	public AssignementDto getAssignmentById(String id) {
		 Assignment assignment = assignmentRepository.findById(id).orElse(null);
	        if (assignment != null) {
	            return assignmentDtoConverter.convert(assignment);
	        }
	        return null;
		
	}

	@Override
	public List<AssignementDto> getAllAssignments() {
		List<Assignment> assignments = assignmentRepository.findAll();
        return assignments.stream()
                .map(assignmentDtoConverter::convert)
                .collect(Collectors.toList());
	}

	@Override
	public List<AssignementDto> getAssignmentsByTeacher(String teacherId) {
		List<Assignment> assignments = assignmentRepository.findByTeacherId(teacherId);
        return assignments.stream()
                .map(assignmentDtoConverter::convert)
                .collect(Collectors.toList());
	}

	@Override
	public List<AssignementDto> getAssignmentsBySubject(String subjectId) {
		 List<Assignment> assignments = assignmentRepository.findBySubjectId(subjectId);
	        return assignments.stream()
	                .map(assignmentDtoConverter::convert)
	                .collect(Collectors.toList());
	}

	@Override
	public void deleteAssignment(String id) {
		 assignmentRepository.deleteById(id);
		
	}

	@Override
	public boolean isAssignmentSubmitted(String assignmentId, String studentId) {
		AssignmentSubmission submission = assignmentSubmissionRepository.findByAssignmentIdAndStudentId(assignmentId, studentId);
        
        // Return true if submission exists, false otherwise
        return submission != null;
	}

	@Override
	public String assignedToStudent(String assignmentId, String studentId) {
		
		Assignment assignment = assignmentRepository.findById(assignmentId).orElseThrow(
				() -> new AssignmentNotfound("Assignment not found with id: " + assignmentId));

		Student student = studentRepository.findById(studentId).orElseThrow(
				() -> new StudentNotFoundException("Student not found with id: " + studentId));
		AssignmentSubmission submission = new AssignmentSubmission();
		submission.setAssignment(assignment);
		submission.setStudent(student);
//		submission.setSubmissionText(null);
//		submission.setSubmittedAt(null);
		submission.setStatus(Status.PENDING);

		// Save AssignmentSubmission entity to repository
		assignmentSubmissionRepository.save(submission);
		
		return "Assignment is Successfully Assigned to Student";
	}

}
