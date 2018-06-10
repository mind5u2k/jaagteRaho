package com.ghosh.jaagteyRahoBackend.dto;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PushNotificationsStatus {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private User employee;

	private Boolean latestStatuss = false;

	private int latestStatus = 1;

	private String sentOtp;
	private String sentStatus;
	private Timestamp sentTimestamp;

	@JsonIgnore
	@Transient
	private String otp;
	private String receivedStatus;
	private Timestamp receivedTimestamp;

	@JsonIgnore
	@Transient
	private String contactNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getEmployee() {
		return employee;
	}

	public void setEmployee(User employee) {
		this.employee = employee;
	}

	public String getSentOtp() {
		return sentOtp;
	}

	public void setSentOtp(String sentOtp) {
		this.sentOtp = sentOtp;
	}

	public String getSentStatus() {
		return sentStatus;
	}

	public void setSentStatus(String sentStatus) {
		this.sentStatus = sentStatus;
	}

	public Timestamp getSentTimestamp() {
		return sentTimestamp;
	}

	public void setSentTimestamp(Timestamp sentTimestamp) {
		this.sentTimestamp = sentTimestamp;
	}

	public String getReceivedStatus() {
		return receivedStatus;
	}

	public void setReceivedStatus(String receivedStatus) {
		this.receivedStatus = receivedStatus;
	}

	public Timestamp getReceivedTimestamp() {
		return receivedTimestamp;
	}

	public void setReceivedTimestamp(Timestamp receivedTimestamp) {
		this.receivedTimestamp = receivedTimestamp;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public int getLatestStatus() {
		return latestStatus;
	}

	public void setLatestStatus(int latestStatus) {
		this.latestStatus = latestStatus;
	}

	public Boolean getLatestStatuss() {
		return latestStatuss;
	}

	public void setLatestStatuss(Boolean latestStatuss) {
		this.latestStatuss = latestStatuss;
	}

}
