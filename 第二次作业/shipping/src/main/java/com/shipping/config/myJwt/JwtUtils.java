package com.shipping.config.myJwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private static final String SECRET_KEY = "cuAihCz53DZRjZwbsGcZJ2Ai6At+T142uphtJMsk7iQ=";

    public static String generateToken(String username) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + 3600000); // 1 hour

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
//    public static void main(String[] args) {
//
//        String token = JwtUtils.generateToken("12345");
//                System.out.println(token);
//                String username = JwtUtils.getUsernameFromToken(token);
//        System.out.println(username);
//    }

}



