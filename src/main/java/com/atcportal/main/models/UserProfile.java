package com.atcportal.main.models;

import javax.persistence.*;

public class UserProfile {

	private int PROFILE_ID;
	private String PROFILE_NAME;

	public UserProfile(int PROFILE_ID, String PROFILE_NAME) {
		this.PROFILE_ID = PROFILE_ID;
		this.PROFILE_NAME = PROFILE_NAME;
	}

	public int getPROFILE_ID() {
		return PROFILE_ID;
	}

	public void setPROFILE_ID(int PROFILE_ID) {
		this.PROFILE_ID = PROFILE_ID;
	}

	public String getSUB_MENU() {
		return PROFILE_NAME;
	}

	public void setSUB_MENU(String PROFILE_NAME) {
		this.PROFILE_NAME = PROFILE_NAME;
	}



}