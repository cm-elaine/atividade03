package atividade03;

import java.time.LocalDate;

public class Curso {
    private int codigoCurso;
    private String nomeCurso;
    private LocalDate dataInicioCurso;

    public Curso(int codigoCurso, String nomeCurso, LocalDate dataInicioCurso) {
        this.codigoCurso = codigoCurso;
        this.nomeCurso = nomeCurso;
        this.dataInicioCurso = dataInicioCurso;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public LocalDate getDataInicioCurso() {
        return dataInicioCurso;
    }
}
