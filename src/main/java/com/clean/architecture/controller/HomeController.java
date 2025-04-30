package com.clean.architecture.controller;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.http.annotation.Header;

import javax.crypto.SecretKey;
import java.security.Key;
import java.security.Principal;
import java.time.Instant;
import java.util.Date;
import java.util.Map;


//@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("jwt")
public class HomeController {

    final String secret = "GkTjLJqkGxWYxTmI2U9mN7gczBL9G6tsU4ktvY7gXHY=";

    @Produces(MediaType.TEXT_PLAIN)
    @Get("/get")
    public String index(Principal principal) {
        System.out.println("this code is working");
        return principal.getName();
    }

    @Get("/post")
    public String post() {
        return prepareToken();
    }

    private String prepareToken() {

        var token = Jwts.builder()
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .claims(Map.of("name","siddhartha"))
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plusSeconds(300)))
                .compact();

        return token;
    }

    @Post("check_token")
    public String checkAuthorization(@Body Object obj, @Header("Authorization") String authorization){
        isValidToken(authorization);
        return "this is test";
    }

    public boolean isValidToken(String token){
        if(token == null || token.isEmpty()){
            return false;
        }

        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

        Jws<Claims> jws = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);

        Claims claims = jws.getPayload();

        System.out.println(claims.get("name"));

        return true;
    }

}
