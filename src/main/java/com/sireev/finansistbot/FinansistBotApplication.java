package com.sireev.finansistbot;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.util.Utils;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.security.GeneralSecurityException;

@SpringBootApplication
public class FinansistBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinansistBotApplication.class, args);
	}

	@Bean
	public JsonFactory getDefaultJsonFactory() {
		return Utils.getDefaultJsonFactory();
	}

	@Bean
	public NetHttpTransport getNetHttpTransport() throws GeneralSecurityException, IOException {
		return GoogleNetHttpTransport.newTrustedTransport();
	}

}
