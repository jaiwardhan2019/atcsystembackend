package com.atcportal.main.DaoRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atcportal.main.models.UserProfile;


public interface UserProfileMasterDao extends JpaRepository<UserProfile, Integer>{
	
	@Query(value = "Select user_profile.PROFILE_ID as profileId, user_master.NAME as name, user_master.EMAIL as email, "
			+ "profile_master.MAIN_MENU as mainMenu, profile_master.SUB_MENU as subMenu from  "
			+ "user_master JOIN user_profile ON user_master.USER_ID = user_profile.USER_ID JOIN profile_master on profile_master.PROFILE_ID = user_profile.PROFILE_ID "
			+ "WHERE user_master.USERNAME=:username", nativeQuery=true)

	List<Object[]> getUserProfileList(@Param("username") String username);

}
