package com.atcportal.main.controller;

import com.atcportal.main.models.UserMaster;
import com.atcportal.main.models.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.atcportal.main.service.JwtUserDetailsService;


/**
 * @author Jai.Wardhan
 *   https://www.javainuse.com/spring/boot-jwt-mysql
 *
 */

import com.atcportal.main.config.JwtTokenUtil;
import com.atcportal.main.models.JwtResponse;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class JwtAuthenticationController {


	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;


	/*
	 * Authenticate User with the User ID and Password Saved in Database
	 * If the user is validated then Create a new Token and pull the user detail along with their profile list
	 * */
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserMaster userdetail) throws Exception {

		//--- This part of code will validate User / Password and create JWT Token
		userDetailsService.authenticate(userdetail.getUsername(), userdetail.getPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(userdetail.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);

        //--- This will load User Profile for the Portal to populate Menu Sub menu  -----
		Map<String, String> userDetailAndProfile = userDetailsService.loadUserProfile(userdetail.getUsername());

		//------- Create respones with user name and token and profile list -------
		return ResponseEntity.ok(new
				JwtResponse(userDetailAndProfile.get("userid"), userDetailAndProfile.get("userName"),
				userDetailAndProfile.get("userEmail"),userDetailAndProfile.get("lastLoginDate"), userDetailAndProfile.get("userProfile"), token)
		);


	}


	//----- Will register User to the DB With Encoded Password ----------
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserMaster user) throws Exception {
		return ResponseEntity.ok(userDetailsService.registerNewUser(user));
	}



}