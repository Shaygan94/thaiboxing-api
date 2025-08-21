/*package com.thaiboxing.thaiboxingapi.service;

import com.thaiboxing.thaiboxingapi.entity.Country;
import com.thaiboxing.thaiboxingapi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private FileHandlerService fileHandlerService;

    public Country createCountry(String code, String name, Long population, Long surfaceArea) {
        // Validering
        if (!isValidCountryCode(code)) {
            throw new IllegalArgumentException("Invalid country code - must be 3 uppercase letters");
        }

        // Sjekk om landet eksisterer
        if (countryRepository.existsById(code)) {
            throw new IllegalArgumentException("Country already exists with code: " + code);
        }

        Country country = new Country(code, name, population, surfaceArea);

        // Lagre til database
        Country saved = countryRepository.save(country);

        // Lagre til fil (som i original)
        fileHandlerService.appendCountryToFile(saved);

        return saved;
    }

    private boolean isValidCountryCode(String code) {
        return code != null && code.matches("[A-Z]{3}");
    }
}

 */