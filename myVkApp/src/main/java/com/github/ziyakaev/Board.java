package com.github.ziyakaev;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Board {
    BoardForTopic boardForTopic = new BoardForTopic();
    @SerializedName("id")
    int id;
    @SerializedName("title")
    String title;
    @SerializedName("created")
    int created;
    @SerializedName("updated")
    int updated;
    @SerializedName("updated_by")
    int updatedBy;
    @SerializedName("is_closed")
    int isClosed;
    @SerializedName("is_fixed")
    int isFixed;
    @SerializedName("comments")
    int comments;

    GroupVk group = new GroupVk();


    public class BoardForTopic {
        int groupId;

        public void setTopic(int groupId) {
            this.groupId = groupId;

        }

        public int getGroupId() {
            return groupId;
        }
    }

    public static Map<String, String> setParameterForBoard(String groupId, String accessToken) {
        Map<String, String> map = new HashMap<>();
        map.put("group_id", groupId);
        map.put("count", "40");
        map.put("preview_length", "90");
        map.put("access_token", accessToken);
        map.put("v", "5.80");
        return map;
    }

    public static Map<String, String> setParameterForComments(String groupId,String topicId,String message,String accessToken) {
        Map<String, String> map = new HashMap<>();
        map.put("group_id",groupId);
        map.put("topic_id",topicId);
        map.put("message",message);
        map.put("access_token", accessToken);
        map.put("v", "5.80");
        return map;
    }
}
