package com.github;

import java.util.ArrayList;
import java.util.List;

public class DataGroups {
    List<dto.Group> groupToHouse =new ArrayList<>();
    List<dto.Group> groupToOther=new ArrayList<>();

    public void addGroupToHouse(dto.Group data){
        this.groupToHouse.add(data);
    }
}
