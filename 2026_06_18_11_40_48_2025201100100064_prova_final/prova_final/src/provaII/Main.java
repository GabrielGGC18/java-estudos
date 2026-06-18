package provaII;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            System.out.println("\n========== BIBLIOTECA ==========");
            System.out.println("1- Cadastrar Aluno");
            System.out.println("2- Cadastrar Livro");
            System.out.println("3- Cadastrar Empréstimo");
            System.out.println("4- Listar Empréstimos");
            System.out.println("5- Buscar Empréstimos por Matrícula");
            System.out.println("6- Buscar Empréstimos por Categoria");
            System.out.println("7- Buscar Empréstimos Atrasados");
            System.out.println("8- Sair");
            System.out.print("Opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    Aluno aluno = Aluno.lerDados();
                    biblioteca.adicionarAluno(aluno);
                    System.out.println("Aluno cadastrado: " + aluno.getNome());
                    break;

                case 2:
                    System.out.print("ID do livro: ");
                    int idLivro = sc.nextInt(); sc.nextLine();
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();
                    System.out.print("Autor: ");
                    String autor = sc.nextLine();
                    System.out.print("Categoria (nome): ");
                    String nomeCategoria = sc.nextLine();
                    Categoria categoria = new Categoria(0, nomeCategoria);
                    Livro livro = new Livro(idLivro, titulo, autor, categoria);
                    biblioteca.adicionarLivro(livro);
                    System.out.println("Livro cadastrado: " + livro.getTitulo());
                    break;

                case 3:
                    if (biblioteca.getListaAluno().isEmpty() || biblioteca.getListaLivro().isEmpty()) {
                        System.out.println("Cadastre alunos e livros antes de fazer empréstimo.");
                        break;
                    }
                    System.out.println("Alunos disponíveis:");
                    for (int i = 0; i < biblioteca.getListaAluno().size(); i++) {
                        System.out.println(i + " - " + biblioteca.getListaAluno().get(i).getNome());
                    }
                    System.out.print("Posição do aluno: ");
                    int posAluno = sc.nextInt(); sc.nextLine();

                    System.out.println("Livros disponíveis:");
                    for (int i = 0; i < biblioteca.getListaLivro().size(); i++) {
                        Livro l = biblioteca.getListaLivro().get(i);
                        System.out.println(i + " - " + l.getTitulo() + " [" + l.getStatus() + "]");
                    }
                    System.out.print("Posição do livro: ");
                    int posLivro = sc.nextInt(); sc.nextLine();

                    Aluno alunoEscolhido = biblioteca.getListaAluno().get(posAluno);
                    Livro livroEscolhido = biblioteca.getListaLivro().get(posLivro);

                    if (!alunoEscolhido.isAtivo()) {
                        System.out.println("Aluno inativo — não pode fazer empréstimo.");
                        break;
                    }
                    if (livroEscolhido.getStatus() != StatusLivro.DISPONIVEL) {
                        System.out.println("Livro não disponível.");
                        break;
                    }

                    System.out.print("Dias para devolução: ");
                    int dias = sc.nextInt(); sc.nextLine();

                    Emprestimo emprestimo = new Emprestimo(
                        biblioteca.getListaEmprestimo().size() + 1,
                        alunoEscolhido,
                        livroEscolhido,
                        LocalDate.now(),
                        LocalDate.now().plusDays(dias)
                    );
                    biblioteca.adicionarEmprestimo(emprestimo);
                    System.out.println("Empréstimo registrado.");
                    break;

                case 4:
                    biblioteca.listarEmprestimo();
                    break;

                case 5:
                    System.out.print("Matrícula: ");
                    String matricula = sc.nextLine();
                    biblioteca.buscarEmprestimosPorMatricula(matricula);
                    break;

                case 6:
                    System.out.print("Categoria (nome): ");
                    String cat = sc.nextLine();
                    biblioteca.buscaEmprestimosPorCategoria(new Categoria(0, cat));
                    break;

                case 7:
                    biblioteca.buscarEmprestimosAtrasados();
                    break;

                case 8:
                    System.out.println("Encerrando sistema...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
