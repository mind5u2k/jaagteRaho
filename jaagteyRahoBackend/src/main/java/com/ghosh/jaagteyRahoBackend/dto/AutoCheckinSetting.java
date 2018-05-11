package com.ghosh.jaagteyRahoBackend.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AutoCheckinSetting implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String geoRadius;

	private String reminderIntTime;

	private String autoCheckinIntTime;

	private String startTime;

	private String endTime;

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

}
