package com.atcportal.main.daorepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.atcportal.main.models.UserMaster;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<UserMaster, Long> {
	
	UserMaster findByUsername(String userlLogin);

	//List<UserMaster> listAllUsers();

}