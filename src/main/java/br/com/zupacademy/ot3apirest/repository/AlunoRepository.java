package br.com.zupacademy.ot3apirest.repository;

import br.com.zupacademy.ot3apirest.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository <Aluno, Long> {

}
