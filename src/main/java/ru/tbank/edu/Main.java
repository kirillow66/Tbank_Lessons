package ru.tbank.edu;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        CityParser cityParser = new CityParser();

        Optional<City> cityOptional = cityParser.parseCityFromFile("city.json");

        if (cityOptional.isPresent()) {
            City city = cityOptional.get();
            String xmlOutput = cityParser.toXML(city);
            try (FileWriter writer = new FileWriter("city.xml")) {
                writer.write(xmlOutput);
                System.out.println("XML сохранён в файл city.xml");
            } catch (IOException e) {
                System.err.println("Ошибка при сохранении XML: " + e.getMessage());
            }
        } else {
            System.err.println("Город не найден или произошла ошибка при парсинге.");
        }

        cityParser.parseCityFromFile("city-error.json");
    }
}
