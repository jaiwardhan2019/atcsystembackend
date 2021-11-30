package com.atcportal.main.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_profile_master")
public class ProfileMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PROFILE_ID")
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




}