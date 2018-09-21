package com.github.ziyakaev;

import java.util.HashMap;
import java.util.Map;

public class Wall {
    String ownerId;
    int FriendsOnly;
    String message;
    String signed;
    public void wall(){

    }
    public static Map<String, String> setParameterForWall(String groupId, String message, String accessToken) {
        Map<String, String> map = new HashMap<>();
        map.put("owner_id",groupId);
        map.put("friends_only","0");
        map.put("message",message);
        map.put("mark_as_ads","0");
        map.put("access_token", accessToken);
        map.put("v", "5.80");
        return map;
    }
}
