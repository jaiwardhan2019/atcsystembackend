package com.atcportal.main.DaoRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.atcportal.main.models.UserMaster;

@Repository
public interface UserDao extends CrudRepository<UserMaster, Integer> {
	
	UserMaster findByUsername(String userlLogin);


}