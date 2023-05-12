package br.com.senac.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Avaliacao {
	
	@EmbeddedId
	private AlunoCurso alunocurso;

	private String conceito;

	public AlunoCurso getAlunocurso() {
		return alunocurso;
	}

	public void setAlunocurso(AlunoCurso alunocurso) {
		this.alunocurso = alunocurso;
	}

	public String getConceito() {
		return conceito;
	}

	public void setConceito(String conceito) {
		this.conceito = conceito;
	}

	
}
