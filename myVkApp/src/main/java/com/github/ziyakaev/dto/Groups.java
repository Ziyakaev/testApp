package com.github.ziyakaev.dto;

public class Groups {
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "ClassPojo [response = " + response + "]";
    }
}

