package com.atcportal.PartAndProjectManager.daorepository;

import com.atcportal.PartAndProjectManager.models.PartsMaster;
import org.springframework.data.repository.CrudRepository;


public interface PartsDao extends CrudRepository<PartsMaster, Long> {

    PartsMaster findBypartShortDescription(String partShortDescription);

}