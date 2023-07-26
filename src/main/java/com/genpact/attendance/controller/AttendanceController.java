package com.genpact.attendance.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.genpact.attendance.dto.AttendanceSearchDto;
import com.genpact.attendance.entity.Attendance;
import com.genpact.attendance.entity.Class;
import com.genpact.attendance.service.AttendanceService;
import com.genpact.attendance.service.ClassService;

@Controller
public class AttendanceController {
	
	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired
	private ClassService classService;
	
	@GetMapping("/attendance")
	public String getClassPage(Model model) {
		List<Class> classList = classService.getList();
		
		model.addAttribute("list", classList);
		
		return "attendance";
	}
	
	@GetMapping("/attendance/{classId}")
	public String getNewClassPage(@PathVariable Long classId, Model model) {
		Class selectedClass = classService.findById(classId);
		LocalDate today = LocalDate.now();
		
		List<Attendance> attendanceList = attendanceService.buildAttendanceList(classId);
		AttendanceSearchDto dto = new AttendanceSearchDto(selectedClass, today.toString(), attendanceList);
		
		model.addAttribute("model", dto);
		
		System.out.println("DTO List: " + dto.getList());
		
		return "attendance_new";
	}

}
