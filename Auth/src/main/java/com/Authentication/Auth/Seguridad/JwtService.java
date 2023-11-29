package com.Authentication.Auth.Seguridad;

import com.Authentication.Auth.DTO.RequestDto;
import com.Authentication.Auth.Modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtService {

	public static String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

	@Autowired
	RouteValidator routeValidator;

	@PostConstruct
	protected void init() {
		SECRET = Base64.getEncoder().encodeToString(SECRET.getBytes());
	}

	public String createToken(Usuario authUser) {
		Map<String, Object> claims = new HashMap<>();
		claims = Jwts.claims().setSubject(authUser.getEmail());
		claims.put("id", authUser.getId());
		claims.put("rol", authUser.getRol());
		claims.put("nombre", authUser.getNombre());
		Date now = new Date();
		Date exp = new Date(now.getTime() + 3600000);
		return Jwts.builder()
		.setClaims(claims)
		.setIssuedAt(now)
		.setExpiration(exp)
		.signWith(SignatureAlgorithm.HS256, SECRET)
		.compact();
	}

	public boolean validate(String token, RequestDto dto) {
		try {
			Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
		} catch (Exception e) {
			return false;
		}
		if (!isAdmin(token) && routeValidator.isAdminPath(dto)) {
			return false;
		}
		return true;
	}

	public String getEmailFromToken(String token) {
		try {
			return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
		} catch (Exception e) {
			return "bad token";
		}
	}

	private boolean isAdmin(String token) {
		return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().get("rol").equals("admin");
	}
}
