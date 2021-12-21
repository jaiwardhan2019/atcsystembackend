package com.atcportal.PartAndProjectManager.daorepository;

import com.atcportal.PartAndProjectManager.models.ProjectMaster;
import com.atcportal.main.models.UserMaster;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProjectDao extends CrudRepository<ProjectMaster, Long> {

    ProjectMaster findByProjectName(int projectId);

    //----- Get latest project no + 1 from table project_master --------
    @Query("SELECT max(projectId)+1 as newProjNo  FROM ProjectMaster")
    int getLatestProjectId();


}