package com.genpact.attendance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ClassService classService;
	
	public List<Attendance> getAttendanceListByClassId(Long classId){
		return attendanceRepository.findByEnrollmentClass_Id(classId);
	}
	
	public List<Attendance> buildAttendanceList(Long classId, String date){
		List<Attendance> attendanceList = getAttendanceListByClassId(classId);
		List<Enrollment> enrollmentList = enrollmentService.getListByClassId(classId);
		List<Attendance> result = new ArrayList<Attendance>();
		
		for(Enrollment enrollment: enrollmentList) {
			Optional<Attendance> attendance = null;
			if(date == null) attendance = attendanceList.stream()
					.filter(a -> a.getStudent().getId().equals(enrollment.getStudentId()))
					.findFirst();
			if(date != null) attendance = attendanceList.stream()
					.filter(a -> a.getStudent().getId().equals(enrollment.getStudentId()))
					.filter(a -> date.equals(a.getDate()))
					.findFirst();
			
			if(!attendance.isPresent()) {
				Class enrollmentClass = classService.getClassById(enrollment.getClassId());
				Student student = studentService.getStudentById(enrollment.getStudentId());
				
				Attendance attendance2 = new Attendance();
				attendance2.setEnrollmentClass(enrollmentClass);
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
