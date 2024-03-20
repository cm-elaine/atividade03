package atividade03;

import java.time.LocalDate;

public class Aluno {
    private int numeroMatricula;
    private String nome;
    private LocalDate dataNascimento;

    public Aluno(int numeroMatricula, String nome, LocalDate dataNascimento) {
        this.numeroMatricula = numeroMatricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
