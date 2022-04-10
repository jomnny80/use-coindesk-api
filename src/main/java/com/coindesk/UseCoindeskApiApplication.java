package com.coindesk;

import com.coindesk.models.Coindesk;
import com.coindesk.repositories.CoindeskRepository;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class UseCoindeskApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UseCoindeskApiApplication.class, args);
	}


}
