package com.genpact.attendance.repository;

import org.springframework.data.repository.CrudRepository;

import com.genpact.attendance.entity.Student;

public interface StudentRepository extends CrudRepository<Student,Long> {

}
