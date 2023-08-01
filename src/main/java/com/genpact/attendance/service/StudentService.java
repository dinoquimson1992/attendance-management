package com.genpact.attendance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.attendance.exception.StudentNotFoundException;
import com.genpact.attendance.model.Student;
import com.genpact.attendance.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public void save(Student student) {
		if(student == null) throw new IllegalArgumentException("Student cannot be null!");
		studentRepository.save(student);
	}
	
	public void delete(Long id) {
		if(id == null || id == 0) throw new IllegalArgumentException("ID cannot be null!");
		Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException());
		studentRepository.delete(student);
	}
	
	public List<Student> getList(){
		return studentRepository.findAll();
	}
	
	public Student getStudentById(Long studentId) {
		if(studentId == null || studentId == 0) throw new IllegalArgumentException("Student ID cannot be null!");
		return studentRepository.findById(studentId).get();
	}

}
