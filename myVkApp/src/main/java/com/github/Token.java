package com.github;

import com.google.gson.annotations.SerializedName;

public class Token {
    @SerializedName("access_token")
    String accessToken;
    @SerializedName("expires_in")
    String expiresIn;
    @SerializedName("user_id")
    int userId;
}
