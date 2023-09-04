package com.commerce.commerce.Security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.commerce.commerce.Exceptions.NotFoundException;

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
      try{    System.out.println("extracting all claims");
        return Jwts
                .parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
            }catch(Exception e){
             throw new NotFoundException("Invalid token");
            }
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(userDetails, new HashMap<>());
    }

    public String generateToken(UserDetails userDetails, Map<String, Object> claims) {
        return Jwts
                .builder()
                .setClaims(claims) 
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24)))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();

    }

    public boolean isTokenValid(String token,UserDetails userDetails){
        String username=extractUsername(token);
        System.out.println("gotten username is "+username);
        return (username.equals(userDetails.getUsername())&&!isTokenExpired(token));

    }

    private boolean isTokenExpired(String token) {
          System.out.println("Token is this"+extractExpiration(token));
        return extractExpiration(token).before(new Date(System.currentTimeMillis()));
    }

    private Date extractExpiration(String token) {
      
        return extractSingleClaim(token, Claims::getExpiration);
    }

}
