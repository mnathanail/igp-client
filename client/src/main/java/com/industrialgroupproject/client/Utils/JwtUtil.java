package com.industrialgroupproject.client.Utils;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

    private final String SECRET_KEY;

    @Autowired
    public JwtUtil(@Value("${secret.key}") String SECRET_KEY) {
    	 this.SECRET_KEY = SECRET_KEY;
    }

    public String extractUsername(String token) {
        return this.extractClaim(token, Claims::getSubject);
    }

    public String extractRole(String token) {
        final Claims claims = this.extractAllClaims(token);

		return claims.get("scopes").toString();
    }

    public Date extractExpiration(String token) {
        return this.extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = this.extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(this.SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return this.extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) {
        final Map<String, Object> claims = new HashMap<>();
   	 //Claims claims = Jwts.claims().setSubject(userContext.getUsername());
     claims.put("scopes", userDetails.getAuthorities().stream().map(s -> s.getAuthority().toString()).collect(Collectors.toList()));
        return this.createToken(claims, userDetails.getUsername(), userDetails.getAuthorities());
    }

    private String createToken(Map<String, Object> claims, String subject, Collection<? extends GrantedAuthority> collection) {

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 10)))
                .signWith(SignatureAlgorithm.HS256, this.SECRET_KEY).compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = this.extractUsername(token);
        final String role = this.extractRole(token);
        final boolean a = (role.equals(userDetails.getAuthorities()));
        return (username.equals(userDetails.getUsername()) && !this.isTokenExpired(token));
    }
}
