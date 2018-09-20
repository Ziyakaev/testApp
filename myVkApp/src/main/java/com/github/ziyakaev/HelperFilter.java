package com.github.ziyakaev;

import java.util.ArrayList;
import java.util.List;

public class HelperFilter {
    List<String>nameHouse=new ArrayList<>();

    public void setNameHouse() {
        this.nameHouse = nameHouse;
    }
    public void builderNameHouse(){
        nameHouse.add("сниму");
        nameHouse.add("сдам");
        nameHouse.add("вартир");
        nameHouse.add("комнат");
        nameHouse.add("одселени");
        nameHouse.add("arenda");
    }

    public List<String> getNameHouse() {
        return nameHouse;
    }
}
