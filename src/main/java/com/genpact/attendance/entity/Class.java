package com.genpact.attendance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String schedule;
	
	private String description;
	
	public Class() {}
	
	public Class(Long id) {
		this.id = id;
	}
	
	public Class(Long id, String name, String schedule, String description) {
		this.id = id;
		this.name = name;
		this.schedule = schedule;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", schedule=" + schedule + ", description=" + description + "]";
	}
	
}
