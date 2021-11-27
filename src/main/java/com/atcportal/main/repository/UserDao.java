package com.atcportal.main.repository;

import com.atcportal.main.models.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.atcportal.main.models.UserDetail;

import java.util.Collection;
import java.util.List;

@Repository
public interface UserDao extends CrudRepository<UserDetail, Integer> {
	
	UserDetail findByUsername(String loginid);

	@Query("select p from Person p where p.identifier = :identifier")
	UserDetail findAllActiveUsersProfile(String loginid);

/*
	@Query(value = "SELECT * FROM USERS u WHERE u.status = 1",nativeQuery = true)
	Collection<UserProfile> findAllActiveUsersNative();


	@Query("select p from Person p where p.identifier = :identifier")
	Person findAllActiveUsersProfile(@Param("usedcode") String usedcode);*/

}