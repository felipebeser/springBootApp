package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
