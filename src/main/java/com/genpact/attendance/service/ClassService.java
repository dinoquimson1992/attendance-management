package com.genpact.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.attendance.dto.ClassDto;
import com.genpact.attendance.entity.Class;
import com.genpact.attendance.entity.Enrollment;
import com.genpact.attendance.repository.ClassRepository;
import com.genpact.attendance.repository.EnrollmentRepository;

import jakarta.transaction.Transactional;

@Service
public class ClassService {
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Transactional
	public void create(ClassDto dto) {
		if(dto == null) throw new IllegalArgumentException("Class cannot be empty!");
		
		Class entity = new Class();
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setSchedule(dto.getSchedule());
		
		classRepository.save(entity);
		
		List<Long> studentIdList = dto.getStudentIdList();
		
		for(Long id: studentIdList) {
			Enrollment enrollment = new Enrollment();
			enrollment.setStudentId(id);
			enrollment.setClassId(entity.getId());
			
			enrollmentRepository.save(enrollment);
			
			System.out.println(enrollment.toString());
		}
	}
	
	@Transactional
	public void update(ClassDto dto) {
		if(dto == null) throw new IllegalArgumentException("Class cannot be empty!");
		
		Class entity = new Class();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setSchedule(dto.getSchedule());
		
		classRepository.save(entity);
		enrollmentRepository.deleteByClassId(entity.getId());
		
		List<Long> studentIdList = dto.getStudentIdList();
		
		for(Long id: studentIdList) {
			Enrollment enrollment = new Enrollment();
			enrollment.setStudentId(id);
			enrollment.setClassId(entity.getId());
			
			enrollmentRepository.save(enrollment);
		}
	}
	
	public List<Class> getList(){
		return classRepository.findAll();
	}
	
	public Class getClassById(Long id) {
		return classRepository.findById(id).get();
	}

}
