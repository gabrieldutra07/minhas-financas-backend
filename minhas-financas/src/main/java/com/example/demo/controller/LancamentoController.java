package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LancamentoDTO;
import com.example.demo.exception.RegraNegocioException;
import com.example.demo.model.entity.Lancamento;
import com.example.demo.model.entity.Usuario;
import com.example.demo.model.enums.StatusLancamento;
import com.example.demo.model.enums.TipoLancamento;
import com.example.demo.service.LancamentoService;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/api/lancamentos")
public class LancamentoController {

	private LancamentoService service;
	private UsuarioService usuarioService;
	
	public LancamentoController(LancamentoService service, UsuarioService usuarioService) {
		this.service = service;
		this.usuarioService = usuarioService;
	}
	
	@PostMapping
	public ResponseEntity salvar(@RequestBody LancamentoDTO dto) {
		
		return null;
		
	}
	
	private Lancamento converter(LancamentoDTO dto) {
		Lancamento lancamento = new Lancamento();
		lancamento.setId(dto.getId());
		lancamento.setDescricao(dto.getDescricao());
		lancamento.setAno(dto.getAno());
		lancamento.setMes(dto.getMes());
		lancamento.setValor(dto.getValor());
		
		Usuario usuario = usuarioService.obterPorId(dto.getUsuario())
		.orElseThrow( () -> new RegraNegocioException("Usuário não encontrado para o ID informado!"));
		
		lancamento.setUsuario(usuario);
		lancamento.setTipo(TipoLancamento.valueOf(dto.getTipo()));
		lancamento.setStatus(StatusLancamento.valueOf(dto.getStatus()));
		
		return lancamento;
	}
	
}
