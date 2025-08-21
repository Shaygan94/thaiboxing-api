package com.thaiboxing.thaiboxingapi.controller;

import com.thaiboxing.thaiboxingapi.entity.Country;
import com.thaiboxing.thaiboxingapi.service.CountryService;
import com.thaiboxing.thaiboxingapi.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private CountryService countryService;

    @PostMapping("/countries/start")
    public ResponseEntity<Map<String, String>> startCountryCreation() {
        String sessionId = sessionService.createSession();

        Map<String, String> response = new HashMap<>();
        response.put("sessionId", sessionId);
        response.put("message", "Enter country code (3 uppercase letters):");

        return ResponseEntity.ok(response);
    }

    @PostMapping("/countries/continue/{sessionId}")
    public ResponseEntity<Map<String, String>> continueCountryCreation(
            @PathVariable String sessionId,
            @RequestBody Map<String, String> request) {

        Map<String, Object> sessionData = sessionService.getSession(sessionId);
        if (sessionData == null) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Session not found");
            return ResponseEntity.badRequest().body(error);
        }

        String currentStep = (String) sessionData.get("step");
        String value = request.get("value");
        Map<String, String> response = new HashMap<>();

        try {
            switch (currentStep) {
                case "COUNTRY_CODE" -> {
                    sessionData.put("countryCode", value);
                    sessionData.put("step", "COUNTRY_NAME");
                    response.put("message", "Enter country name:");
                }
                case "COUNTRY_NAME" -> {
                    sessionData.put("countryName", value);
                    sessionData.put("step", "COUNTRY_POPULATION");
                    response.put("message", "Enter country population (number):");
                }
                case "COUNTRY_POPULATION" -> {
                    sessionData.put("countryPopulation", Long.parseLong(value));
                    sessionData.put("step", "COUNTRY_SURFACE_AREA");
                    response.put("message", "Enter country surface area (number):");
                }
                case "COUNTRY_SURFACE_AREA" -> {
                    sessionData.put("countrySurfaceArea", Long.parseLong(value));

                    // Bruk CountryService
                    Country savedCountry = countryService.createCountry(
                            (String) sessionData.get("countryCode"),
                            (String) sessionData.get("countryName"),
                            (Long) sessionData.get("countryPopulation"),
                            (Long) sessionData.get("countrySurfaceArea")
                    );

                    // Fjern session
                    sessionService.removeSession(sessionId);

                    response.put("message", "Country created successfully!");
                    response.put("countryCode", savedCountry.countryCode());
                }
            }
        } catch (Exception e) {
            response.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }

        return ResponseEntity.ok(response);
    }
}