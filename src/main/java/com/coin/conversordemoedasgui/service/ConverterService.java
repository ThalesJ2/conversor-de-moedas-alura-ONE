package com.coin.conversordemoedasgui.service;


import com.coin.conversordemoedasgui.model.Currency;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConverterService {

    private APIService apiService = new APIService();
    private final String KEY = System.getenv("API_KEY");
    private String address = "https://v6.exchangerate-api.com/v6/#1/latest/USD";
    private Gson gson = new Gson();
    private Currency currency = new Currency();

    public ConverterService() {
        loadData();
    }
    public List<String> getAcronym(){
        return new ArrayList<>(currency.getConversion_rates().keySet());
    }

    public Double coinValue(String symbol){
        String coin = String.valueOf(currency.getConversion_rates().get(symbol));
        return Double.parseDouble(coin);
    }

    public void loadData(){
        address = address.replace("#1",KEY);
        JsonObject jsonObject = gson.fromJson(apiService.callAPI(address), JsonObject.class);
        currency.setResult(jsonObject.get("result").getAsString());
        currency.setConversion_rates(jsonObject.getAsJsonObject("conversion_rates").asMap());
    }

    public  boolean isNumeric(String number){
        String regex = "-?\\d+(\\.\\d+)?";
        return number.matches(regex);
    }

    public void addLog(String log){
        Path path = Paths.get(System.getProperty("user.dir"),"src","main","resources");
        File file = new File(path+"\\logs.txt");
            try {
                FileWriter writer = new FileWriter(file,true);
                if(!file.exists()){
                    writer.write(log+"\n");
                    writer.close();
                }
                writer.append(log).append("\n");
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }

}
