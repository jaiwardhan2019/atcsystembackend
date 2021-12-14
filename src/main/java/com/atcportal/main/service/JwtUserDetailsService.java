package com.atcportal.main.service;

import com.atcportal.main.daorepository.UserDao;
import com.atcportal.main.daorepository.UserProfileDao;
import com.atcportal.main.daorepository.UserProfileMasterDao;
import com.atcportal.main.models.UserMaster;
import com.atcportal.main.models.UserProfile;
import com.atcportal.main.models.enums.UserProfileIDs;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserProfileDao userProfileDao;

	@Autowired
	private UserProfileMasterDao userProfileMasterDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserMaster user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		user.setUserLoginCount(user.getUserLoginCount()+1);
		user.setLastLoginDate(new Date());
		userDao.save(user);
		return new org.springframework.security.core.
				userdetails.User(user.getUsername(), user.getPassword(),new ArrayList<>());
	}

	public UserDetails loadUserByUserId(long userId) throws UsernameNotFoundException {
		UserMaster user = userDao.findOne(Integer.valueOf(userId+""));
		if (user == null) {
			throw new UsernameNotFoundException("User not found with user id: " + userId);
		}
		return new org.springframework.security.core.
				userdetails.User(user.getUsername(), user.getPassword(),new ArrayList<>());
	}


	public Map<String, String> loadUserProfile(String username) throws UsernameNotFoundException {

		if (Strings.isNullOrEmpty(username)){
			throw new UsernameNotFoundException("User Name is missing ..!!");
		}

		List<Object[]> userProfileList = userProfileMasterDao.getUserProfileList(username);

		//---- Filter Object List and make------
		String userid      = null;
		String userName    = null;
		String userEmail   = null;
		String lastLoginDate = null;
		String userProfile = null;

		for (int i=0; i<userProfileList.size(); i++){
			Object[] row = (Object[]) userProfileList.get(i);
			List<String> elephantList = Arrays.asList(Arrays.toString(row).substring( 1, Arrays.toString(row).length() - 1 ).split("\\s*,\\s*"));
			userid= elephantList.get(0);
			userName =elephantList.get(1);
			userEmail=elephantList.get(2);
			lastLoginDate = elephantList.get(3);
			if(userProfile == null){userProfile=elephantList.get(5);}
			else{userProfile = userProfile + "," +elephantList.get(5);}
		}




		//----- Final Data Format will be returned ----------
		Map<String, String> userDetailWithProfile = new HashMap<String, String>();
		userDetailWithProfile.put("userid", userid);
		userDetailWithProfile.put("userName", userName);
		userDetailWithProfile.put("userEmail", userEmail);
		userDetailWithProfile.put("lastLoginDate", lastLoginDate);
		userDetailWithProfile.put("userProfile", userProfile);


		if (userProfileList == null) {
			throw new UsernameNotFoundException("No profile found for the username : " + username);
		}
		return userDetailWithProfile;
	}







	//------ Save User And Encoded Password to the DataBase
	public UserMaster registerNewUser(UserMaster user) throws Exception {

		if (user.equals(null)) {
			throw new UsernameNotFoundException("User details are Missing..!!:"+user);
		}
		try {
			UserMaster newUser = new UserMaster();
			newUser.setUserFullName(user.getUserFullName());
			newUser.setUserEmailID(user.getUserEmailID());
			newUser.setUserPhoneNo(user.getUserPhoneNo());
			newUser.setUsername(user.getUsername());
			newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			newUser.setGdprConsent(user.getGdprConsent());
			newUser = userDao.save(newUser);
			saveOrUpdateUserProfiles(newUser);
			return newUser;

		}
		catch(Exception e)
		{
			String errorMessage=e.toString();
			if(errorMessage.contains("USERNAME_UNIQUE")){errorMessage="Login Name :=> "+ user.getUsername() + " is allready in use ...!!";}
			if(errorMessage.contains("EMAIL_UNIQUE")){errorMessage="Email ID :=> "+ user.getUserEmailID() + " is allready in use " +
					" Please Correct your given Email ID or contact your Admin User to fix this issue...!!";}
			throw new Exception(errorMessage);
		}
	}

	private void saveOrUpdateUserProfiles(UserMaster userMaster) {
		if(userMaster != null && userMaster.getUserId() != 0) {
			List<UserProfile> userProfiles = new ArrayList<>();
			UserProfile userProfile = new UserProfile();
			userProfile.setUserId(Integer.valueOf(userMaster.getUserId()+""));
			userProfile.setAddedDate(new Date());
			for (UserProfileIDs userProfileID : UserProfileIDs.values()) {
				userProfile.setProfileId(userProfileID.getProfileId());
				userProfiles.add(userProfile);
			}
			userProfileDao.save(userProfiles);
		}

	}


	//------ This will update User Deatil to the user_master Table
	public UserMaster updateUser(UserMaster user) throws Exception {

		if (user.equals(null)) {
			throw new UsernameNotFoundException("User details are Missing..!!:"+user);
		}
		try {

			UserMaster updateUser = userDao.findByUsername(user.getUsername());
			updateUser.setUserFullName(user.getUserFullName());
			updateUser.setUserEmailID(user.getUserEmailID());
			updateUser.setUserPhoneNo(user.getUserPhoneNo());
			//updateUser.setUsername(user.getUsername());
			//updateUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			//updateUser.setGdprConsent(user.getGdprConsent());
			saveOrUpdateUserProfiles(updateUser);
			return userDao.save(updateUser);

		}
		catch(Exception e)
		{
			String errorMessage=e.toString();
			if(errorMessage.contains("USERNAME_UNIQUE")){errorMessage="Login Name :=> "+ user.getUsername() + " is allready in use ...!!";}
			if(errorMessage.contains("EMAIL_UNIQUE")){errorMessage="Email ID :=> "+ user.getUserEmailID() + " is allready in use " +
					" Please Correct your given Email ID or contact your Admin User to fix this issue...!!";}
			throw new Exception(errorMessage);
		}
	}


	public void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) { throw new Exception("USER_DISABLED", e); }
		  catch (BadCredentialsException e) { throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	public String manageUserProfile(int userId , int profileId , String action){
		if ("ADD".equalsIgnoreCase(action)) {
			UserProfile userProfile = new UserProfile();
			userProfile.setProfileId(profileId+"");
			userProfile.setUserId(userId);
			//userProfile.setAddedByUserName();
			userProfile.setAddedDate(new Date());
			userProfileDao.save(userProfile);
			return "Profile Added to the User..";
		}else if("DEL".equalsIgnoreCase(action)) {
			userProfileDao.deleteByUserIdAndProfileId(userId, profileId+"");
			return "Profile Removed..";
		}
		return "FAILED";
	}

	public void deleteUserByUserId(long userId){
		userDao.delete(Integer.valueOf(userId+""));
		deleteUserProfilesByUserId(userId);
	}

	private void deleteUserProfilesByUserId(long userId) {
		userProfileDao.delete(userProfileDao.findByUserId(Integer.valueOf(userId+"")));
	}
}