package com.genpact.attendance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "class_id")
	private Class enrollmentClass;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@NotNull
	@NotEmpty
	private String date;

	private Boolean isPresent;

	private Boolean isAbsent;

	private Boolean isLeave;

	private String remarks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Class getEnrollmentClass() {
		return enrollmentClass;
	}

	public void setEnrollmentClass(Class enrollmentClass) {
		this.enrollmentClass = enrollmentClass;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Boolean getIsPresent() {
		return isPresent;
	}

	public void setIsPresent(Boolean isPresent) {
		this.isPresent = isPresent;
	}

	public Boolean getIsAbsent() {
		return isAbsent;
	}

	public void setIsAbsent(Boolean isAbsent) {
		this.isAbsent = isAbsent;
	}

	public Boolean getIsLeave() {
		return isLeave;
	}

	public void setIsLeave(Boolean isLeave) {
		this.isLeave = isLeave;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Attendance [id=" + id + ", enrollmentClass=" + enrollmentClass + ", student=" + student + ", isPresent="
				+ isPresent + ", isAbsent=" + isAbsent + ", isLeave=" + isLeave + ", remarks=" + remarks + "]";
	}
	
}
