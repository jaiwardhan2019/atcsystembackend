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

@RestController
@CrossOrigin
public class JwtAuthenticationController {


	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;


	/*
	 * Authenticate User with the User ID and Password Saved in Database
	 * If the user is validated then create and return a token
	 * */
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserMaster userdetail) throws Exception {

		userDetailsService.authenticate(userdetail.getUsername(), userdetail.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(userdetail.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		//------- Create respones with user name and token and profile list -------
		return ResponseEntity.ok(new JwtResponse(token,userdetail.getUsername(), userDetailsService.loadUserProfile(userdetail.getUsername())));

	}


	//----- Will register User to the DB With Encoded Password ----------
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserMaster user) throws Exception {
		return ResponseEntity.ok(userDetailsService.registerNewUser(user));
	}



}