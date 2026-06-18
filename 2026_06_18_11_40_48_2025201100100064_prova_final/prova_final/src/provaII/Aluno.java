package provaII;

import java.util.Objects;
import java.util.Scanner;

public class Aluno {

    private String matricula;
    private String nome;
    private String telefone;
    private boolean ativo;

    public Aluno(String matricula, String nome, String telefone, boolean ativo) {
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
        this.ativo = ativo;
    }

    public static Aluno lerDados() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do Aluno: ");
        String nome = sc.nextLine();

        System.out.print("Matrícula: ");
        String matricula = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Ativo? (s/n): ");
        boolean ativo = sc.nextLine().trim().equalsIgnoreCase("s");

        return new Aluno(matricula, nome, telefone, ativo);
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    public void imprimir() {
        System.out.println("[Aluno] " + toString());
    }

    @Override
    public String toString() {
        return "Aluno [matricula=" + matricula + ", nome=" + nome
                + ", telefone=" + telefone + ", ativo=" + ativo + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aluno other = (Aluno) obj;
        return Objects.equals(matricula, other.matricula);
    }
}
