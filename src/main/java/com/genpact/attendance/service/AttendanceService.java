package com.genpact.attendance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.attendance.model.Attendance;
import com.genpact.attendance.model.Class;
import com.genpact.attendance.model.Student;
import com.genpact.attendance.repository.AttendanceRepository;

@Service
public class AttendanceService {
	
	@Autowired
	private AttendanceRepository attendanceRepository;
	
	@Autowired
	private ClassService classService;
	
	public List<Attendance> getAttendanceListByClassId(Long classId){
		if(classId == null || classId == 0) throw new IllegalArgumentException("Class ID cannot be null!");
		return attendanceRepository.findByEnrollmentClass_Id(classId);
	}
	
	public List<Attendance> buildAttendanceList(Long classId, String date){
		if(classId == null || classId == 0) throw new IllegalArgumentException("Class ID cannot be null!");
		if(date == null || date.isEmpty()) throw new IllegalArgumentException("Date cannot be null!");
		
		List<Attendance> attendanceList = getAttendanceListByClassId(classId);
		Class studentClass = classService.getClassById(classId);
		List<Attendance> result = new ArrayList<Attendance>();
		
		for(Student student: studentClass.getStudentList()) {
			Optional<Attendance> attendance = attendanceList.stream()
					.filter(a -> student.getId().equals(a.getStudent().getId()))
					.filter(a -> date.equals(a.getDate()))
					.findFirst();
			
			if(!attendance.isPresent()) {
				Attendance attendance2 = new Attendance();
				attendance2.setEnrollmentClass(studentClass);
				attendance2.setStudent(student);
				
				result.add(attendance2);
			} else {
				result.add(attendance.get());
			}
		}
		
		return result;
	}
	
	public void save(Attendance attendance) {
		if(attendance == null) throw new IllegalArgumentException("Attendance must not be null!");
		attendanceRepository.save(attendance);
	}

}
