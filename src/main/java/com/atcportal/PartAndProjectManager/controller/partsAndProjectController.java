package com.atcportal.PartAndProjectManager.controller;

import com.atcportal.main.config.JwtTokenUtil;
import com.atcportal.main.models.UserMaster;
import com.atcportal.main.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class partsAndProjectController {


	@Autowired
	private JwtTokenUtil jwtTokenUtil;


	@Autowired
	private JwtUserDetailsService userDetailsService;


	//----- Will register User to the DB With Encoded Password ----------
	@RequestMapping(value = "/listproject", method = RequestMethod.POST)
	public ResponseEntity<?> projectList(@RequestBody UserMaster user) throws Exception {
		return ResponseEntity.ok(userDetailsService.registerNewUser(user));
	}



	//----- Will Update User to the DB With Encoded Password ----------
	@RequestMapping(value = "/viewproject", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestBody UserMaster user) throws Exception {
		return ResponseEntity.ok(userDetailsService.updateUser(user));
	}




}