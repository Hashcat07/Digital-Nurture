package com.cognizant.spring_learn.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@RestController
public class AuthenticationController {

    private static final SecretKey KEY = Keys.hmacShaKeyFor("spring-learn-secret-key-secret-key-1234567890".getBytes(StandardCharsets.UTF_8));

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        String user = getUser(authHeader);
        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        return map;
    }

    private String getUser(String authHeader) {

        String encodedCredentials = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String credentials = new String(decodedBytes, StandardCharsets.UTF_8);

        return credentials.substring(0, credentials.indexOf(":"));
    }

    private String generateJwt(String user) {

        return Jwts.builder().subject(user).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis() + 1200000)).signWith(KEY).compact();
    }
}