package com.genpact.attendance.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.genpact.attendance.dto.AttendanceSearchDto;
import com.genpact.attendance.model.Attendance;
import com.genpact.attendance.model.Class;
import com.genpact.attendance.service.AttendanceService;
import com.genpact.attendance.service.ClassService;

import jakarta.transaction.Transactional;

@Controller
public class AttendanceController {
	
	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired
	private ClassService classService;
	
	@GetMapping("/")
	public String getClassPage(Model model) {
		List<Class> classList = classService.getList();
		
		model.addAttribute("list", classList);
		
		return "attendance";
	}
	
	
	@GetMapping("/attendance/{classId}")
	public String getNewClassPage(@PathVariable Long classId, @RequestParam(value="date", required=false) String dateParam, Model model) {
		Class selectedClass = classService.getClassById(classId);
		String date = dateParam == null || dateParam.isEmpty() ? LocalDate.now().toString() : dateParam;
		
		List<Attendance> attendanceList = attendanceService.buildAttendanceList(classId, date);
		AttendanceSearchDto dto = new AttendanceSearchDto(selectedClass, date, attendanceList);
		
		model.addAttribute("model", dto);
		
		System.out.println("Date: " + dto.getDate());
		
		return "attendance_save";
	}
	
	@PostMapping("/attendance")
	@Transactional
	public String createClassPage(AttendanceSearchDto dto, Model model) {
		List<Attendance> attendanceList = dto.getList();
		
		System.out.println("Search Mode: " + dto.isSearchMode());
		
		if(!dto.isSearchMode()) {
			for(Attendance attendance: attendanceList) {
				attendance.setDate(dto.getDate());
				attendanceService.save(attendance);
			}
		}
		
		// use for search function
		Long classId = dto.getEnrollmentClass().getId();
		String date = dto.getDate();
		
		return String.format("redirect:/attendance/%s?date=%s", classId, date);
	}

}
