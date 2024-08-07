package com.tumtech.hotelmanagementapp.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class JwtUtil {
    @Value("${SHA_KEY}")
    private String SHA_KEY;

    //1st- For Creating JWT (GetKey, ExpirationDate)

    private final Supplier<SecretKeySpec> getKey = () -> {
        Key key = Keys.hmacShaKeyFor(SHA_KEY
                .getBytes(StandardCharsets.UTF_8));
        return new SecretKeySpec(key.getEncoded(), key.getAlgorithm());
    };

    private final Supplier<Date> expirationTime = () ->
            Date.from(LocalDateTime.now()
                    .plusHours(2)
                    .atZone(ZoneId.systemDefault())
                    .toInstant());

    public Function<UserDetails, String> createJwt = (userDetails) -> {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .signWith(getKey.get())
                .claims(claims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(expirationTime.get())
                .compact();
    };

    //    //2nd - extract username and expirationDate from token - //before that, extract claim
    public <T> T extractClaims(String token, Function<Claims, T> claimResolver) {
        final Claims claims = Jwts.parser().verifyWith(getKey.get()).build().parseSignedClaims(token).
                getPayload();
        return claimResolver.apply(claims);
    }

    public Function<String, String> extractUsername = (token) -> extractClaims(token, Claims::getSubject);
    public Function<String, Date> extractExpirationTime = (token) -> extractClaims(token, Claims::getExpiration);
    //    //3rd -  check if token isValid and isExpired
//
    public Function<String, Boolean> isTokenExpired = (token) ->
            extractExpirationTime.apply(token).after(new Date(System.currentTimeMillis()));

    public BiFunction<String, String, Boolean> isTokenValid = (token, username) ->
            isTokenExpired.apply(token) && Objects.equals(extractUsername.apply(token), username);

}
