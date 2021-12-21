package com.atcportal.partandprojectmanager.service;

import com.atcportal.partandprojectmanager.customexception.projectExceptionMaster;

import com.atcportal.partandprojectmanager.daorepository.PartsDao;
import com.atcportal.partandprojectmanager.models.PartsMaster;
import com.atcportal.partandprojectmanager.models.ProjectMaster;
import com.atcportal.partandprojectmanager.daorepository.ProjectDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ProjectAndPartsServiceImp implements ProjectAndPartsService {


	@Autowired
	private ProjectDao projectDao;


	@Autowired
	private PartsDao partsDao;


	//---------- Logger Initializer-------------------------------
	private final Logger logger = Logger.getLogger(ProjectAndPartsServiceImp.class);



	@Override
	public ProjectMaster createNewProjectStep_01(ProjectMaster projObj) throws projectExceptionMaster {

		if (projObj.equals(null)) {throw new projectExceptionMaster("Project detail are Missing..!!:"+projObj);}

		try {
			ProjectMaster newProject = new ProjectMaster();
			newProject.setProjectName(projObj.getProjectName());
			newProject.setQuoteNumber(projObj.getQuoteNumber());
			newProject.setRevisionNo(projObj.getRevisionNo());
			newProject.setSiteName(projObj.getSiteName());
			newProject.setEnginerName(projObj.getEnginerName());
			newProject.setEnginerId(projObj.getEnginerId());
			newProject.setProjectEstPrice(projObj.getProjectEstPrice());
			newProject.setProjectStatus(projObj.getProjectStatus());
			newProject = projectDao.save(projObj);
			logger.info("New Project # "+projObj.getProjectName()+" : Create By # "+ projObj.getEnginerName()+ " On # "+new Date());
			return newProject;
		}
		catch(Exception projEx){
			String errorMessage=projEx.toString();
			logger.error(errorMessage);
			throw new projectExceptionMaster(errorMessage);
		}

	}




	@Override
	public List<ProjectMaster> listAllProject() {

		return (List<ProjectMaster>) projectDao.findAll();
	}



	@Override
	public ProjectMaster viewProjectBasicDetail(int projectId) {

		return projectDao.findOne(projectId);
	}









	/**
	 * All Part related Service
	 * Date : 20-Dec-2021
	 */

	//------- Create New Parts
	@Override
	public PartsMaster createNewPart(PartsMaster partObj) {
		return null;
	}


	//------- List All Parts from Database
	@Override
	public List<PartsMaster> listAllParts() {
		return (List<PartsMaster>) partsDao.findAll();
	}


}