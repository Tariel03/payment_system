package com.example.dd.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("{books.jwtSecret}")
    String secret;
    //    @Value("{books.jwtExpirationMs")
    int jwtExpirationMs = 100000000;
    //    @Value("{books.jwtRefreshExpirationMs")
    int jwtRefreshExpirationMs = 1000000000;

    public String generateAccessToken(String username) {
        Date expirationDate = Date.from(ZonedDateTime.now().toInstant().plusMillis(jwtExpirationMs));
        return JWT.create()
                .withSubject("User details")
                .withClaim("username", username)
                .withIssuedAt(new Date())
                .withIssuer("Tariel")
                .withExpiresAt(expirationDate)
                .sign(Algorithm.HMAC256(secret));
    }
    public String generateRefreshToken(String username) {
        Date expirationDate = Date.from(ZonedDateTime.now().toInstant().plusMillis(jwtRefreshExpirationMs));
        return JWT.create()
                .withSubject("User details")
                .withClaim("username", username)
                .withIssuedAt(new Date())
                .withIssuer("Tariel")
                .withExpiresAt(expirationDate)
                .sign(Algorithm.HMAC256(secret));
    }


    public String validateTokenAndRetrieveClaim(String token) throws JWTVerificationException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withSubject("User details")
                .withIssuer("Tariel")
                .build();

        DecodedJWT jwt = verifier.verify(token);
        jwt.getSubject();
        return jwt.getClaim("username").asString();
    }

    public DecodedJWT decodeJWT(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(token);
    }

    public String extractUsername(String token) {
        DecodedJWT decodedJWT = decodeJWT(token);
        return decodedJWT.getSubject();
    }


}