package com.genpact.attendance.dto;

import java.util.List;

public class ClassDto {

	private Long id;

	private String name;

	private String schedule;

	private String description;

	private List<Long> studentIdList;
	
	public ClassDto() {}

	public ClassDto(String name, String schedule, String description, List<Long> studentIdList) {
		this.name = name;
		this.schedule = schedule;
		this.description = description;
		this.studentIdList = studentIdList;
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

	public List<Long> getStudentIdList() {
		return studentIdList;
	}

	public void setStudentIdList(List<Long> studentIdList) {
		this.studentIdList = studentIdList;
	}

}
