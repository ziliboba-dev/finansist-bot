package com.sireev.finansistbot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Getter
public enum Categories {

    FOOD(
            "Продукты",
            List.of("еда", "продукты", "магазин", "фрукты", "севен")),
    BEER(
            "Пиво",
            List.of("пиво")),
    WEED(
            "weed",
            List.of("weed", "трава", "смола")),
    HOUSE_RENT(
            "Аренда дома",
            List.of("дом")),
    BIKE_RENT(
            "Аренда байка",
            List.of("байк", "мопед")),
    UTILITY_BILLS(
            "Коммунальные платежи",
            List.of("свет", "вода", "коммуналка")),
    NETWORK(
            "Связи и интернет",
            List.of("интернет", "телефон", "связь")),
    RESTAURANT(
            "Рестораны",
            List.of("ресторан", "кабак", "кафе", "завтрак")),
    LAZADA(
            "Lazada",
            List.of("lazada", "лазада")),
    OTHER(
            "Другое",
            Collections.emptyList());

    private final String name;
    private final List<String> categories;

}
