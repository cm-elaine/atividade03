package atividade03;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Curso> cursos = new ArrayList<>();
        ArrayList<Matricula> matriculas = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Curso");
            System.out.println("3. Realizar Matrícula");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarAluno(scanner, alunos);
                    break;

                case 2:
                    cadastrarCurso(scanner, cursos);
                    break;

                case 3:
                    realizarMatricula(scanner, alunos, cursos, matriculas);
                    break;

                case 4:
                    System.out.println("Encerrando o programa...");
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void cadastrarAluno(Scanner scanner, ArrayList<Aluno> alunos) {
        System.out.println("\nCadastro de Aluno:");
        System.out.print("Número de matrícula: ");
        int numeroMatricula = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Data de nascimento (AAAA-MM-DD): ");
        String dataNascimentoString = scanner.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoString);

        Aluno aluno = new Aluno(numeroMatricula, nome, dataNascimento);
        alunos.add(aluno);

        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void cadastrarCurso(Scanner scanner, ArrayList<Curso> cursos) {
        System.out.println("\nCadastro de Curso:");
        System.out.print("Código do curso: ");
        int codigoCurso = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.print("Nome do curso: ");
        String nomeCurso = scanner.nextLine();

        System.out.print("Data de início do curso (AAAA-MM-DD): ");
        String dataInicioString = scanner.nextLine();
        LocalDate dataInicio = LocalDate.parse(dataInicioString);

        Curso curso = new Curso(codigoCurso, nomeCurso, dataInicio);
        cursos.add(curso);

        System.out.println("Curso cadastrado com sucesso!");
    }

    private static void realizarMatricula(Scanner scanner, ArrayList<Aluno> alunos, ArrayList<Curso> cursos, ArrayList<Matricula> matriculas) {
        System.out.println("\nRealizar Matrícula:");


        System.out.println("\nAlunos disponíveis para matrícula:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNumeroMatricula() + " - " + aluno.getNome());
        }
        System.out.print("Digite o número de matrícula do aluno: ");
        int numMatriculaAluno = scanner.nextInt();
        scanner.nextLine(); 

        Aluno alunoSelecionado = null;
        for (Aluno aluno : alunos) {
            if (aluno.getNumeroMatricula() == numMatriculaAluno) {
                alunoSelecionado = aluno;
                break;
            }
        }
        if (alunoSelecionado == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }


        System.out.println("\nCursos disponíveis para matrícula:");
        for (Curso curso : cursos) {
            System.out.println(curso.getCodigoCurso() + " - " + curso.getNomeCurso());
        }
        System.out.print("Digite o código do curso desejado: ");
        int codigoCurso = scanner.nextInt();
        scanner.nextLine(); 

        Curso cursoSelecionado = null;
        for (Curso curso : cursos) {
            if (curso.getCodigoCurso() == codigoCurso) {
                cursoSelecionado = curso;
                break;
            }
        }
        if (cursoSelecionado == null) {
            System.out.println("Curso não encontrado.");
            return;
        }


        LocalDate dataAtual = LocalDate.now();
        Matricula matricula = new Matricula(alunoSelecionado, cursoSelecionado, dataAtual);
        matriculas.add(matricula);

        System.out.println("Matrícula realizada com sucesso!");
    }
}
