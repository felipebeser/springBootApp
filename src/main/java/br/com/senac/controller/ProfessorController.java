package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.senac.model.Professor;
import br.com.senac.service.ProfessorService;

@RequestMapping("professor")
@Controller
public class ProfessorController {
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/listarProfessores")
	public void listarTodosProfessores() {
		
	}
	
	@GetMapping("/cadastrar")
	public void cadastrarProfessor() {
		
	}
	
	@PostMapping("/salvar")
	public void salvarProfessor( Professor professor) {
		professorService.salvar(professor);
		listarTodosProfessores(); 
	}
	
}
