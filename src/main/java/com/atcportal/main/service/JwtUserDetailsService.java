package com.atcportal.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.atcportal.main.DaoRepository.UserDao;
import com.atcportal.main.DaoRepository.UserProfileMasterDao;
import com.atcportal.main.models.UserMaster;


@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserProfileMasterDao userProfileMasterDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserMaster user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.
				userdetails.User(user.getUsername(), user.getPassword(),new ArrayList<>());
	}




	public List<Object[]> loadUserProfile(String username) throws UsernameNotFoundException {
		List<Object[]> userProfileList = userProfileMasterDao.getUserProfileList(username);
		if (userProfileList == null) {
			throw new UsernameNotFoundException("No profile found for the username : " + username);
		}
		return userProfileList;
	}







	//------ Save User And Encoded Password to the DataBase
	public UserMaster registerNewUser(UserMaster user) {
		UserMaster newUser = new UserMaster();
		newUser.setUserFullName(user.getUserFullName());
		newUser.setUserEmailID(user.getUserEmailID());
		newUser.setUserPhoneNo(user.getUserPhoneNo());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userDao.save(newUser);
	}



	public void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) { throw new Exception("USER_DISABLED", e); }
		  catch (BadCredentialsException e) { throw new Exception("INVALID_CREDENTIALS", e);
		}
	}



}