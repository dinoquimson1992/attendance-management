package com.genpact.attendance.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.attendance.dto.ClassDto;
import com.genpact.attendance.model.Class;
import com.genpact.attendance.model.Student;
import com.genpact.attendance.repository.ClassRepository;

import jakarta.transaction.Transactional;

@Service
public class ClassService {
	
	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private StudentService studentService;
	
	@Transactional
	public void save(ClassDto dto) {
		if(dto == null) throw new IllegalArgumentException("Class cannot be null!");
		
		List<Long> studentIdList = dto.getStudentIdList();
		List<Student> studentList = studentIdList.stream().map(id -> studentService.getStudentById(id)).collect(Collectors.toList());
		
		Class entity = new Class();
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setSchedule(dto.getSchedule());
		entity.setStudentList(studentList);
		
		classRepository.save(entity);
	}
	
//	@Transactional
//	public void update(ClassDto dto) {
//		if(dto == null) throw new IllegalArgumentException("Class cannot be empty!");
//		
//		Class entity = new Class();
//		entity.setId(dto.getId());
//		entity.setName(dto.getName());
//		entity.setDescription(dto.getDescription());
//		entity.setSchedule(dto.getSchedule());
//		
//		classRepository.save(entity);
//		enrollmentRepository.deleteByClassId(entity.getId());
//		
//		List<Long> studentIdList = dto.getStudentIdList();
//		
//		for(Long id: studentIdList) {
//			Enrollment enrollment = new Enrollment();
//			enrollment.setStudentId(id);
//			enrollment.setClassId(entity.getId());
//			
//			enrollmentRepository.save(enrollment);
//		}
//	}
	
	public List<Class> getList(){
		return classRepository.findAll();
	}
	
	public Class getClassById(Long id) {
		return classRepository.findById(id).get();
	}

}
