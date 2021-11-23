package com.desarrollo.barberia.security;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.naming.AuthenticationException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.desarrollo.barberia.exepciones.SeguridadException;
import com.desarrollo.barberia.model.Admin;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private static final String HEADER_AUTHORIZACION_KEY = null;
	private static final String TOKEN_BEARER_PREFIX = null;
	private static final String SUPER_SECRET_KEY = null;
	private static final long TOKEN_EXPIRATION_TIME = 0;
	private static final String ISSUER_INFO = null;
	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public org.springframework.security.core.Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		try {
			Admin credenciales = new ObjectMapper().readValue(request.getInputStream(), Admin.class);

			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					credenciales.getIdusuario(), credenciales.getContrausuario(), new ArrayList<>()));
		} catch (IOException e) {
			throw new SeguridadException("Error en el proceso de autentición del usuario.", e);
		}
	}

	protected void successfulAuthentication(HttpServletRequest request, 
			HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		Map<String, Object> claims = new HashMap<>();
		claims.put("entero", 1);
		claims.put("string", "texto");
		
		String token = Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(new Date(0))
				.setIssuer(ISSUER_INFO)
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY)
				.compact();
		
		response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + "aa " + token);
	}


}
