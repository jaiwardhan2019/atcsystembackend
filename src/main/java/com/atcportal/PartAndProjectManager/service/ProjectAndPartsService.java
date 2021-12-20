package com.atcportal.PartAndProjectManager.service;

import com.atcportal.PartAndProjectManager.customexception.projectExceptionMaster;
import com.atcportal.PartAndProjectManager.models.ProjectMaster;

import java.util.List;

public interface ProjectAndPartsService {


    //This will create new project and save data in table project_master.
    public ProjectMaster createNewProjectStep_01(ProjectMaster proj) throws projectExceptionMaster;


    //This will retrive project basic detail and the parameter is project_master.projectid(int).
    public List<ProjectMaster> listAllProject();


    //This will retrive project basic detail and the parameter is project_master.projectid(int).
    public ProjectMaster viewProjectBasicDetail(int projectId);




}
