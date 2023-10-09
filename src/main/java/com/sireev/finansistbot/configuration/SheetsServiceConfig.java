package com.sireev.finansistbot.configuration;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Configuration
@RequiredArgsConstructor
public class SheetsServiceConfig {

    private final Credential credential;
    private final JsonFactory jsonFactory;
    private final GoogleAuthorizationConfig googleAuthorizationConfig;

    @Bean
    public Sheets sheets() throws IOException, GeneralSecurityException {
        return new Sheets.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                jsonFactory, credential)
                .setApplicationName(googleAuthorizationConfig.getAppName())
                .build();
    }

}
