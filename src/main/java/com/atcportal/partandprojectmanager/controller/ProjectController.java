package com.atcportal.partandprojectmanager.controller;

import com.atcportal.partandprojectmanager.customexception.projectExceptionMaster;
import com.atcportal.partandprojectmanager.models.ProjectMaster;
import com.atcportal.partandprojectmanager.service.ProjectAndPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ProjectController {


    @Autowired
    ProjectAndPartsService  projPartsServObj;

    //----- First Screen of Create Project   ----------
    @RequestMapping(value = "/createnewproject_01", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNewProjectStepOne(@RequestBody ProjectMaster projObj) throws projectExceptionMaster {
        return ResponseEntity.ok(projPartsServObj.createNewProjectStep_01(projObj));
    }



    //----- Second Screen of Create Project Add Component  ----------
    @RequestMapping(value = "/createnewproject_02", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNewProjectStepTwo(@RequestBody ProjectMaster projObj) throws projectExceptionMaster {
        return ResponseEntity.ok(projPartsServObj.createNewProjectStep_02(projObj));
    }




    //----- Get all project from the table project_master  ----------
    @RequestMapping(value = "/listallproject", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listAllProject() throws projectExceptionMaster {
        return ResponseEntity.ok(projPartsServObj.listAllProject());
    }




}