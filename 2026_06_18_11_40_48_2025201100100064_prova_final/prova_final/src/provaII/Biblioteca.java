package provaII;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Livro> listaLivro = new ArrayList<>();
    private List<Emprestimo> listaEmprestimo = new ArrayList<>();
    private List<Aluno> listaAluno = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        listaLivro.add(livro);
    }

    public void adicionarAluno(Aluno aluno) {
        listaAluno.add(aluno);
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        listaEmprestimo.add(emprestimo);
    }

    public void listarEmprestimo() {
        if (listaEmprestimo.isEmpty()) {
            System.out.println("Nenhum empréstimo cadastrado.");
            return;
        }
        for (Emprestimo e : listaEmprestimo) {
            e.imprimir();
        }
    }

    public void buscarEmprestimosPorMatricula(String matricula) {
        boolean encontrou = false;
        for (Emprestimo e : listaEmprestimo) {
            if (e.getAluno().getMatricula().equals(matricula)) {
                e.imprimir();
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum empréstimo para matrícula: " + matricula);
    }

    public void buscaEmprestimosPorCategoria(Categoria categoria) {
        boolean encontrou = false;
        for (Emprestimo e : listaEmprestimo) {
            if (e.getLivro().getCategoria().equals(categoria)) {
                e.imprimir();
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum empréstimo para categoria: " + categoria.getNome());
    }

    public void buscarEmprestimosAtrasados() {
        boolean encontrou = false;
        for (Emprestimo e : listaEmprestimo) {
            if (e.isAtrasado()) {
                e.imprimir();
                encontrou = true;
            }
        }
        if (!encontrou) System.out.println("Nenhum empréstimo em atraso.");
    }

    public List<Livro> getListaLivro() { return listaLivro; }
    public List<Aluno> getListaAluno() { return listaAluno; }
    public List<Emprestimo> getListaEmprestimo() { return listaEmprestimo; }
}
