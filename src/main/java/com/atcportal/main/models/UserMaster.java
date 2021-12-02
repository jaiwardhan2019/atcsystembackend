package com.atcportal.main.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user_master",uniqueConstraints = { @UniqueConstraint(columnNames = "LOGINNAME") })
public class UserMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long userId;

	@Column(name = "NAME")
	private String userFullName;

	@Column(name = "EMAIL")
	private String userEmailID;

	@Column(name = "PHONENO")
	private String userPhoneNo;


	@Column(name = "ADDRESS")
	private String userFullAddress;


	@Column(name = "LOGINNAME")
	private String username;


	@Column(name = "PASSWORD")
	private String password;


	@Column(name = "GDPRCONSENT")
	private String gdprConsent;


	// -------- All Getter and Setter ---------------

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

	/*
	@ManyToMany
	@JoinTable(name = "user_profile", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ID"))
	private Set<UserProfile> userProfile = new HashSet<>();
    */

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