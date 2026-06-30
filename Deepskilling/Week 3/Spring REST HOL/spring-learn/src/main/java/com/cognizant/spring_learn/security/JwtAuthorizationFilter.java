package com.cognizant.spring_learn.security;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.crypto.SecretKey;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private static final SecretKey KEY = Keys.hmacShaKeyFor("spring-learn-secret-key-secret-key-1234567890".getBytes(StandardCharsets.UTF_8));

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        String header = req.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {

        String token = request.getHeader("Authorization");

        if (token != null) {
            try {
                Jws<Claims> jws = Jwts.parser().verifyWith(KEY).build().parseSignedClaims(token.replace("Bearer ", ""));
                String user = jws.getPayload().getSubject();
                if (user != null) {
                    return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
                }

            } catch (JwtException ex) {
                return null;
            }
        }
        return null;
    }
}