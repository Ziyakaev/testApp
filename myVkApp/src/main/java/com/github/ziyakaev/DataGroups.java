package com.github.ziyakaev;

import com.github.ziyakaev.dto.Group;

import java.util.ArrayList;
import java.util.List;

public class DataGroups {
    List<GroupVk> groupToHouse = new ArrayList<>();
    List<GroupVk> groupToOther = new ArrayList<>();

    public void addGroupToHouse(Group data) {
        GroupVk groupVk = new GroupVk();
        groupVk.setGroup(data);
        this.groupToHouse.add(groupVk);

    }

    public void addGroupToOther(Group data) {
        GroupVk groupVk = new GroupVk();
        groupVk.setGroup(data);
        this.groupToOther.add(groupVk);

    }
}
