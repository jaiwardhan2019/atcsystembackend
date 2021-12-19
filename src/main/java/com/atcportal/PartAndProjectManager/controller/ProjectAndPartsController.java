package com.atcportal.PartAndProjectManager.controller;

import com.atcportal.PartAndProjectManager.models.ProjectMaster;
import com.atcportal.PartAndProjectManager.service.ProjectAndPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ProjectAndPartsController {


    @Autowired
    ProjectAndPartsService  projPartsServObj;

    //----- Will register User to the DB With Encoded Password ----------
    @RequestMapping(value = "/createnewproject", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNewProject(@RequestBody ProjectMaster projObj) throws Exception {
        System.out.println("Eng Name is :"+projObj.getEnginerName());
        return ResponseEntity.ok(projPartsServObj.createNewProjectBasicDetail(projObj));
    }




/*
	//----- Will register User to the DB With Encoded Password ----------
	@RequestMapping(value = "/listproject", method = RequestMethod.POST)
	public ResponseEntity<?> projectList(@RequestBody UserMaster user) throws Exception {
		return ResponseEntity.ok(userDetailsService.registerNewUser(user));
	}


	//----- Will Update User to the DB With Encoded Password ----------
	@RequestMapping(value = "/viewproject", method = RequestMethod.POST)
	public ResponseEntity<?> updateUser(@RequestBody UserMaster user) throws Exception {
		return ResponseEntity.ok(userDetailsService.updateYourDetail(user));
	}

*/


}