package br.com.zupacademy.ot3apirest.model;

import javax.persistence.*;

@Entity
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(unique = true, length = 60, nullable = false)
    private String email;
    @Column(unique = true, length = 14)
    private String cpf;

    @Deprecated
    public Aluno(){
    }

    public Aluno(String nome, String email, String cpf) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
