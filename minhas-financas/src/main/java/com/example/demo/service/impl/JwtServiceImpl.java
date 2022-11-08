package com.example.demo.service.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import com.example.demo.model.entity.Usuario;
import com.example.demo.service.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtServiceImpl implements JwtService {

	@Value("${jwt.expiracao}")
	private String expiracao;

	@Value("${jwt.chave-assinatura}")
	private String chaveAssinatura;

	@Override
	public String gerarToken(Usuario usuario) {
		long exp = Long.valueOf(expiracao);
		LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(exp);
		Instant instant = dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant();
		Date data = Date.from(instant);

		String horaExpiracaoToken = dataHoraExpiracao.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
		
		String token = Jwts.builder().setExpiration(data)
				.setSubject(usuario.getEmail())
				.claim("nome", usuario.getNome())
				.claim("horaExpiracao", horaExpiracaoToken)
				.signWith(SignatureAlgorithm.HS512, chaveAssinatura).compact();
		
		return token;
	}

	@Override
	public Claims obterClaims(String token) throws ExpiredJwtException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTokenValido(String token) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String obterLoginUsuario(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
