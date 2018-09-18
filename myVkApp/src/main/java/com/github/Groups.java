package com.github;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Groups {
    @SerializedName("count")
    Integer count;
    @SerializedName("items")
    List<Group> items=new ArrayList<>();
    public Groups(){

    }
    public static Map<String,String> setParameterForGroup(String userId,String accessToken){
        Map<String,String> map=new HashMap<>();
        map.put("extended","1");
        map.put("user_id",userId);
        map.put("access_token",accessToken);
        map.put("v","5.80");
        return map;
    }

}
