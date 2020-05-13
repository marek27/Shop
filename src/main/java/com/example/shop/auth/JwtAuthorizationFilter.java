package com.example.shop.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader("Authorization");

        if(token == null || !token.startsWith("Bearer")){
            SecurityContextHolder.getContext()
                    .setAuthentication(null);
            chain.doFilter(request,response);
            return;
        }

        Claims claims = Jwts.parser()
                .setSigningKey("root")
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody();

        String authorities = claims.get("authorities", String.class);

        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();

        if(authorities != null && !authorities.isEmpty()){
            simpleGrantedAuthorities = Arrays.stream(authorities.split(","))
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        }

        String email = claims.getSubject();

        if(email != null){
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(email, null , simpleGrantedAuthorities));
            chain.doFilter(request,response);
        }else{
            SecurityContextHolder.getContext()
                    .setAuthentication(null);
            response.setStatus(401);
        }



    }
}
