package com.atcportal.partandprojectmanager.daorepository;

import com.atcportal.partandprojectmanager.models.ProjectMainComponent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProjectMainComponentDao extends CrudRepository<ProjectMainComponent, Integer> {


    ProjectMainComponent findByprojectMainComponentId(int projectMainComponentId);

    /*
    @Query("SELECT max(PROJECTID)+1 FROM ProjectMaster")
    int findNewProjectId();
    List<ProjectMaster> findByEnginerIdOrderByOrderDateDesc(int enginerId);
    @Query("SELECT distinct(YEAR(ORDERDATE)) FROM ProjectMaster")
    List<String> findProjectYears();
    */

}