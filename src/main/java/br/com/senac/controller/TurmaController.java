package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.model.Turma;
import br.com.senac.service.CursoService;
import br.com.senac.service.TurmaService;

@RequestMapping("turma")
@Controller
public class TurmaController {
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/listarTurmas")
	public ModelAndView buscarTodasTurmas() {
		ModelAndView mv = new ModelAndView("turma/paginaListaTurmas");
		mv.addObject("turmas", turmaService.buscarTodasTurmas());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarTurma() {
		ModelAndView mv = new ModelAndView("turma/cadastraTurma");
		mv.addObject("turma", new Turma());
		mv.addObject("listaCursos", cursoService.buscarTodosCursos());
		return mv;
	}
	
	@PostMapping("/salvar")
	public void salvar(Turma turma) {
		turmaService.salvar(turma);
		buscarTodasTurmas();
	}
}
