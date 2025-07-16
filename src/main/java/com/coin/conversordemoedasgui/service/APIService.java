package com.coin.conversordemoedasgui.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class APIService {


    public String callAPI(String address){

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request;

        request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();

        try {
            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
