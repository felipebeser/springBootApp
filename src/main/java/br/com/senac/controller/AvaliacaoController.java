package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.senac.model.Avaliacao;
import br.com.senac.service.AvaliacaoService;

@RequestMapping("avaliacao")
@Controller
public class AvaliacaoController {

	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@GetMapping("/listarAvaliacoes")
	public void buscarTodasAvaliacoes() {
		
	}
	
	@GetMapping("/cadastrar")
	public void cadastrarAvaliacao() {
		
	}
	
	@PostMapping("/salvar")
	public void salvarAvaliacao(Avaliacao avaliacao) {
		avaliacaoService.salvar(avaliacao);
		buscarTodasAvaliacoes();
	}
}
