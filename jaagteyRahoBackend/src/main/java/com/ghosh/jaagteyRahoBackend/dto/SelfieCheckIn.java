package com.ghosh.jaagteyRahoBackend.dto;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ghosh.jaagteyRahoBackend.Util;
import com.mysql.jdbc.Blob;

@Entity
public class SelfieCheckIn implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Transient
	private String profile_pic;

	@JsonIgnore
	@Lob
	private SerialBlob profile_image;

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
		if (getEmployee() == null) {
			return contactNumber;
		} else {
			return getEmployee().getContactNumber();
		}
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
		if (getCurrent_datetime() == null) {
			return current_datetimes;
		} else {
			return Util.convertTimestampToString(getCurrent_datetime());
		}
	}

	public void setCurrent_datetimes(String current_datetimes) {
		this.current_datetimes = current_datetimes;
	}

	public String getProfile_pic() {
		if (getProfile_image() == null) {
			return profile_pic;
		} else {
			InputStream is;
			try {
				is = getProfile_image().getBinaryStream();
				@SuppressWarnings("resource")
				java.util.Scanner s = new java.util.Scanner(is)
						.useDelimiter("\\A");
				String st = s.hasNext() ? s.next() : "";
				return st;
			} catch (SerialException e) {
				e.printStackTrace();
				return null;
			}

		}
	}

	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}

	public SerialBlob getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(SerialBlob profile_image) {
		this.profile_image = profile_image;
	}

}
