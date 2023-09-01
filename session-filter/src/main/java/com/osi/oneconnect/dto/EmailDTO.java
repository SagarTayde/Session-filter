package com.osi.oneconnect.dto;

import java.util.List;


public class EmailDTO {

	public String empName;

	public String to;

	public List<String> cc;

	public String subject;
	public String message;

	public boolean isHtml;

	public List<String> attendedList;

	public List<String> pendingList;
	

	public EmailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public EmailDTO(String empName, String to, List<String> cc, String subject, boolean isHtml,
			List<String> attendedList, List<String> pendingList) {
		super();
		this.empName = empName;
		this.to = to;
		this.cc = cc;
		this.subject = subject;
		this.isHtml = isHtml;
		this.attendedList = attendedList;
		this.pendingList = pendingList;
	}


	@Override
	public String toString() {
		return "EmailDTO [empName=" + empName + ", to=" + to + ", cc=" + cc + ", subject=" + subject + ", isHtml="
				+ isHtml + ", attendedList=" + attendedList + ", pendingList=" + pendingList + "]";
	}


	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public boolean isHtml() {
		return isHtml;
	}

	public void setHtml(boolean isHtml) {
		this.isHtml = isHtml;
	}

	public List<String> getAttendedList() {
		return attendedList;
	}

	public void setAttendedList(List<String> attendedList) {
		this.attendedList = attendedList;
	}

	public List<String> getPendingList() {
		return pendingList;
	}

	public void setPendingList(List<String> pendingList) {
		this.pendingList = pendingList;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	
	


}
