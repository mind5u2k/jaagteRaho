package com.ghosh.jaagteyRahoWebServces.model;

import java.nio.charset.StandardCharsets;

import org.springframework.security.crypto.codec.Base64;

public class AuthUser {

	private String contactNo;
	private String password;

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void main(String[] args) {

		String auth = "anuraghosh.1992@gmail.com:admin@123";
		byte[] encodedAuth = Base64.encode(auth
				.getBytes(StandardCharsets.ISO_8859_1));
		String authHeader = "Basic " + new String(encodedAuth);

		System.out.println(authHeader);
	}
}
