package com.atcportal.PartAndProjectManager.daorepository;

import com.atcportal.PartAndProjectManager.models.PartsMaster;
import com.atcportal.PartAndProjectManager.models.ProjectMaster;
import org.springframework.data.repository.CrudRepository;


public interface PartsDao extends CrudRepository<PartsMaster, Long> {

    PartsMaster findBypartShortDescription(String partShortDescription);

}