package com.genpact.attendance.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String schedule;
	
	private String description;
	
	@OneToMany(mappedBy="enrollmentClass")
	private List<Attendance> attendanceList;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="enrollment", joinColumns=@JoinColumn(name="class_id"), inverseJoinColumns=@JoinColumn(name="student_id"))
	private List<Student> studentList;
	
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
	
	public List<Attendance> getAttendanceList() {
		return attendanceList;
	}

	public void setAttendanceList(List<Attendance> attendanceList) {
		this.attendanceList = attendanceList;
	}
	
	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", schedule=" + schedule + ", description=" + description + "]";
	}
	
}
