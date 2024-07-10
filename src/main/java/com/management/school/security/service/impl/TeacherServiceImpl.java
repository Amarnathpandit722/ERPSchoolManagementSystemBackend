package com.management.school.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.school.security.dto.TeacherDto;
import com.management.school.security.dto.converter.TeacherDtoConverter;
import com.management.school.security.dto.request.techer.CreateTeacherRequest;
import com.management.school.security.dto.request.techer.UpdateTeacherRequest;
import com.management.school.security.exception.TeacherAlreadyExistException;
import com.management.school.security.exception.TeacherNotFoundException;
import com.management.school.security.helper.BusinessMessage;
import com.management.school.security.helper.DateHelper;
import com.management.school.security.helper.LogMessage;
import com.management.school.security.model.Teacher;
import com.management.school.security.repository.TeacherRepository;
import com.management.school.security.service.TeacherService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherRepository teacherRepository;
	@Autowired
	private TeacherDtoConverter converter;
	
	
	
	@Override
	public void createTeacher(CreateTeacherRequest request) {
		checkIfTeacherExists(request.getNationalId());

        Teacher teacher = new Teacher();
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setNationalId(request.getNationalId());
        teacher.setPhone(request.getPhone());
        teacher.setCreatedDate(DateHelper.getCurrentDate());
        teacher.setUpdatedDate(DateHelper.getCurrentDate());

        teacherRepository.save(teacher);
        log.info(LogMessage.Teacher.TeacherCreated());
	}

	@Override
	public void updateTeacher(String id, UpdateTeacherRequest request) {
		 Teacher teacher = findTeacherByTeacherId(id);

	        teacher.setFirstName(request.getFirstName());
	        teacher.setLastName(request.getLastName());
	        teacher.setPhone(request.getPhone());
	        teacher.setUpdatedDate(DateHelper.getCurrentDate());

	        teacherRepository.save(teacher);
	        log.info(LogMessage.Teacher.TeacherUpdated(id));
	}

	@Override
	public void deleteTeacher(String id) {
		Teacher teacher = findTeacherByTeacherId(id);

        teacherRepository.delete(teacher);
        log.info(LogMessage.Teacher.TeacherDeleted(id));

	}

	@Override
	public TeacherDto findTeacherById(String id) {
		  Teacher teacher = findTeacherByTeacherId(id);

	        log.info(LogMessage.Teacher.TeacherFound(id));
	        return converter.convert(teacher);
	}

	@Override
	public List<TeacherDto> findAllTeachers() {
		List<Teacher> teacherList = teacherRepository.findAll();

        if (teacherList.isEmpty()) {
            log.error(LogMessage.Teacher.TeacherListEmpty());
            throw new TeacherNotFoundException(BusinessMessage.Teacher.TEACHER_LIST_EMPTY);
        }

        log.info(LogMessage.Teacher.TeacherListed());
        return converter.convert(teacherList);
	}
	private void checkIfTeacherExists(String nationalId) {
        if (teacherRepository.existsByNationalId(nationalId)) {
            log.error(LogMessage.Teacher.TeacherAlreadyExists(nationalId));
            throw new TeacherAlreadyExistException(BusinessMessage.Teacher.TEACHER_ALREADY_EXISTS);
        }
    }

	@Override
    public Teacher findTeacherByTeacherId(String id) {
        return teacherRepository.findById(id).orElseThrow(() -> {
            log.error(LogMessage.Teacher.TeacherNotFound(id));
            return new TeacherNotFoundException(BusinessMessage.Teacher.TEACHER_NOT_FOUND);
        });
    }

}
