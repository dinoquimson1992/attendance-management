package com.genpact.attendance.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.attendance.entity.Attendance;
import com.genpact.attendance.entity.Class;
import com.genpact.attendance.entity.Enrollment;
import com.genpact.attendance.entity.Student;
import com.genpact.attendance.repository.AttendanceRepository;

@Service
public class AttendanceService {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private EnrollmentService enrollmentService;
	
	public List<Attendance> getAttendanceListByClassId(Long classId){
		return attendanceRepository.findByEnrollmentClass_Id(classId);
	}
	
	public List<Attendance> buildAttendanceList(Long classId){
		List<Attendance> attendanceList = getAttendanceListByClassId(classId);
		List<Enrollment> enrollmentList = enrollmentService.getListByClassId(classId);
		List<Attendance> result = new ArrayList<Attendance>();
		
		for(Enrollment enrollment: enrollmentList) {
			Attendance attendance = findInList(enrollment.getStudentId(), attendanceList);
			if(attendance == null) {
				Attendance attendance2 = new Attendance();
				attendance2.setEnrollmentClass(new Class(enrollment.getClassId()));
				attendance2.setStudent(new Student(enrollment.getStudentId()));
				
				result.add(attendance2);
			} else {
				result.add(attendance);
			}
		}
		
		return result;
	}
	
	private Attendance findInList(Long studentId, List<Attendance> list) {
		if(studentId == null || list == null) return null;
		
		for(Attendance attendance: list) {
			if(studentId == attendance.getStudent().getId()) return attendance;
		}
		
		return null;
	}

}
