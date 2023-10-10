package com.sireev.finansistbot.configuration;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Configuration
@RequiredArgsConstructor
public class SheetsServiceConfig {

    private final GoogleAuthorizationManager authorizationManager;
    private final GoogleAuthorizationManager googleAuthorizationManager;

    @Bean
    public Sheets sheets() throws IOException, GeneralSecurityException {
        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new Sheets.Builder(
                httpTransport,
                GsonFactory.getDefaultInstance(),
                authorizationManager.getCredentials(httpTransport))
                .setApplicationName(googleAuthorizationManager.getAppName())
                .build();
    }

}
