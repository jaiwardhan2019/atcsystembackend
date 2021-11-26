package com.atcportal.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.atcportal.main.models.UserDetail;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<UserDetail, Integer> {
	
	UserDetail findByUsername(String loginid);

}