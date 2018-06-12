package com.ghosh.jaagteyRahoWebServces.model;

import java.util.List;

import com.ghosh.jaagteyRahoBackend.dto.ContactPerson;

public class ContactPersonModel {

	private String status;
	private String msg;
	private List<ContactPerson> contactPersons;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ContactPerson> getContactPersons() {
		return contactPersons;
	}

	public void setContactPersons(List<ContactPerson> contactPersons) {
		this.contactPersons = contactPersons;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
