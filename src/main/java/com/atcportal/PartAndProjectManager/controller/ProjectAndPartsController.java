package com.atcportal.PartAndProjectManager.controller;

import com.atcportal.PartAndProjectManager.customexception.projectExceptionMaster;
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

    //----- First Screen of Create Project   ----------
    @RequestMapping(value = "/createnewproject_01", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNewProject(@RequestBody ProjectMaster projObj) throws projectExceptionMaster {
        return ResponseEntity.ok(projPartsServObj.createNewProjectStep_01(projObj));
    }



    //----- Get all project from the table project_master  ----------
    @RequestMapping(value = "/listallproject", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listAllProject() throws projectExceptionMaster {
        return ResponseEntity.ok(projPartsServObj.listAllProject());
    }




    //----- Get all Parts list from the table  parts_master----------
    @RequestMapping(value = "/listallparts", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listAllParts() throws projectExceptionMaster {
        return ResponseEntity.ok(projPartsServObj.listAllParts());
    }





}