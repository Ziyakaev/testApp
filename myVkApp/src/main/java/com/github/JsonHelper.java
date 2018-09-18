package com.github;

import com.google.gson.Gson;
import dto.Groups;
import dto.Response;

public class JsonHelper {
    public Groups getJson(String data, Class<Groups> vkClass){
        Gson json=new Gson();
        Groups groups=json.fromJson(data,Groups.class);
        return groups;
    }

}
