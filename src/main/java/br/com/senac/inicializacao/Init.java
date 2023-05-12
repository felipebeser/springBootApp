package br.com.senac.inicializacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.domain.enums.Perfil;
import br.com.senac.model.Aluno;
import br.com.senac.model.Curso;
import br.com.senac.model.Pessoa;
import br.com.senac.model.Professor;
import br.com.senac.service.AlunoService;
import br.com.senac.service.CursoService;
import br.com.senac.service.PessoaService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	AlunoService alunoService;
	@Autowired
	CursoService cursoService;
	@Autowired
	PessoaService pessoaService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		alunoService.salvar(aluno1);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Arthur");
		alunoService.salvar(aluno2);
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Jose");
		alunoService.salvar(aluno3);
		
		List<Aluno> alunos = alunoService.buscarTodosAlunos();
		
		for(Aluno aluno : alunos) {
			System.out.println(aluno.getNome());
		}
		
		Professor professor = new Professor();
		professor.setNome("Estruc");
		Curso curso1 = new Curso();
		curso1.setNome("Java");
		cursoService.salvar(curso1);
		Curso curso2 = new Curso();
		curso2.setNome("Python");	
		cursoService.salvar(curso2);
		
		Pessoa p1 = new Pessoa();
		p1.setNome("Felipe");
		p1.setPassword("123");
		
		Pessoa p2 = new Pessoa();
		p2.setNome("Floco");
		p2.setPassword("123");
		List<Perfil> perfil = new ArrayList<>();
		perfil.add(Perfil.USER);
		pessoaService.create(p1);
		pessoaService.create(p2);
		
	}
}
