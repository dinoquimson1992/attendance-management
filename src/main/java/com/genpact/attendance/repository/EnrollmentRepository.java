package com.genpact.attendance.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.genpact.attendance.entity.Enrollment;

public interface EnrollmentRepository extends CrudRepository<Enrollment,Long> {
	
	List<Enrollment> findByClassId(Long id);
	
	void deleteByClassId(Long id);
	
}
