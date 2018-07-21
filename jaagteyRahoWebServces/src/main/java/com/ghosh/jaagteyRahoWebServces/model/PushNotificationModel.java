package com.ghosh.jaagteyRahoWebServces.model;

import java.util.List;

import com.ghosh.jaagteyRahoBackend.dto.PushNotificationsStatus;

public class PushNotificationModel {
	private String status;
	private String msg;
	private List<PushNotificationsStatus> notificationsStatus;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<PushNotificationsStatus> getNotificationsStatus() {
		return notificationsStatus;
	}

	public void setNotificationsStatus(
			List<PushNotificationsStatus> notificationsStatus) {
		this.notificationsStatus = notificationsStatus;
	}

}
