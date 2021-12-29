package com.atcportal.partandprojectmanager.controller;

import com.atcportal.partandprojectmanager.customexception.projectException;
import com.atcportal.partandprojectmanager.service.ProjectAndPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PartsController {


    @Autowired
    ProjectAndPartsService  projPartsServObj;

    //----- Get all Parts list from the table  parts_master----------
    @RequestMapping(value = "/listallparts", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listAllParts() throws projectException {
        return ResponseEntity.ok(projPartsServObj.listAllParts());
    }





}