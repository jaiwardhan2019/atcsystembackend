package com.atcportal.main.models;

import javax.persistence.Embeddable;

@Embeddable
public class UserProfileMaster {
	
	public UserProfileMaster(String profileId, String name, String email, String mainMenu, String subMenu) {
		super();
		this.profileId = profileId;
		this.name = name;
		this.email = email;
		this.mainMenu = mainMenu;
		this.subMenu = subMenu;
	}

	private String profileId;
	
	private String name;
	
	private String email;
	
	private String mainMenu;
	
	private String subMenu;

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(String mainMenu) {
		this.mainMenu = mainMenu;
	}

	public String getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(String subMenu) {
		this.subMenu = subMenu;
	}
	
	
}
