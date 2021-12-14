package com.atcportal.main.daorepository;

import com.atcportal.main.models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/*
* https://howtodoinjava.com/hibernate/hibernate-one-to-many-mapping/
* https://www.baeldung.com/jpa-queries-custom-result-with-aggregation-functions
*
**/

public interface UserProfileDao extends JpaRepository<UserProfile,  Integer> {

    List<UserProfile> findByUserId(int userId);

    void deleteByUserIdAndProfileId(int userId, String profileId);
}
