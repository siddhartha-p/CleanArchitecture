package com.clean.architecture.Utils;

import com.clean.architecture.usecase.auth.AuthenticateUseCaseRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.micronaut.context.annotation.Value;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

public class JwtUtils {


    private JwtUtils() {}

    public static String secret = "GkTjLJqkGxWYxTmI2U9mN7gczBL9G6tsU4ktvY7gXHY=";

    public static String generate(AuthenticateUseCaseRequest request) {

        var token = Jwts.builder()
                .claims(Map.of("name", request.username()))
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plusSeconds(600)))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();


        return token;
    }

    public static Boolean isValidToken(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }

        try {
            SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

            Jws<Claims> jws = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);

            Claims claims = jws.getPayload();
            return isTokenExpired(claims.getExpiration());
        } catch (JwtException ex) {
            System.out.println("Exception on parsing token");
            return false;
        }
    }

    private static boolean isTokenExpired(Date expirationDate) {
        return Date.from(Instant.now()).before(expirationDate);
    }
}
