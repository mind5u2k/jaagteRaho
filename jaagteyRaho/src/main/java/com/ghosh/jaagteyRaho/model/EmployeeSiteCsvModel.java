package com.ghosh.jaagteyRaho.model;

public class EmployeeSiteCsvModel {

	private String clientCode = "";
	private String clientName = "";
	private String siteCode = "";
	private String siteName = "";
	private String siteAddress = "";
	private String AssignedEmployees = "";

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteAddress() {
		return siteAddress;
	}

	public void setSiteAddress(String siteAddress) {
		this.siteAddress = siteAddress;
	}

	public String getAssignedEmployees() {
		return AssignedEmployees;
	}

	public void setAssignedEmployees(String assignedEmployees) {
		AssignedEmployees = assignedEmployees;
	}

}
