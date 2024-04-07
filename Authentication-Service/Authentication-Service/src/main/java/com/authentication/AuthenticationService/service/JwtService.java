package com.authentication.AuthenticationService.service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {
    public static final String SECRET = "774109d7a4bcfa8a8e5fcce1538313061a44df5f88e6289155f82cddd0ba208204a442d8d2f71cdb03f79831bf6c0f13ddec1f7897ba3c200329eb70ba556fe8214a4418adfebb9396c41c4df1869a93b896534887d9f95987de500cc184a5c2442de4b0f76d3095410d6065b828cd84c68cd75ad171b64bd16b65a53dd418247ef6943541d14907d4f175139b922dcf308ad9ad48048d417a72bce09bdab6539e1b493ef2e99996daa5f2cbfe86c9cf02e5e5fc91adb64424b2669b9b0ab87e0a91f6b265cbfc1a423b3a6bc3e23c8e65cb17f2937b81d86599378d7390189feb64dcad4740d155a342697384e926b94c5545bf6c00589ab624dcad8d8de1a1";

//Validate token method
    public void validateToken(final String token){
       Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }



    // Below Method generates the tocken
     public String generateToken(String userName){
         Map<String,Object> claims = new HashMap<>();
         return createToken(claims, userName);
     }

     private String createToken(Map<String,Object> claims,String userName){
         return Jwts.builder()
                 .setClaims(claims) //Claims is header , payloads and signature
                 .setSubject(userName)
                 .setIssuedAt(new Date(System.currentTimeMillis()))
                 .setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
                 .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();

     }
     private Key getSignKey(){
         byte[] keyBytes =  Decoders.BASE64.decode(SECRET);
         return Keys.hmacShaKeyFor(keyBytes);
     }

}
