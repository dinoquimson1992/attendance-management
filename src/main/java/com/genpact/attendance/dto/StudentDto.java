package com.genpact.attendance.dto;

import com.genpact.attendance.model.Student;

public class StudentDto {

	private Long id;

	private String firstName;

	private String lastName;

	private String address;
	
	public StudentDto() {}

	public StudentDto(Long id, String firstName, String lastName, String address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
	public static StudentDto convertFromEntity(Student student) {
		StudentDto dto = new StudentDto();
		dto.id = student.getId();
		dto.firstName = student.getFirstName();
		dto.lastName = student.getLastName();
		dto.address = student.getAddress();
		
		return dto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
