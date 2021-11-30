package com.atcportal.main.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "profile_master")
public class ProfileMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long profileId;


	@Column(name = "MAIN_MENU")
	private String mainMenu;

	@Column(name = "SUB_MENU")
	private String subMenu;

	@Column(name="ADDED_DATE")
	private Date addedDate;



	public ProfileMaster(long profileId, String mainMenu, String subMenu, Date addedDate) {
		this.profileId = profileId;
		this.mainMenu = mainMenu;
		this.subMenu = subMenu;
		this.addedDate = addedDate;
	}

	public long getProfileId() {
		return profileId;
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

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
}