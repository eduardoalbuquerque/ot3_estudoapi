package br.com.zupacademy.ot3apirest.controller;

import br.com.zupacademy.ot3apirest.model.Aluno;
import br.com.zupacademy.ot3apirest.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional <Aluno> aluno = alunoRepository.findById(id);
        if(aluno.isPresent()){
            return ResponseEntity.ok(aluno);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<AlunoResponse> cadastrarNovoAluno(@RequestBody @Valid AlunoRequest alunoRequest) {
        return ResponseEntity.ok(new AlunoResponse(alunoRepository.save(alunoRequest.converter())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        if(aluno.isPresent()){
//            alunoRepository.deleteById(aluno.get().getId());
            alunoRepository.delete(aluno.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
