package com.atcportal.partandprojectmanager.service;

import com.atcportal.partandprojectmanager.customexception.projectExceptionMaster;

import com.atcportal.partandprojectmanager.daorepository.PartsDao;
import com.atcportal.partandprojectmanager.models.PartsMaster;
import com.atcportal.partandprojectmanager.models.ProjectMaster;
import com.atcportal.partandprojectmanager.daorepository.ProjectDao;
import com.atcportal.partandprojectmanager.models.enums.ProjectStatus;
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
	public String createProjectQuoteNoForNewProjectStep_01(String engineerName) throws projectExceptionMaster {
		//-- Generate new Quote No for Project----
		String newProjectQuoteno = populateRefNo(engineerName,projectDao.findNewProjectId());
		ProjectMaster newProject = new ProjectMaster();
		newProject.setQuoteNumber(newProjectQuoteno);
		newProject.setEnginerName(engineerName);
		newProject = projectDao.save(newProject);
		return newProjectQuoteno;
	}




	@Override
	public ProjectMaster createNewProjectStep_01(ProjectMaster projObj) throws projectExceptionMaster {

		if (projObj.equals(null)) {throw new projectExceptionMaster("Project detail are Missing..!!:"+projObj);}

		try {

			ProjectMaster newProject = new ProjectMaster();

			//----When Project Save button in clicked first Time-----
			if(projObj.getProjectId() == 0){
				String newProjectQuoteno = populateRefNo(projObj.getEnginerName(),projectDao.findNewProjectId());
				newProject.setQuoteNumber(newProjectQuoteno);
			}

			if(projObj.getProjectId() != 0){
				newProject = projectDao.findOne(projObj.getProjectId());
			}


			//-- Generate new Quote No for Project----
			newProject.setProjectName(projObj.getProjectName());
			newProject.setSiteName(projObj.getSiteName());
			newProject.setCityName(projObj.getCityName());
			newProject.setPostCode(projObj.getPostCode());
			newProject.setEnginerName(projObj.getEnginerName());
			newProject.setEnginerId(projObj.getEnginerId());
			newProject.setQuoteType(projObj.getQuoteType());
			newProject.setMaket(projObj.getMaket());
			newProject.setCompetion(projObj.getCompetion());
			newProject.setContractType(projObj.getContractType());
			newProject.setCustomerType(projObj.getCustomerType());
			newProject.setOrderDate(projObj.getOrderDate());
			newProject.setPossiblityChance(projObj.getPossiblityChance());

			System.out.println("Order Date:"+projObj.getOrderDate());



			//newProject.setProjectEstPrice(projObj.getProjectEstPrice());
			newProject.setProjectStatus(ProjectStatus.Inprocess.name());



			newProject = projectDao.save(newProject);
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
	public ProjectMaster createNewProjectStep_02(ProjectMaster proj) throws projectExceptionMaster {
		return null;
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










	private String populateRefNo(String engineerName , int serialno){

		String nameInitial[] = engineerName.split(" ");
		String quoteNumber =null;
		if(nameInitial.length > 1){
			quoteNumber = Character.toString(nameInitial[0].charAt(0)) + Character.toString(nameInitial[1].charAt(0));
		}
		else{
			quoteNumber = Character.toString(nameInitial[0].charAt(0)) + Character.toString(nameInitial[0].charAt(1))+
					Character.toString(nameInitial[0].charAt(2));

		}
		quoteNumber=quoteNumber.toUpperCase();


		Date d=new Date();
		int year=d.getYear()+1900;
		String currentYear = Integer.toString(year);

		quoteNumber = quoteNumber + currentYear.substring(currentYear.length()-2);
		quoteNumber = quoteNumber + padLeftZeros(Integer.toString(serialno),4);
		return quoteNumber;
	}




	private String padLeftZeros(String inputString, int length) {
		if (inputString.length() >= length) {
			return inputString;
		}
		StringBuilder sb = new StringBuilder();
		while (sb.length() < length - inputString.length()) {
			sb.append('0');
		}
		sb.append(inputString);
		return sb.toString();
	}












}