package com.github.ziyakaev;

import java.util.ArrayList;
import java.util.List;

public class WriterGroups {
    List<Integer> groupsId;
    List<Integer>groupsIdForBoards;
    WriterGroups(){
        this.groupsIdForBoards=new ArrayList<>();
        this.groupsId=new ArrayList<>();
    }
    public void addGroupsIdForBoards(int groupId){
        groupsIdForBoards.add(groupId);
    }
    public List<Integer> getGroupsIdForBoards() {
        return groupsIdForBoards;
    }

    public void addGroupsId(int groupsId) {
        this.groupsId.add(groupsId);
    }

    public List<Integer> getGroupsId() {
        return groupsId;
    }
}
