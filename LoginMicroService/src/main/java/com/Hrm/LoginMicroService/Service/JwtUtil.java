package com.Hrm.LoginMicroService.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.Hrm.LoginMicroService.Entity.TokenEntity;
import com.Hrm.LoginMicroService.repo.TokenRepository;

import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.security.Key;

@Component
public class JwtUtil {

	private int expiration = 86400; // Token expiration time in seconds (e.g., 24 hours)

	private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

	@Autowired
	private TokenRepository tokenRepository; // Your repository to access tokens
	// Generate JWT token and store in database
	public String generateToken(UserDetails userDetails) {
		// Check if token already exists in database
		TokenEntity existingToken = tokenRepository.findByUsername(userDetails.getUsername());
		System.out.println("genrating token method");
		if (existingToken != null && isValid(existingToken)) {
			System.out.println("not generating token method as it si not expired yet");
			return existingToken.getToken(); // Return existing token if valid
		}
		System.out.println("genrating new method");

		// Generate new token
		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + expiration * 1000);

		String newToken = Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(now)
				.setExpiration(expiryDate).signWith(key, SignatureAlgorithm.HS512).compact();

		// Save new token in database
		if (existingToken != null) {
			existingToken.setToken(newToken);
			existingToken.setExpiryDate(expiryDate);
		} else {
			existingToken = new TokenEntity(userDetails.getUsername(), newToken, expiryDate);
		}
		System.out.println("saving new  token in db");

		tokenRepository.save(existingToken);
		System.out.println("saved  token succesfull");

		return newToken;
	}

	// Check if the token is still valid
	private boolean isValid(TokenEntity token) {
		return token.getExpiryDate() != null && token.getExpiryDate().after(new Date());
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {

		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
}

/*
 * public String generateToken(UserDetails userDetails) { Map<String, Object>
 * claims = new HashMap<>(); return doGenerateToken(claims,
 * userDetails.getUsername()); }
 * 
 * private String doGenerateToken(Map<String, Object> claims, String subject) {
 * return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new
 * Date(System.currentTimeMillis())) .setExpiration(new
 * Date(System.currentTimeMillis() + 86400000))
 * .signWith(SignatureAlgorithm.HS512, "testing").compact(); }
 */

// Generate JWT token
/*
 * public String generateToken(UserDetails userDetails) {
 * 
 * Date now = new Date(); Date expiryDate = new Date(now.getTime() + expiration
 * * 1000); Map<String, Object> claims = new HashMap<>(); return
 * Jwts.builder().setSubject(userDetails.getUsername()).setClaims(claims).
 * setIssuedAt(now) .setExpiration(expiryDate).signWith(key,
 * SignatureAlgorithm.HS512).compact(); }
 * 
 * 
 */
