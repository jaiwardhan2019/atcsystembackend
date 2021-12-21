package com.atcportal.partandprojectmanager.daorepository;

import com.atcportal.partandprojectmanager.models.PartsMaster;
import org.springframework.data.repository.CrudRepository;


public interface PartsDao extends CrudRepository<PartsMaster, Long> {

    PartsMaster findBypartShortDescription(String partShortDescription);

}