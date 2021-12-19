package com.atcportal.PartAndProjectManager.service;

import com.atcportal.PartAndProjectManager.customexception.projectExceptionMaster;
import com.atcportal.PartAndProjectManager.models.ProjectMaster;

public interface ProjectAndPartsService {


    //This will create new project and save data in table project_master.
    public ProjectMaster createNewProjectBasicDetail(ProjectMaster proj) throws projectExceptionMaster;


    //This will retrive project basic detail and the parameter is project_master.projectid(int).
    public ProjectMaster viewProjectBasicDetail(int projectId);




}
