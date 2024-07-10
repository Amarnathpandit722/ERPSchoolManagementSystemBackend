package com.management.school.security.service;

import java.util.List;

import com.management.school.security.dto.ResultDto;
import com.management.school.security.dto.request.result.CreateResultRequest;
import com.management.school.security.dto.request.result.UpdateResultRequest;

public interface ResultService {

	public void createResult(CreateResultRequest request);

	public void updateResult(String id, UpdateResultRequest request);

	public void deleteResult(String id);

	public ResultDto findResultById(String id);

	public List<ResultDto> findAllResults();

	public List<ResultDto> findAllResultsByClassAndStudent(String classroomId, String studentId);

}
