package com.atcportal.partandprojectmanager.service;

import com.atcportal.partandprojectmanager.customexception.projectException;
import com.atcportal.partandprojectmanager.customexception.projectMainComponentException;
import com.atcportal.partandprojectmanager.models.PartsMaster;
import com.atcportal.partandprojectmanager.models.ProjectMainComponent;
import com.atcportal.partandprojectmanager.models.ProjectMaster;

import java.util.List;

public interface ProjectAndPartsService {



    /**
     * All Project related Services
     * Date : 18-Dec-2021
     */


    //Will Update new project and save data in table project_master.
    public String createProjectQuoteNoForNewProjectStep_01(String enginnerName) throws projectException;


    //Will Create new project and save data in table project_master.
    public ProjectMaster createNewProjectStep_01(ProjectMaster proj) throws projectException;


    //Will Attach Component -  Parts Detail to the Newly Created Project.
    public ProjectMainComponent createNewProjectStep_02(ProjectMainComponent pmcObj) throws projectMainComponentException;


    //Will retrive All Projects available in the table project_master.
    public List<ProjectMaster> listAllProject();



    //Will Retrive project Full detail and the parameter is project_master.projectid(int).
    public ProjectMaster viewProjectBasicDetail(int projectId);










    /**
     * All Part related Service
     * Date : 20-Dec-2021
     */

    public PartsMaster createNewPart(PartsMaster partObj);

    public List<PartsMaster> listAllParts();




}
