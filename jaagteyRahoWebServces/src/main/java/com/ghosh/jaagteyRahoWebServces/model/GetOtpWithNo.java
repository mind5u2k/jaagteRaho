package com.ghosh.jaagteyRahoWebServces.model;


public class GetOtpWithNo {
	private String contactNumber;
	private String otp;
	private String profile_pic;
	private String current_datetimes;
	private String currentLocation;
	private String remark;

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

	public String getProfile_pic() {
		return profile_pic;
	}

	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}

	public String getCurrent_datetimes() {
		return current_datetimes;
	}

	public void setCurrent_datetimes(String current_datetimes) {
		this.current_datetimes = current_datetimes;
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
}
