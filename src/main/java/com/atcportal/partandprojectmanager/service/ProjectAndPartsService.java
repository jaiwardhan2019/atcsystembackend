package com.atcportal.partandprojectmanager.service;

import com.atcportal.partandprojectmanager.customexception.projectExceptionMaster;
import com.atcportal.partandprojectmanager.models.PartsMaster;
import com.atcportal.partandprojectmanager.models.ProjectMaster;

import java.util.List;

public interface ProjectAndPartsService {



    /**
     * All Project related Services
     * Date : 18-Dec-2021
     */


    //This will Update new project and save data in table project_master.
    public String createProjectQuoteNoForNewProjectStep_01(String enginnerName) throws projectExceptionMaster;


    //This will Update new project and save data in table project_master.
    public ProjectMaster createNewProjectStep_01(ProjectMaster proj) throws projectExceptionMaster;


    //This will Attach Component -  Parts Detail to the Newly Created Project.
    public ProjectMaster createNewProjectStep_02(ProjectMaster proj) throws projectExceptionMaster;


    //This will retrive All Projects available in the table project_master.
    public List<ProjectMaster> listAllProject();



    //This will Retrive project Full detail and the parameter is project_master.projectid(int).
    public ProjectMaster viewProjectBasicDetail(int projectId);










    /**
     * All Part related Service
     * Date : 20-Dec-2021
     */

    public PartsMaster createNewPart(PartsMaster partObj);

    public List<PartsMaster> listAllParts();




}
