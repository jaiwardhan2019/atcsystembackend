package com.atcportal.main.models;

import java.io.Serializable;
import java.util.List;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;

	private final String userId;
	private final String userName;
	private final String userEmail;
	private final String lastLoginDate;
	private final String userProfileList;
	private final String authToken;

	public JwtResponse(String userId, String userName, String userEmail, String lastLoginDate, String userProfileList, String authToken) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.lastLoginDate = lastLoginDate;
		this.userProfileList = userProfileList;
		this.authToken = authToken;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getLastLoginDate() {
		return lastLoginDate;
	}

	public String getUserProfileList() {
		return userProfileList;
	}

	public String getAuthToken() {
		return authToken;
	}
}