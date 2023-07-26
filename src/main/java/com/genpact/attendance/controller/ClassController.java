package com.genpact.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.genpact.attendance.dto.Class;
import com.genpact.attendance.entity.Student;
import com.genpact.attendance.service.ClassService;
import com.genpact.attendance.service.StudentService;

@Controller
public class ClassController {
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/class")
	public String getClassPage(Model model) {
		List<com.genpact.attendance.entity.Class> classList = classService.getList();
		
		model.addAttribute("list", classList);
		
		return "class";
	}
	
	@GetMapping("/class/{id}")
	public String getClassPageById(@PathVariable Long id, Model model) {
		com.genpact.attendance.entity.Class c = classService.findById(id);
		
		model.addAttribute("model", c);
		
		return "class_view";
	}
	
	@GetMapping("/class/new")
	public String getCreateClassPage(Model model) {
		Class classDto = new Class();
		List<Student> studentList = studentService.getList();
		
		model.addAttribute("model", classDto);
		model.addAttribute("list", studentList);
		
		return "class_new";
	}
	
	@PostMapping("/class")
	public String createClass(Class classDto) {
		classService.create(classDto);
		return "redirect:/class";
	}
	
	@PutMapping("/class")
	public String updateClass(Class classDto) {
		classService.update(classDto);
		return "redirect:/class";
	}

}
