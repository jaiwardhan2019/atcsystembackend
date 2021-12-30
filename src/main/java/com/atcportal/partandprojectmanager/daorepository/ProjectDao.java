package com.atcportal.partandprojectmanager.daorepository;

import com.atcportal.partandprojectmanager.models.ProjectMaster;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProjectDao extends CrudRepository<ProjectMaster, Integer> {


    ProjectMaster findByProjectName(int projectId);

    @Query("SELECT max(PROJECTID)+1 FROM ProjectMaster")
    int findNewProjectId();

    List<ProjectMaster> findByEnginerIdOrderByProjectIdDesc(int enginerId);

    @Query("SELECT distinct(YEAR(ORDERDATE)) FROM ProjectMaster")
    List<String> findProjectYears();


}