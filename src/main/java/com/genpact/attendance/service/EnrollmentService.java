package com.genpact.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.attendance.entity.Enrollment;
import com.genpact.attendance.repository.EnrollmentRepository;

@Service
public class EnrollmentService {
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	public List<Enrollment> getListByClassId(Long classId){
		return enrollmentRepository.findByClassId(classId);
	}

}
