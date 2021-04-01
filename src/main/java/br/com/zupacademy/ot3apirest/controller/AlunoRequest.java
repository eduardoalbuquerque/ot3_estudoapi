package br.com.zupacademy.ot3apirest.controller;

import br.com.zupacademy.ot3apirest.model.Aluno;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AlunoRequest {

    @NotBlank @Size(max=50, min=3)
    private String nome;
    @NotBlank @Email @Size(max=60)
    private String email;
    @CPF @NotNull
    private String cpf;

    public AlunoRequest(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public Aluno converter() {
        return new Aluno(this.nome, this.email, this.cpf);
    }
}
