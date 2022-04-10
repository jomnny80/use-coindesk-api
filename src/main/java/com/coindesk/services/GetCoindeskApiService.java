package com.coindesk.services;

import com.coindesk.models.Coindesk;
import com.coindesk.repositories.CoindeskRepository;
import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class GetCoindeskApiService {

    public void getCoindesk(CoindeskRepository repository) {
        String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
        try {
            InputStream is = new URL(url).openStream();
            Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
            GsonBuilder builder = new GsonBuilder();
            builder.serializeNulls();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            Coindesk coindesk = gson.fromJson(reader, Coindesk.class);
            System.out.println("call coindesk api = " + coindesk);
//            repository.saveAndFlush(coindesk);
            System.out.println(repository.findAll());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
