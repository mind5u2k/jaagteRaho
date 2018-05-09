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

	private int geoRadius;

	private int reminderIntTime;

	private int autoCheckinIntTime;

	private int startTime;

	private int endTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGeoRadius() {
		return geoRadius;
	}

	public void setGeoRadius(int geoRadius) {
		this.geoRadius = geoRadius;
	}

	public int getReminderIntTime() {
		return reminderIntTime;
	}

	public void setReminderIntTime(int reminderIntTime) {
		this.reminderIntTime = reminderIntTime;
	}

	public int getAutoCheckinIntTime() {
		return autoCheckinIntTime;
	}

	public void setAutoCheckinIntTime(int autoCheckinIntTime) {
		this.autoCheckinIntTime = autoCheckinIntTime;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

}
