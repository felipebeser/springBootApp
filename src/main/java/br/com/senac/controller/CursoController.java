package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.senac.model.Curso;
import br.com.senac.service.CursoService;

@Controller
@RequestMapping("curso")
public class CursoController {
	@Autowired
	private CursoService cursoService;

	@GetMapping("/listarCursos")	
	public void buscarTodosCursos() {
		
	}
	
	@GetMapping("/cadastrar")
	public void cadastrarCurso() {
		
	}
	
	@PostMapping("/salvar")
	public void salvarCurso(Curso curso) {
		cursoService.salvar(curso);
		buscarTodosCursos();
	}
}
