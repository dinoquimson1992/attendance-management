package com.genpact.attendance.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.genpact.attendance.dto.StudentDto;
import com.genpact.attendance.model.Student;
import com.genpact.attendance.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/student")
	public String getStudentPage(Model model) {
		Student student = new Student();
		List<Student> list = studentService.getList();
		List<StudentDto> studentList = list.stream().map(s -> StudentDto.convertFromEntity(s)).collect(Collectors.toList());
		
		model.addAttribute("model", student);
		model.addAttribute("studentList", studentList);
		
		return "student";
	}
	
	@PostMapping("/student")
	public String addStudent(Student student, Model model) {
		studentService.save(student);
		
		student = new Student();
		List<Student> list = studentService.getList();
		List<StudentDto> studentList = list.stream().map(s -> StudentDto.convertFromEntity(s)).collect(Collectors.toList());
		
		model.addAttribute("model", student);
		model.addAttribute("studentList", studentList);
		
		return "student";
	}
	
	@GetMapping("/student/delete/{id}")
	@ResponseBody
	public ResponseEntity<String> delete(@PathVariable Long id) {
		studentService.delete(id);
		
		return new ResponseEntity<String>("Student was successfully deleted.", HttpStatus.OK);
	}

}
