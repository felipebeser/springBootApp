package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.model.Professor;
import br.com.senac.repository.ProfessorRepository;

@Service
public class ProfessorService {
	@Autowired
	private ProfessorRepository professorRepository;
	
	public List<Professor> buscarTodosProfessores(){
		return professorRepository.findAll();
	}
	public Professor salvar(Professor professor) {
		return professorRepository.save(professor);
	}
	
	public Professor atualizar(Professor professor) {
		return professorRepository.save(professor);
	}
	
	public void excluir(Integer id) {
		professorRepository.deleteById(id);
	}
}
