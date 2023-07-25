package com.genpact.attendance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.attendance.entity.Student;
import com.genpact.attendance.exception.StudentNotFoundException;
import com.genpact.attendance.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public void save(Student student) {
		studentRepository.save(student);
	}
	
	public void delete(Long id) throws StudentNotFoundException {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isPresent()) studentRepository.delete(student.get());
		else throw new StudentNotFoundException();
	}
	
	public List<Student> getList(){
		return studentRepository.findAll();
	}

}
