package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.model.Avaliacao;
import br.com.senac.service.AlunoService;
import br.com.senac.service.AvaliacaoService;
import br.com.senac.service.CursoService;

@RequestMapping("avaliacao")
@Controller
public class AvaliacaoController {

	@Autowired
	private AvaliacaoService avaliacaoService;
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/listarAvaliacoes")
	public ModelAndView buscarTodasAvaliacoes() {
		ModelAndView mv = new ModelAndView("avaliacao/paginaListaAvaliacao");
		mv.addObject("avaliacoes", avaliacaoService.buscarTodasAvaliacoes());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastrarAvaliacao() {
		ModelAndView mv = new ModelAndView("avaliacao/cadastraAvaliacao");
		mv.addObject("avaliacao", new Avaliacao());
		mv.addObject("alunos", alunoService.buscarTodosAlunos());
		mv.addObject("cursos", cursoService.buscarTodosCursos());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarAvaliacao(Avaliacao avaliacao) {
		avaliacao.getAlunocurso().setAluno(alunoService.buscarPorId(avaliacao.getAlunocurso().getAluno().getId()));
		avaliacao.getAlunocurso().setCurso(cursoService.buscarPorId(avaliacao.getAlunocurso().getCurso().getId()));
		avaliacaoService.salvar(avaliacao);
		return buscarTodasAvaliacoes();
	}
}
