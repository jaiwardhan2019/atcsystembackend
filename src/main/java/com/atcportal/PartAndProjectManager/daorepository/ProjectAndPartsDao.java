package com.atcportal.PartAndProjectManager.daorepository;

import com.atcportal.PartAndProjectManager.models.ProjectMaster;
import com.atcportal.main.models.UserMaster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectAndPartsDao extends CrudRepository<ProjectMaster, Integer> {
	
	UserMaster findByProjectName(String projectName);

}