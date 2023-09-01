package com.osi.oneconnect.model;

import java.util.List;
public class Employee {
	private String employeeId;
	private String employeeName;
	private String reportingName;
	private String employeeEmailId;
	private String reportingEmailId;
	private List<String> pendingList;
	private List<String> attendedList;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getReportingName() {
		return reportingName;
	}

	public void setReportingName(String reportingName) {
		this.reportingName = reportingName;
	}

	public String getEmployeeEmailId() {
		return employeeEmailId;
	}

	public void setEmployeeEmailId(String employeeEmailId) {
		this.employeeEmailId = employeeEmailId;
	}

	public String getReportingEmailId() {
		return reportingEmailId;
	}

	public void setReportingEmailId(String reportingEmailId) {
		this.reportingEmailId = reportingEmailId;
	}

	public List<String> getPendingList() {
		return pendingList;
	}

	public void setPendingList(List<String> pendingList) {
		this.pendingList = pendingList;
	}

	public List<String> getAttendedList() {
		return attendedList;
	}

	public void setAttendedList(List<String> attendedList) {
		this.attendedList = attendedList;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", reportingName="
				+ reportingName + ", employeeEmailId=" + employeeEmailId + ", reportingEmailId=" + reportingEmailId
				+ ", pendingList=" + pendingList + ", attendedList=" + attendedList + "]";
	}
	
	

}
