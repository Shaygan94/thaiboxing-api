package com.thaiboxing.thaiboxingapi.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class SessionService {
    private Map<String, Map<String, Object>> sessions = new HashMap<>();

    public String createSession() {
        String sessionId = UUID.randomUUID().toString();
        Map<String, Object> sessionData = new HashMap<>();
        sessionData.put("step", "COUNTRY_CODE");
        sessions.put(sessionId, sessionData);
        return sessionId;
    }

    public Map<String, Object> getSession(String sessionId) {
        return sessions.get(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }
}
