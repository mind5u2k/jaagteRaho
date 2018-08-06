package com.ghosh.jaagteyRahoBackend.dto;

import java.io.InputStream;
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

@Entity
public class PushNotificationsStatus {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonIgnore
	@ManyToOne
	private User employee;

	@JsonIgnore
	private Boolean latestStatuss = false;

	@JsonIgnore
	private int latestStatus = 1;

	@JsonIgnore
	private String sentOtp;
	private String sentStatus;
	@JsonIgnore
	private Timestamp sentTimestamp;
	@Transient
	private String sentTime;

	@Transient
	private String otp;

	private String receivedStatus;
	@JsonIgnore
	private Timestamp receivedTimestamp;
	@Transient
	private String receivedTime;

	@Transient
	private String profile_pic;

	@JsonIgnore
	@Lob
	private SerialBlob profile_image;

	@JsonIgnore
	private Timestamp current_datetime;

	@Transient
	@JsonIgnore
	private String current_datetimes;

	private String currentLocation;
	private String remark;

	@Transient
	private String contactNumber;

	private String sentBy;
	private String receivedBy;

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

	public String getCurrent_datetimes() {
		return current_datetimes;
	}

	public void setCurrent_datetimes(String current_datetimes) {
		this.current_datetimes = current_datetimes;
	}

	public Timestamp getCurrent_datetime() {
		return current_datetime;
	}

	public void setCurrent_datetime(Timestamp current_datetime) {
		this.current_datetime = current_datetime;
	}

	public SerialBlob getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(SerialBlob profile_image) {
		this.profile_image = profile_image;
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

	public String getSentTime() {
		if (getSentTimestamp() != null) {
			return Util.changeTimestampToString3(getSentTimestamp());
		}
		return "Not Sent";
	}

	public void setSentTime(String sentTime) {
		this.sentTime = sentTime;
	}

	public String getReceivedTime() {
		if (getReceivedTimestamp() != null) {
			return Util.changeTimestampToString3(getReceivedTimestamp());
		}
		return "Not Received";
	}

	public void setReceivedTime(String receivedTime) {
		this.receivedTime = receivedTime;
	}

	public String getSentBy() {
		return sentBy;
	}

	public void setSentBy(String sentBy) {
		this.sentBy = sentBy;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

}
