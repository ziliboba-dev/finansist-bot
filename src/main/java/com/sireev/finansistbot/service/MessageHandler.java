package com.sireev.finansistbot.service;

import com.sireev.finansistbot.actions.SpreadSheetOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MessageHandler {

    private final SpreadSheetOperations spreadSheetOperations;

    @Value("${google.sheets.spreadsheetId}")
    private String spreadsheetId;

    public void handleMessage(String msgText) throws IOException {
        if ("/start".equals(msgText)) {

        } else {
            String[] msgArr = msgText.split(" ");
            spreadSheetOperations.appendValues(
                    spreadsheetId,
                    "Лист1",
                    List.of(List.of(msgArr)));
        }
    }

}
