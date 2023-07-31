package com.genpact.attendance.dto;

import java.util.List;

import com.genpact.attendance.model.Attendance;
import com.genpact.attendance.model.Class;

public class AttendanceSearchDto {

	private Class enrollmentClass;

	private String date;
	
	private List<Attendance> list;
	
	private boolean searchMode = false;

	public AttendanceSearchDto() { }

	public AttendanceSearchDto(Class enrollmentClass, String date, List<Attendance> list) {
		this.enrollmentClass = enrollmentClass;
		this.date = date;
		this.list = list;
	}

	public Class getEnrollmentClass() {
		return enrollmentClass;
	}

	public void setEnrollmentClass(Class enrollmentClass) {
		this.enrollmentClass = enrollmentClass;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Attendance> getList() {
		return list;
	}

	public void setList(List<Attendance> list) {
		this.list = list;
	}
	
	public boolean isSearchMode() {
		return searchMode;
	}

	public void setSearchMode(boolean searchMode) {
		this.searchMode = searchMode;
	}

	@Override
	public String toString() {
		return "AttendanceSearchDto [class=" + enrollmentClass + ", date=" + date + ", list=" + list + "]";
	}
	
}
