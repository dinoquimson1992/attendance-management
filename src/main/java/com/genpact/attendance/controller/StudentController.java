package com.genpact.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.genpact.attendance.entity.Student;
import com.genpact.attendance.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public String getStudentPage(Model model) {
		Student student = new Student();
		List<Student> studentList = studentService.getList();
		
		model.addAttribute("model", student);
		model.addAttribute("studentList", studentList);
		
		return "student";
	}
	
	@PostMapping("/students")
	public String addStudent(Student student, Model model) {
		studentService.save(student);
		
		student = new Student();
		List<Student> studentList = studentService.getList();
		
		model.addAttribute("model", student);
		model.addAttribute("studentList", studentList);
		
		return "student";
	}
	
	@GetMapping("/students/delete/{id}")
	@ResponseBody
	public ResponseEntity<Boolean> delete(@PathVariable Long id) {
		try {
			studentService.delete(id);
		}catch(Exception e) {
			new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

}
