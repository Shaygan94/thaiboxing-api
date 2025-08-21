package com.thaiboxing.thaiboxingapi.service;

import com.thaiboxing.thaiboxingapi.entity.Country;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class FileHandlerService {

    public void appendCountryToFile(Country country) {
        String fileName = "country.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(country.countryCode());
            writer.newLine();
            writer.write(country.countryName());
            writer.newLine();
            writer.write(Long.toString(country.countryPopulation()));
            writer.newLine();
            writer.write(Long.toString(country.countrySurfaceArea()));
            writer.newLine();
            writer.write("-----");
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Error writing country to file: " + e.getMessage(), e);
        }
    }
}