package com.braddock.a06prove;

import java.util.HashMap;
import java.util.Map;

public class Weather {

    //Map<String, Float> coord = new HashMap<>();
    //Map<String, Float> weather = new HashMap<>();
    Map<String, Float> main = new HashMap<>();
    //Map<String, Float> wind = new HashMap<>();
    //Map<String, Float> sys = new HashMap<>();

    public float getTemp() {
        return main.get("temp");
    }
}
