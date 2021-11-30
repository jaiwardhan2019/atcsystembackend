package com.atcportal.main.models;

import javax.persistence.*;
import java.util.Date;

/*
* Author :  Jai Wardhan
* Date   :  30 - Nov - 2021
* https://www.dineshonjava.com/hibernate/hibernate-many-to-one-mapping-tutorial/s
* https://stackoverflow.com/questions/56743810/how-to-join-3-tables-into-one-table-with-jpa
*/

@Entity
@Table(name = "user_profile")
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;


	@ManyToOne
	private UserMaster usrObj;

	@ManyToOne
	private ProfileMaster profileObj;


	@Column(name="ADDED_DATE")
	private Date addedDate;


	@Column(name="ADDED_BY_USER_NAME")
	private String addedByUserName;

	public UserProfile(int id, UserMaster usrObj, ProfileMaster profileObj, Date addedDate, String addedByUserName) {
		this.id = id;
		this.usrObj = usrObj;
		this.profileObj = profileObj;
		this.addedDate = addedDate;
		this.addedByUserName = addedByUserName;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserMaster getUsrObj() {
		return usrObj;
	}

	public void setUsrObj(UserMaster usrObj) {
		this.usrObj = usrObj;
	}

	public ProfileMaster getProfileObj() {
		return profileObj;
	}

	public void setProfileObj(ProfileMaster profileObj) {
		this.profileObj = profileObj;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public String getAddedByUserName() {
		return addedByUserName;
	}

	public void setAddedByUserName(String addedByUserName) {
		this.addedByUserName = addedByUserName;
	}


}