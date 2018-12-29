package com.github.ziyakaev;

import java.util.ArrayList;
import java.util.List;

public class HelperFilter {
    private List<String> keyWorldsForHouseGroup = new ArrayList<>();

    HelperFilter() {
        keyWorldsForHouseGroup.add("сниму");
        keyWorldsForHouseGroup.add("сдам");
        keyWorldsForHouseGroup.add("вартир");
        keyWorldsForHouseGroup.add("комнат");
        keyWorldsForHouseGroup.add("одселени");
        keyWorldsForHouseGroup.add("arenda");
        keyWorldsForHouseGroup.add("едвижимость");
    }

    public List<String> getKeyWorldsForHouseGroup() {
        return keyWorldsForHouseGroup;
    }

    // TODO: 08.11.2018 добавить фильтрацию
    public boolean DoFilter(String compareText) {
        for (String filter :keyWorldsForHouseGroup) {
            if (compareText.toUpperCase().contains(filter.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
