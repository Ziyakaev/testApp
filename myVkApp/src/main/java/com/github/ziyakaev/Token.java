package com.github.ziyakaev;

import com.google.gson.annotations.SerializedName;

public class Token {
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("expires_in")
    String expiresIn;
    @SerializedName("user_id")
    private int userId;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getUserId() {
        return userId;
    }
}
