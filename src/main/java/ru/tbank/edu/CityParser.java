package ru.tbank.edu;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Slf4j
public class CityParser {
    private static final Logger log = LoggerFactory.getLogger(CityParser.class);
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final XmlMapper xmlMapper = new XmlMapper();

    public Optional<City> parseCityFromFile(String filePath) {
        try {
            City city = objectMapper.readValue(new File(filePath), City.class);
            log.info("Успешно распарсено: {}", city);
            return Optional.of(city);
        } catch (IOException e) {
            log.error("Ошибка при парсинге файла {}: {}", filePath, e.getMessage());
            return Optional.empty();
        }
    }

    public String toXML(City city) {
        try {
            return xmlMapper.writeValueAsString(city);
        } catch (IOException e) {
            log.error("Ошибка при преобразовании в XML: {}", e.getMessage());
            return "<error>Ошибка при преобразовании в XML</error>";
        }
    }
}
