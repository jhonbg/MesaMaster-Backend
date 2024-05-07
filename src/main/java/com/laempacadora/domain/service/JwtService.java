package com.laempacadora.domain.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY="6B6EFFAB9934C316F412C3CD1CEED6FF3E7A1368A52B535A7D445FD6EF";

    public String getToker(UserDetails empleado)
    {
        return getToker(new HashMap<>(), empleado);
    }

    private String getToker(Map<String, Objects> extraClaims, UserDetails empleado)
    {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(empleado.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey()
    {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getUsernameFromToken(String token)
    {
        return getClaim(token, Claims::getSubject);
    }

    public boolean isTokenvalid(String token, UserDetails userDetails)
    {
        try {
            final String idEmpleado = getUsernameFromToken(token);
            return (idEmpleado.equals(userDetails.getUsername()) && !isTokenExpired(token));
        } catch (ExpiredJwtException e) {
            return false;
        }
    }


    private Claims getAllClaims(String token)
    {
        return Jwts
                .parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver)
    {
        final Claims claims= getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Date getExpiration(String token)
    {
        return getClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token)
    {
        return getExpiration(token).before(new Date());
    }
}
