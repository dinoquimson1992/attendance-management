package com.genpact.attendance.repository;

import org.springframework.data.repository.CrudRepository;

import com.genpact.attendance.entity.Class;

public interface ClassRepository extends CrudRepository<Class,Long> {

}
