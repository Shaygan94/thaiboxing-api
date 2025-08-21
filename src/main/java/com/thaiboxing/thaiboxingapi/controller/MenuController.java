package com.thaiboxing.thaiboxingapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @GetMapping("/")
    public Map<String, String> showMenu() {
        Map<String, String> menu = new HashMap<>();
        menu.put("1", "Show all fighters in a country");
        menu.put("2", "Show all fighters in a club");
        menu.put("3", "Show all fighters in a city");
        menu.put("4", "Show cities where clubs are located");
        menu.put("5", "not implemented yet");
        menu.put("6", "not implemented yet");
        menu.put("7", "not implemented yet");
        menu.put("8", "not implemented yet");
        menu.put("9", "not implemented yet");
        menu.put("10", "Admin menu");
        menu.put("11", "Exit");
        return menu;
    }

    //@Value("${admin.password}")
    //private String adminPassword;

   /* @PostMapping("/10")
    public ResponseEntity<String> accessAdmin(@RequestBody Map<String, String> request ) {
        String password = request.get("password");

        if (adminPassword.equals(password)) {
            return ResponseEntity.ok("Access granted! Welcome to Admin menu");
        } else {
            return ResponseEntity.status(401).body("Access denied! Incorrect password.");
        }
    }

    */
}
