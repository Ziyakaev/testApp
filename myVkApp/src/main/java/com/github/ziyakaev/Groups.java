package com.github.ziyakaev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Groups extends com.github.ziyakaev.dto.Groups {
   ArrayList<GroupVk> groups=new ArrayList<>();
    public Groups(){

    }
    public static Map<String,String> setParameterForGroup(String userId,String accessToken){
        Map<String,String> map=new HashMap<>();
        map.put("extended","1");
        map.put("user_id",userId);
        map.put("access_token",accessToken);
        map.put("v","5.85");
        return map;
    }

}
