package com.atcportal.main.models;

import javax.persistence.*;

public class UserProfile {

	private int PROFILE_ID;
	private String SUB_MENU;

	public UserProfile(int PROFILE_ID, String SUB_MENU) {
		this.PROFILE_ID = PROFILE_ID;
		this.SUB_MENU = SUB_MENU;
	}

	public int getPROFILE_ID() {
		return PROFILE_ID;
	}

	public void setPROFILE_ID(int PROFILE_ID) {
		this.PROFILE_ID = PROFILE_ID;
	}

	public String getSUB_MENU() {
		return SUB_MENU;
	}

	public void setSUB_MENU(String SUB_MENU) {
		this.SUB_MENU = SUB_MENU;
	}



}