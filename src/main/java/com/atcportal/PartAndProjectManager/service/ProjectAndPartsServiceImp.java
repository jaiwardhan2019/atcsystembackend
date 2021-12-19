package com.atcportal.PartAndProjectManager.service;

import com.atcportal.PartAndProjectManager.customexception.projectExceptionMaster;

import com.atcportal.PartAndProjectManager.models.ProjectMaster;
import com.atcportal.PartAndProjectManager.daorepository.ProjectAndPartsDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class ProjectAndPartsServiceImp implements ProjectAndPartsService {


	@Autowired
	private ProjectAndPartsDao projectDao;



	//---------- Logger Initializer-------------------------------
	private final Logger logger = Logger.getLogger(ProjectAndPartsServiceImp.class);



	@Override
	public ProjectMaster createNewProjectBasicDetail(ProjectMaster projObj) throws projectExceptionMaster {

		if (projObj.equals(null)) {throw new projectExceptionMaster("Project detail are Missing..!!:"+projObj);}

		try {
			ProjectMaster newProject = new ProjectMaster();
			newProject.setProjectName(projObj.getProjectName());
			newProject.setQuoteNumber(projObj.getQuoteNumber());
			newProject.setEnginerName(projObj.getEnginerName());
			newProject = projectDao.save(projObj);
			logger.info("New Project # "+projObj.getProjectName()+" : Create By # "+ projObj.getEnginerName()+ " On # "+new Date());
			return newProject;
		}

		catch(Exception projEx){
			String errorMessage=projEx.toString();
			//if(errorMessage.contains("USERNAME_UNIQUE")){errorMessage="Login Name :# "+ user.getUsername() + " is allready in use ...!!";}
			//if(errorMessage.contains("EMAIL_UNIQUE")){errorMessage="Email ID :# "+ user.getUserEmailID() + " is allready in use " +
			//		" Please Correct your given Email ID or contact your Admin User to fix this issue...!!";}
			throw new projectExceptionMaster(errorMessage);
		}

	}


	@Override
	public ProjectMaster viewProjectBasicDetail(int projectId) {

		return null;
	}


}