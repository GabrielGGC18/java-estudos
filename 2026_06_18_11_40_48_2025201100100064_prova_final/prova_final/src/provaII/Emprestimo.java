package provaII;

import java.time.LocalDate;
import java.util.Objects;

public class Emprestimo {

    private int id;
    private Aluno aluno;
    private Livro livro;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolvida;

    public Emprestimo(int id, Aluno aluno, Livro livro, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao) {
        this.id = id;
        this.aluno = aluno;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        livro.setStatus(StatusLivro.EMPRESTADO);
    }

    public boolean isAtrasado() {
        return dataDevolvida == null && LocalDate.now().isAfter(dataPrevistaDevolucao);
    }

    public void devolver() {
        this.dataDevolvida = LocalDate.now();
        livro.setStatus(StatusLivro.DISPONIVEL);
    }

    public int getId() { return id; }
    public Aluno getAluno() { return aluno; }
    public Livro getLivro() { return livro; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataPrevistaDevolucao() { return dataPrevistaDevolucao; }
    public LocalDate getDataDevolvida() { return dataDevolvida; }

    public void setDataEmprestimo(LocalDate dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }
    public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) { this.dataPrevistaDevolucao = dataPrevistaDevolucao; }

    public void imprimir() {
        System.out.println("[Emprestimo] " + toString());
    }

    @Override
    public String toString() {
        return "Emprestimo [id=" + id
                + ", aluno=" + aluno.getNome()
                + ", livro=" + livro.getTitulo()
                + ", dataEmprestimo=" + dataEmprestimo
                + ", dataPrevistaDevolucao=" + dataPrevistaDevolucao
                + ", devolvido=" + (dataDevolvida != null ? dataDevolvida : "não") + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Emprestimo other = (Emprestimo) obj;
        return id == other.id;
    }
}
