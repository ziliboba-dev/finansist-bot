package com.sireev.finansistbot.actions;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.AppendValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Создание таблицы в Google Sheets
 */
@Component
@RequiredArgsConstructor
public class SpreadSheetOperations {

    private final Sheets sheets;

    public void appendValues(String spreadsheetId, String title, List<List<Object>> values) throws IOException {
        ValueRange body = new ValueRange()
                .setValues(values);
        AppendValuesResponse raw = sheets.spreadsheets()
                .values()
                .append(spreadsheetId, title, body)
                .setValueInputOption("RAW")
                .execute();
    }
}