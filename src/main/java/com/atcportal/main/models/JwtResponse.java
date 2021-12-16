package com.atcportal.main.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;

	private final String userId;
	private final String userName;
	private final String userEmail;
	private final String lastLoginDate;
	private final String userProfileMainMenu;
	private final String userProfileAdminSubMenu;
	private final String authToken;

	public JwtResponse(String userId, String userName, String userEmail, String lastLoginDate, String userProfileMainMenu, String userProfileAdminSubMenu, String authToken) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.lastLoginDate = lastLoginDate;
		this.userProfileMainMenu = userProfileMainMenu;
		this.userProfileAdminSubMenu = userProfileAdminSubMenu;
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

	public String getUserProfileMainMenu() {
		return userProfileMainMenu;
	}

	public String getUserProfileAdminSubMenu() {
		return userProfileAdminSubMenu;
	}

	public String getAuthToken() {
		return authToken;
	}
}