package br.com.zupacademy.ot3apirest.controller;

import br.com.zupacademy.ot3apirest.model.Aluno;

import javax.persistence.Column;

public class AlunoResponse {

    private String nome;
    private String email;

    public AlunoResponse(Aluno aluno) {
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

}
