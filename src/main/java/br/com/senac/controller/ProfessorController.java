package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.com.senac.model.Professor;
import br.com.senac.service.ProfessorService;

@RequestMapping("professor")
@Controller
public class ProfessorController {
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/listarProfessores")
	public ModelAndView listarTodosProfessores() {
		ModelAndView mv = new ModelAndView("professor/paginaListaProfessor");
		mv.addObject("professores", this.professorService.buscarTodosProfessores());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarProfessor() {
		ModelAndView mv = new ModelAndView("professor/cadastraProfessor");
		mv.addObject("professor", new Professor());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarProfessor( Professor professor) {
		professorService.salvar(professor);
		return listarTodosProfessores(); 
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirProfessor (@PathVariable ("id") Integer id) {
		professorService.excluir(id);
		return listarTodosProfessores();
	}
	
}
