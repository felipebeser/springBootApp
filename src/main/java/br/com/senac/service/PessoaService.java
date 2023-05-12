package br.com.senac.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.senac.model.Pessoa;
import br.com.senac.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepo;

	public BCryptPasswordEncoder encoder;
	
	public PessoaService(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}
	
	public Pessoa create(Pessoa pessoa) {
		pessoa.setPassword(encoder.encode(pessoa.getPassword()));
		List<String> perfil = new ArrayList<String>();
		perfil.add("USER");
		pessoa.setPerfil(perfil);
		return pessoaRepo.save(pessoa);
	}
}
