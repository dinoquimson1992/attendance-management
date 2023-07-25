package com.genpact.attendance.repository;

import org.springframework.data.repository.CrudRepository;

import com.genpact.attendance.entity.Attendance;

public interface AttendanceRepository extends CrudRepository<Attendance,Long> {

}
