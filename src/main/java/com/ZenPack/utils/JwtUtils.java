package com.ZenPack.utils;

import com.ZenPack.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.nio.file.AccessDeniedException;
import java.util.Date;

@Component
public class JwtUtils {
    private static String secret="Zenfra";
    private static long expiryDuration = 60 * 60;

    public String generateJwt(User user) {
        long milliTime = System.currentTimeMillis();
        long expiryTime = milliTime + expiryDuration * 1000;

        Date issuedAt = new Date();
        Date expiryAt = new Date(expiryTime);

        //claims
        Claims claims= Jwts.claims()
                .setIssuer(user.getId().toString())
                .setIssuedAt(issuedAt)
                .setExpiration(expiryAt);

        claims.put("type", user.getUserType());
        claims.put("name", user.getUserName());
        claims.put("emailId", user.getEmailId());

        return  Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    public Claims verify(String authorization) throws Exception {

        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
            return claims;
        } catch(Exception e) {
            throw new AccessDeniedException("Access Denied");
        }

    }

}
