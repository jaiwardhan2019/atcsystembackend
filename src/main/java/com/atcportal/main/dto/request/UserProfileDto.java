package com.atcportal.main.dto.request;

import java.io.Serializable;

public class UserProfileDto implements Serializable {

    private int userId;

    private int profileId;

    private String action;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
