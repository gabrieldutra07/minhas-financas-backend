package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UsuarioDTO;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	
	
	public ResponseEntity salvar(@RequestBody UsuarioDTO dto) {
		return null;
	}

}
