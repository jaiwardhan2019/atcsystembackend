package com.atcportal.main.models;

import javax.persistence.*;
import java.util.Date;

/*
 * Author :  Jai Wardhan
 * Date   :  30 - Nov - 2021
 * https://www.dineshonjava.com/hibernate/hibernate-many-to-one-mapping-tutorial/s
 *
 */

@Entity

@Table(name = "user_profile", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID")})
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@Column(name="USERID")
	private int  userId;

	@Column(name="PROFILEID")
	private String profileId;

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}


	@Column(name="ADDED_DATE")
	private Date addedDate;


	@Column(name="ADDED_BY_USER_NAME")
	private String addedByUserName;




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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