package com.github;

import com.google.gson.annotations.SerializedName;
public class ResponseVk {
    @SerializedName("response")
    Groups response;

    public Groups getResponse() {
        return response;
    }

    public void setResponse(Groups response) {
        this.response = response;
    }
}
