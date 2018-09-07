package com.ghosh.jaagteyRahoBackend.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class AutoCheckinSetting implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Transient
	private Client client;

	@ManyToOne
	private User employee;

	private String geoRadius;

	private String reminderIntTime;

	private String autoCheckinIntTime;

	private String startTime;

	private String endTime;

	private Integer pushNotification;

	private Integer msg;

	private Integer calls;

	public String getGeoRadius() {
		return geoRadius;
	}

	public void setGeoRadius(String geoRadius) {
		this.geoRadius = geoRadius;
	}

	public String getReminderIntTime() {
		return reminderIntTime;
	}

	public void setReminderIntTime(String reminderIntTime) {
		this.reminderIntTime = reminderIntTime;
	}

	public String getAutoCheckinIntTime() {
		return autoCheckinIntTime;
	}

	public void setAutoCheckinIntTime(String autoCheckinIntTime) {
		this.autoCheckinIntTime = autoCheckinIntTime;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Integer getPushNotification() {
		return pushNotification;
	}

	public void setPushNotification(Integer pushNotification) {
		this.pushNotification = pushNotification;
	}

	public Integer getMsg() {
		return msg;
	}

	public void setMsg(Integer msg) {
		this.msg = msg;
	}

	public Integer getCalls() {
		return calls;
	}

	public void setCalls(Integer calls) {
		this.calls = calls;
	}

}
