package br.com.zupacademy.ot3apirest;

import br.com.zupacademy.ot3apirest.model.Aluno;

public class TesteAluno {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno();
        aluno1.setNome("Marcio");
        aluno1.setEmail("m@m.com");

        System.out.println(aluno1.getEmail() + "|" + aluno1.getNome());


    }
}
