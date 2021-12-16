package com.atcportal.main.daorepository;

import com.atcportal.main.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
/*
* https://howtodoinjava.com/hibernate/hibernate-one-to-many-mapping/
* https://www.baeldung.com/jpa-queries-custom-result-with-aggregation-functions
*
**/

public interface UserProfileDao extends JpaRepository<UserProfile,  Integer> {

    List<UserProfile> findByUserId(int userId);
    //delete from user_profile where id=?
    @Query("delete from UserProfile where userId=?1 and profileId=?2")
    void deleteByUserIdAndProfileId(int userId, String profileId);

    @Query(value = "Select user_profile.PROFILE_ID as profileId, user_master.NAME as name, user_master.EMAIL as email, "
            + " user_master.LASTLOGINDATE as lastLoginDate , profile_master.MAIN_MENU as mainMenu, profile_master.SUB_MENU as subMenu from  "
            + "user_master JOIN user_profile ON user_master.USER_ID = user_profile.USER_ID JOIN profile_master on profile_master.PROFILE_ID = user_profile.PROFILE_ID "
            + "WHERE user_master.USERNAME=:username", nativeQuery=true)
    List<Object[]> getUserProfileList(@Param("username") String username);
}
