package com.genpact.attendance.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.genpact.attendance.model.Attendance;

public interface AttendanceRepository extends CrudRepository<Attendance,Long> {
	
	List<Attendance> findByEnrollmentClass_Id(Long id);

}
