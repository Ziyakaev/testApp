package com.github.ziyakaev;

import com.github.ziyakaev.dto.Group;
import com.github.ziyakaev.dto.Groups;

import java.util.Arrays;
import java.util.List;

public class User {
    private String id;
    private String accessToken;
    private List<Group> groups;

    User(String id, String accessToken) {
        this.id = id;
        this.accessToken = accessToken;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    private List<Group> getGroupsRQ() {
        Utils.request("groups.get", Group.setParameterForGroup(this.id, accessToken));
        JsonHelper jsonHelper = new JsonHelper();
        Groups groups = (Groups) jsonHelper.getJson(Utils.response(), Groups.class);
        return Arrays.asList(groups.getResponse().getItems());
    }

    public void setGroups() {
        this.groups = this.getGroupsRQ();
    }
}
