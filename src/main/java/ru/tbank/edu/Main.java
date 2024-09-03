package ru.tbank.edu;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        CityParser cityParser = new CityParser();

        City city = cityParser.parseCityFromFile("city.json");

        if (city != null) {
            String xmlOutput = cityParser.toXML(city);
            try (FileWriter writer = new FileWriter("city.xml")) {
                writer.write(xmlOutput);
                System.out.println("XML сохранён в файл city.xml");
            } catch (IOException e) {
                System.err.println("Ошибка при сохранении XML: " + e.getMessage());
            }
        }

        cityParser.parseCityFromFile("city-error.json");
    }
}