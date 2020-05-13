 package com.example.shop.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class JwtAuthenticateFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtAuthenticateFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getParameter("email"),request.getParameter("password"), Collections.emptyList()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        Map<String, Object> claims = new HashMap<>();
        String authorities = authResult.getAuthorities()
                .stream()
                .map(role -> ((GrantedAuthority) role).getAuthority())
                .collect(Collectors.joining(","));
        claims.put("authorities", authorities);

        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(((UserDetails) authResult.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS512, "root")
                .compact();

        response.setHeader("Authoriztion", "Bearer "+ token);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        Map<String, String> map = new HashMap<>();
        map.put("token", token);
        new ObjectMapper().writeValue(response.getWriter(), map);



    }

}
