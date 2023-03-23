package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.senac.model.Turma;
import br.com.senac.service.TurmaService;

@RequestMapping("turma")
@Controller
public class TurmaController {
	@Autowired
	private TurmaService turmaService;
	
	@GetMapping("/listarTurmas")
	public void buscarTodasTurmas() {
		
	}
	
	@GetMapping("/cadastrar")
	public void cadastrarTurma() {
		
	}
	
	@PostMapping("/salvar")
	public void salvar(Turma turma) {
		turmaService.salvar(turma);
		buscarTodasTurmas();
	}
}
