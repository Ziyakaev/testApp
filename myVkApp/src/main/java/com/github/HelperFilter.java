package com.github;

import java.util.ArrayList;
import java.util.List;

public class HelperFilter {
    List<String>nameHouse=new ArrayList<>();

    public void setNameHouse(List<String> nameHouse) {
        this.nameHouse = nameHouse;
    }
    public void builderNameHouse(){
        nameHouse.add("сниму");
        nameHouse.add("сдам");
        nameHouse.add("вартир");
        nameHouse.add("комнат");
        nameHouse.add("одселени");
    }

    public List<String> getNameHouse() {
        return nameHouse;
    }
}
