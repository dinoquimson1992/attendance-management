package com.genpact.attendance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.attendance.entity.Enrollment;
import com.genpact.attendance.entity.Student;
import com.genpact.attendance.exception.StudentNotFoundException;
import com.genpact.attendance.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EnrollmentService enrollmentService;
	
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
	
	public List<Student> getListByClassId(Long classId){
		List<Enrollment> enrollmentList = enrollmentService.getListByClassId(classId);
		List<Student> result = new ArrayList<Student>();
		
		for(Enrollment enrollment: enrollmentList) {
			Student student = getStudentById(enrollment.getStudentId());
			result.add(student);
		}
		
		return result;
	}
	
	public Student getStudentById(Long studentId) {
		return studentRepository.findById(studentId).get();
	}

}
