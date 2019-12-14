package com.braddock.a06prove;

import java.util.ArrayList;
import java.util.List;

public class ForecastList {
    ArrayList<ForecastItem> list;

    ArrayList getList() {
        return list;
    }

    ArrayList getListAsString() {
        ArrayList<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            newList.add(list.get(i).getTime() + " " + list.get(i).getTemp());
        }
        return newList;
    }
}

