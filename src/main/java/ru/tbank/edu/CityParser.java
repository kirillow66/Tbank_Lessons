package ru.tbank.edu;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class CityParser {
    private static final Logger logger = LoggerFactory.getLogger(CityParser.class);

    public City parseCityFromFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        City city = null;

        try {
            city = objectMapper.readValue(new File(filePath), City.class);
            logger.info("Успешно распарсено: {}", city);
        } catch (IOException e) {
            logger.error("Ошибка при парсинге файла {}: {}", filePath, e.getMessage());
        }

        return city;
    }

    public String toXML(City city) {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<city>\n");
        xmlBuilder.append("  <slug>").append(city.getSlug()).append("</slug>\n");
        xmlBuilder.append("  <coords>\n");
        xmlBuilder.append("    <lat>").append(city.getCoords().getLat()).append("</lat>\n");
        xmlBuilder.append("    <lon>").append(city.getCoords().getLon()).append("</lon>\n");
        xmlBuilder.append("  </coords>\n");
        xmlBuilder.append("</city>");
        return xmlBuilder.toString();
    }
}