package com.atcportal.main.models;

import java.io.Serializable;
import java.util.List;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private final String username;
	private List<UserProfile> userProfileList;

	//public JwtResponse(String jwttoken, String username, List<UserProfile> userProfileList) {
	public JwtResponse(String jwttoken, String username) {
		this.jwttoken = jwttoken;
		this.username = username;
		this.userProfileList = userProfileList;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public String getusername() {
		return this.username;
	}

	public List<UserProfile> getUserProfileList() {
		return this.userProfileList;
	}
}