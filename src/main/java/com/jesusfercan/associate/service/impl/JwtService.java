package com.jesusfercan.associate.service.impl;

import com.jesusfercan.associate.entity.User;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    @Value("${security.jwt.expiration-minutes}")
    private long EXPIRATION_MINUTES;

    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY;

    public String generateToken(User user, Map<String,Object> extraClaims){

        Date now = new Date(System.currentTimeMillis());
        Date expiration = new Date(System.currentTimeMillis() + (EXPIRATION_MINUTES*60*1000));

        return  Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getLogin())
                .setIssuedAt(now)
                .setExpiration(expiration)
                .setHeaderParam(Header.TYPE,Header.JWT_TYPE)
                .signWith(generateKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key generateKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

}
