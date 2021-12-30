package com.atcportal.main.models.enums;

public enum UserProfileIDs {

    PROFILE_ONE("1"), PROFILE_TWO("2"), PROFILE_THREE("3"), PROFILE_FOUR("4"),PROFILE_FIVE("5"), PROFILE_SIX("6")
    ,PROFILE_SEVEN("7");
    
    private String profileId;

    public String getProfileId() {
        return profileId;
    }

    UserProfileIDs(String profileId) {
        this.profileId = profileId;
    }

}
