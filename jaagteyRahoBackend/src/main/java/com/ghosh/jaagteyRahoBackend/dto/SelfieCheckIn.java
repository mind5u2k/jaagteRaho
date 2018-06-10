package com.ghosh.jaagteyRahoBackend.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ghosh.jaagteyRahoBackend.Util;

@Entity
public class SelfieCheckIn implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String profile_pic;
	@JsonIgnore
	private Timestamp current_datetime;

	@Transient
	private String current_datetimes;

	private String currentLocation;
	private String remark;

	@Transient
	private String contactNumber;

	@JsonIgnore
	@ManyToOne
	private User employee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProfile_pic() {
		return profile_pic;
	}

	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}

	public Timestamp getCurrent_datetime() {
		return current_datetime;
	}

	public void setCurrent_datetime(Timestamp current_datetime) {
		this.current_datetime = current_datetime;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getContactNumber() {
		return getEmployee().getContactNumber();
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public User getEmployee() {
		return employee;
	}

	public void setEmployee(User employee) {
		this.employee = employee;
	}

	public String getCurrent_datetimes() {
		return Util.convertTimestampToString(getCurrent_datetime());
	}

	public void setCurrent_datetimes(String current_datetimes) {
		this.current_datetimes = current_datetimes;
	}

}
