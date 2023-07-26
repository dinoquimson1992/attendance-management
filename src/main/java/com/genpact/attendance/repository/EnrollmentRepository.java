package com.genpact.attendance.repository;

import org.springframework.data.repository.CrudRepository;

import com.genpact.attendance.entity.Enrollment;

public interface EnrollmentRepository extends CrudRepository<Enrollment,Long> {
	
	void deleteByClassId(Long id);
	
}
