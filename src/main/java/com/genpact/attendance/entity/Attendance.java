package com.genpact.attendance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Attendance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@JoinColumn(name = "class_id")
	private Class enrollmentClass;

	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;

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
