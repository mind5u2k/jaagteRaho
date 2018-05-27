package com.ghosh.jaagteyRahoWebServces.model;

import com.ghosh.jaagteyRahoBackend.dto.User;

public class LoginCredentials {

	private User user;
	private String authorizationToken;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAuthorizationToken() {
		return authorizationToken;
	}

	public void setAuthorizationToken(String authorizationToken) {
		this.authorizationToken = authorizationToken;
	}

}
