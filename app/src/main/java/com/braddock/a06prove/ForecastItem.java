package com.braddock.a06prove;

import java.util.HashMap;
import java.util.Map;

public class ForecastItem {
    private String dt_txt; // time
    Map<String, Float> main = new HashMap<>(); // includes temperaatures, pressure, humidity etc

    float getTemp() {
        return main.get("temp");
    }

    float getTempMin() {
        return main.get("temp_min");
    }

    float getTempMax() {
        return main.get("temp_max");
    }

    String getTime() {
        return dt_txt;
    }
}
