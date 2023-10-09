package com.sireev.finansistbot.actions;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.SpreadsheetProperties;
import com.sireev.finansistbot.configuration.GoogleAuthorizationConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Создание таблицы в Google Sheets
 */
@Component
@RequiredArgsConstructor
public class CreateSheet {

    private final Credential credentials;
    private final GoogleAuthorizationConfig googleAuthorizationConfig;

    /**
     * Create a new spreadsheet.
     *
     * @param title - the name of the sheet to be created.
     * @return newly created spreadsheet id
     * @throws IOException - if credentials file not found.
     */
    public String createSpreadsheet(String title) throws IOException {
        Sheets service = new Sheets.Builder(new NetHttpTransport(),
                GsonFactory.getDefaultInstance(),
                credentials)
                .setApplicationName(googleAuthorizationConfig.getAppName())
                .build();

        // Create new spreadsheet with a title
        Spreadsheet spreadsheet = new Spreadsheet()
                .setProperties(new SpreadsheetProperties()
                        .setTitle(title));
        spreadsheet = service.spreadsheets().create(spreadsheet)
                .setFields("spreadsheetId")
                .execute();
        // Prints the new spreadsheet id
        System.out.println("Spreadsheet ID: " + spreadsheet.getSpreadsheetId());
        return spreadsheet.getSpreadsheetId();
    }
}