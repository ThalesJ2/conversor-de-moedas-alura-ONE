package com.coin.conversordemoedasgui.model;

import com.google.gson.JsonElement;

import java.util.HashMap;
import java.util.Map;

public class Currency {
    private String result;
    private Map<String, JsonElement> conversion_rates = new HashMap<>();

    public Currency() {
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String, JsonElement> getConversion_rates() {
        return conversion_rates;
    }

    public void setConversion_rates(Map<String, JsonElement> conversion_rates) {
        this.conversion_rates = conversion_rates;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "result='" + result + '\'' +
                ", conversion_rates=" + conversion_rates +
                '}';
    }
}
