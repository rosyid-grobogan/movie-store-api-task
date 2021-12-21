package com.rosyidgrobogan.moviestoreapitask.helpers.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtility
        implements Serializable
{
    private static final long serialVersionUID = 1L;
    public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    @Value("${application.jwt.secretKey}")
    private String secretKey;
    SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256); //or HS384 or HS512
    String base64Key = Encoders.BASE64.encode(key.getEncoded());

    // retrieve username from jwt token
    public String getUsernameFromToken(String token)
    {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getEpirationDateFromToken(String token)
    {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver)
    {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token)
    {
        return Jwts
                .parser()
                .setSigningKey(key)
                .parseClaimsJws(token).getBody();
    }

    private boolean isTokenExpired(String token)
    {
        final Date expiration = getEpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(UserDetails userDetails)
    {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    private String doGenerateToken(Map<String, Object> claims, String subject)
    {
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(key)
                .compact();
    }

    public boolean validateToken(String token, UserDetails userDetails)
    {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
