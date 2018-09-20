package com.github.ziyakaev.dto;

public class Boards
{
    private ResponseToBoard response;

    public ResponseToBoard getResponse ()
    {
        return response;
    }

    public void setResponse (ResponseToBoard response)
    {
        this.response = response;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [response = "+response+"]";
    }
}
