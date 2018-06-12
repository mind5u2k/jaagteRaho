package com.ghosh.jaagteyRahoWebServces.model;

import java.util.List;

import com.ghosh.jaagteyRahoBackend.dto.SelfieCheckIn;

public class SelfieCheckinModel {

	private String status;
	private String msg;
	private List<SelfieCheckIn> selfieCheckins;

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

	public List<SelfieCheckIn> getSelfieCheckins() {
		return selfieCheckins;
	}

	public void setSelfieCheckins(List<SelfieCheckIn> selfieCheckins) {
		this.selfieCheckins = selfieCheckins;
	}

}
