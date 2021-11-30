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


	@Column(name = "LOGINNAME")
	private String username;


	@Column(name = "PASSWORD")
	private String password;
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