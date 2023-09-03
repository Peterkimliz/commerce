package com.commerce.commerce.Security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

    private final String SECRET = "eyJzdWIiOiJwZXRlcmtpcm9uamk4QGdtYWlsLmNvbSIsImV4cCI6MTY4MjY4MDAwOCwiaWF0IjoxNjgyNjc4NTY4fQ";

    public String extractUsername(String token) {
        return extractSingleClaim(token, Claims::getSubject);
    }

    private <T> T extractSingleClaim(String token, Function<Claims, T> claimResolver) {
        Claims claims = extractAllClaims(token);
        System.out.println("claims are"+claims);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(SECRET)
                .parseClaimsJwt(token)
                .getBody();
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(userDetails, new HashMap<>());
    }

    public String generateToken(UserDetails userDetails, Map<String, Object> claims) {
        return Jwts
                .builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public boolean isTokenValid(String token,UserDetails userDetails){
        String username=extractUsername(token);
        return (username.equals(userDetails.getUsername())&&!isTokenExpired(token));

    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date(System.currentTimeMillis()));
    }

    private Date extractExpiration(String token) {
        return extractSingleClaim(token, Claims::getExpiration);
    }

}
