package com.atcportal.main.controller;

import com.atcportal.main.dto.request.UserProfileDto;
import com.atcportal.main.models.UserMaster;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.atcportal.main.service.JwtUserDetailsService;


/**
 * @author Jai.Wardhan
 *   https://www.javainuse.com/spring/boot-jwt-mysql
 *
 */

import com.atcportal.main.config.JwtTokenUtil;
import com.atcportal.main.models.JwtResponse;

import java.util.Date;
import java.util.Map;

@RestController
@CrossOrigin
public class JwtAuthManageUserController {


	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	//---------- Logger Initializer-------------------------------
	private final Logger logger = Logger.getLogger(JwtAuthManageUserController.class);

	/*
	 * Authenticate User with the User Username and Password Saved in Database
	 * If the user is validated then Create a new Token and pull the user detail along with their profile list
	 * */
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserMaster userdetail) throws Exception {

		//--- This part of code will validate User / Password and create JWT Token
		final UserDetails userDetails = userDetailsService.authenticate(userdetail.getUsername(), userdetail.getPassword());

		//final UserDetails userDetails = userDetailsService.loadUserByUsername(userdetail.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);


        //--- This will load User Profile for the Portal to populate Menu Sub menu  -----
		Map<String, String> userDetailAndProfile = userDetailsService.loadUserProfile(userdetail.getUsername());

		//--- This will Update User Last Login Date Time and update Login Count by +1  -----
		userDetailsService.updateUserLastLoginDateAdnLoginCount(userdetail.getUsername());

		logger.info(userdetail.getUsername()+" : Logged in on # "+new Date());

		//------- Create respones with user name and token and profile list -------
		return ResponseEntity.ok(new
				JwtResponse(userDetailAndProfile.get("userid"), userDetailAndProfile.get("userName"),
				userDetailAndProfile.get("userEmail"),userDetailAndProfile.get("lastLoginDate"), userDetailAndProfile.get("userProfileMainMenu"), userDetailAndProfile.get("userProfileAdminSubMenu") , token)
		);


	}


	//----- Will register User to the DB With Encoded Password ----------
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserMaster user) throws Exception {
		return ResponseEntity.ok(userDetailsService.registerNewUser(user));
	}



	//----- Will Take User Login Name as parameter and return User Detail  ----------
	@RequestMapping(value = "/viewyourdetail/{loginName}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> viewYourDetail(@PathVariable String loginName) throws Exception {
		return ResponseEntity.ok(userDetailsService.showMyDetail(loginName));
	}


	//----- Will Update User to the DB With Encoded Password ----------
	@RequestMapping(value = "/updateyourdetail", method = RequestMethod.POST)
	public ResponseEntity<?> updateYourDetail(@RequestBody UserMaster user) throws Exception {
		return ResponseEntity.ok(userDetailsService.updateYourDetail(user));
	}



	//----- Will Update User Password in the DB With Encoded Password ----------
	@RequestMapping(value = "/updateyourpassword", method = RequestMethod.POST)
	public ResponseEntity<?> updateYourPassword(@RequestBody UserMaster user) throws Exception {
		return ResponseEntity.ok(userDetailsService.updateYourPassword(user));
	}



	//----- This will return lost of all users available in the user_master table----------
	@RequestMapping(value = "/listusers", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listAllUsers() throws Exception {
		return ResponseEntity.ok(userDetailsService.getallUserList());
	}



	//----- Will pull User Detail by User id (int) -------------
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUserDetailsByUserId(@PathVariable long userId) throws Exception {

		final UserDetails userDetails = userDetailsService.loadUserByUserId(userId);
		//--- This will load User Profile for the Portal to populate Menu Sub menu  -----
		Map<String, String> userDetailAndProfile = userDetailsService.loadUserProfile(userDetails.getUsername());

		return ResponseEntity.ok(new
				JwtResponse(userDetailAndProfile.get("userid"), userDetailAndProfile.get("userName"),
				userDetailAndProfile.get("userEmail"),userDetailAndProfile.get("lastLoginDate"),
				userDetailAndProfile.get("userProfileMainMenu"), userDetailAndProfile.get("userProfileAdminSubMenu") ,
				null)
		);
	}


	//----- Will delete User from the DB With  ----------
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> deleteUserById(@PathVariable long userId) throws Exception {
		userDetailsService.deleteUserByUserId(userId);
		return ResponseEntity.noContent().build();
	}


	//----- Will manage User profile to the DB ----------
	@RequestMapping(value = "/user/profile", method = RequestMethod.POST)
	public ResponseEntity<?> manageUserProfile(@RequestBody UserProfileDto userProfileDto) throws Exception {
		return ResponseEntity.ok(userDetailsService.manageUserProfile(userProfileDto));
	}




}