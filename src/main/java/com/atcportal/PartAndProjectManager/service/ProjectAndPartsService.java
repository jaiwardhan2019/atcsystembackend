package com.atcportal.PartAndProjectManager.service;

import com.atcportal.PartAndProjectManager.customexception.projectExceptionMaster;
import com.atcportal.PartAndProjectManager.models.PartsMaster;
import com.atcportal.PartAndProjectManager.models.ProjectMaster;

import java.util.List;

public interface ProjectAndPartsService {



    /**
     * All Part related Service
     * Date : 18-Dec-2021
     */

    //This will create new project and save data in table project_master.
    public ProjectMaster createNewProjectStep_01(ProjectMaster proj) throws projectExceptionMaster;


    //This will retrive All Projects available in the table project_master.
    public List<ProjectMaster> listAllProject();



    //This will retrive project basic detail and the parameter is project_master.projectid(int).
    public ProjectMaster viewProjectBasicDetail(int projectId);






    /**
     * All Part related Service
     * Date : 20-Dec-2021
     */

    public PartsMaster createNewPart(PartsMaster partObj);

    public List<PartsMaster> listAllParts();




}
