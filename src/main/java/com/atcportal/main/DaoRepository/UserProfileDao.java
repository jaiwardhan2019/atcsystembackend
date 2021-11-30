package com.atcportal.main.DaoRepository;

import com.atcportal.main.models.UserMaster;
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

    /*
    @Query("SELECT c.addedDate, COUNT(c.addedDate) FROM UserProfile AS c ")
    List<Object[]> getUserProfileList();
    */

/*    @Query("SELECT UP.addedByUserName AS addedByUserName FROM UserProfile AS UP where UP.userId=1")
    List<String> getUserProfileList();*/


}
