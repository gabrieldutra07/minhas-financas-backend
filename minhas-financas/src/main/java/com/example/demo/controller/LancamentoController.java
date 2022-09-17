package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LancamentoDTO;
import com.example.demo.service.LancamentoService;

@RestController
@RequestMapping("/api/lancamentos")
public class LancamentoController {

	private LancamentoService service;
	
	public LancamentoController(LancamentoService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody LancamentoDTO dto) {
		
		return null;
		
	}
	
}
