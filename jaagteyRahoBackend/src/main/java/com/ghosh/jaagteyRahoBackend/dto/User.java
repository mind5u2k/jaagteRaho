package com.ghosh.jaagteyRahoBackend.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String empId;

	private String firstName;
	private String middleName;
	private String lastName;

	private String email;

	private String contactNumber;
	private String alternateNumber;

	private String pushNotificationToken;

	@JsonIgnore
	@Transient
	private String authorizationToken;

	private String gender;

	@ManyToOne
	private Designation designation;

	private String aadhar;
	private String aadharImage;
	private String aadharUploaderName;

	private String panNumber;
	private String panImage;
	private String panUploaderName;

	private String corredpondenceAddress;
	private String corredpondencePostalCode;
	private String corredpondenceCity;
	private String corredpondenceState;
	private String corredpondenceCountry;

	private String permanentAddress;
	private String permanentPostalCode;
	private String permanentCity;
	private String permanentState;
	private String permanentCountry;

	private String profileImage;

	private String role;

	@JsonIgnore
	private String password;

	private String dob;

	private boolean enabled = true;

	@JsonIgnore
	@Transient
	private String confirmPassword;

	/*-@JsonCreator
	public User(@JsonProperty("id") int id,
			@JsonProperty("empId") String empId,
			@JsonProperty("firstName") String firstName,
			@JsonProperty("middleName") String middleName,
			@JsonProperty("lastName") String lastName,
			@JsonProperty("email") String email,
			@JsonProperty("contactNumber") String contactNumber) {
		this.id = id;
		this.empId = empId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.contactNumber = contactNumber;
	}*/

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", contactNumber="
				+ contactNumber + ", role=" + role + ", password=" + password
				+ ", enabled=" + enabled + "]";
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getAlternateNumber() {
		return alternateNumber;
	}

	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getCorredpondenceAddress() {
		return corredpondenceAddress;
	}

	public void setCorredpondenceAddress(String corredpondenceAddress) {
		this.corredpondenceAddress = corredpondenceAddress;
	}

	public String getCorredpondencePostalCode() {
		return corredpondencePostalCode;
	}

	public void setCorredpondencePostalCode(String corredpondencePostalCode) {
		this.corredpondencePostalCode = corredpondencePostalCode;
	}

	public String getCorredpondenceCity() {
		return corredpondenceCity;
	}

	public void setCorredpondenceCity(String corredpondenceCity) {
		this.corredpondenceCity = corredpondenceCity;
	}

	public String getCorredpondenceState() {
		return corredpondenceState;
	}

	public void setCorredpondenceState(String corredpondenceState) {
		this.corredpondenceState = corredpondenceState;
	}

	public String getCorredpondenceCountry() {
		return corredpondenceCountry;
	}

	public void setCorredpondenceCountry(String corredpondenceCountry) {
		this.corredpondenceCountry = corredpondenceCountry;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPermanentPostalCode() {
		return permanentPostalCode;
	}

	public void setPermanentPostalCode(String permanentPostalCode) {
		this.permanentPostalCode = permanentPostalCode;
	}

	public String getPermanentCity() {
		return permanentCity;
	}

	public void setPermanentCity(String permanentCity) {
		this.permanentCity = permanentCity;
	}

	public String getPermanentState() {
		return permanentState;
	}

	public void setPermanentState(String permanentState) {
		this.permanentState = permanentState;
	}

	public String getPermanentCountry() {
		return permanentCountry;
	}

	public void setPermanentCountry(String permanentCountry) {
		this.permanentCountry = permanentCountry;
	}

	public String getAadharUploaderName() {
		return aadharUploaderName;
	}

	public void setAadharUploaderName(String aadharUploaderName) {
		this.aadharUploaderName = aadharUploaderName;
	}

	public String getPanUploaderName() {
		return panUploaderName;
	}

	public void setPanUploaderName(String panUploaderName) {
		this.panUploaderName = panUploaderName;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getAadharImage() {
		return aadharImage;
	}

	public void setAadharImage(String aadharImage) {
		this.aadharImage = aadharImage;
	}

	public String getPanImage() {
		return panImage;
	}

	public void setPanImage(String panImage) {
		this.panImage = panImage;
	}

	public String getPushNotificationToken() {
		return pushNotificationToken;
	}

	public void setPushNotificationToken(String pushNotificationToken) {
		this.pushNotificationToken = pushNotificationToken;
	}

	public String getAuthorizationToken() {
		return authorizationToken;
	}

	public void setAuthorizationToken(String authorizationToken) {
		this.authorizationToken = authorizationToken;
	}

}
