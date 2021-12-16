package com.atcportal.main.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Date;

@Entity
@Table(name = "user_master",uniqueConstraints = { @UniqueConstraint(columnNames = "USERNAME") })
public class UserMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private long userId;

	@Column(name = "NAME")
	private String userFullName;

	@Column(name = "EMAIL")
	private String userEmailID;

	@Column(name = "PHONENO")
	private String userPhoneNo;


	@Column(name = "ADDRESS")
	private String userFullAddress;


	@Column(name = "USERNAME")
	private String username;


	@Column(name = "PASSWORD")
	private String password;


	@Column(name = "GDPRCONSENT")
	private String gdprConsent;

	@Column(name = "LASTLOGINDATE")
	private Date lastLoginDate;


	@Column(name = "USERLOGINCOUNT")
	private int userLoginCount;
	// -------- All Getter and Setter ---------------


	public int getUserLoginCount() {
		return userLoginCount;
	}

	public void setUserLoginCount(int userLoginCount) {
		this.userLoginCount = userLoginCount;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserEmailID() {
		return userEmailID;
	}

	public void setUserEmailID(String userEmailID) {
		this.userEmailID = userEmailID;
	}

	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

	public String getUserFullAddress() {
		return userFullAddress;
	}

	public void setUserFullAddress(String userFullAddress) {
		this.userFullAddress = userFullAddress;
	}

	public String getGdprConsent() {
		return gdprConsent;
	}

	public void setGdprConsent(String gdprConsent) {
		this.gdprConsent = gdprConsent;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}