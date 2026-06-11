package provaalgoritmos2;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private String codigo;

    private List<PessoaFisica> pessoasFisicas = new ArrayList<>();
    private List<PessoaJuridica> pessoasJuridicas = new ArrayList<>();

    public Banco(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void inserir(PessoaFisica pf) {
        pessoasFisicas.add(pf);
    }

    public void inserir(PessoaJuridica pj) {
        pessoasJuridicas.add(pj);
    }

    public boolean excluir(PessoaFisica pf) {
        return pessoasFisicas.remove(pf);
    }

    public boolean excluir(PessoaJuridica pj) {
        return pessoasJuridicas.remove(pj);
    }

    public List<PessoaFisica> getPessoasFisicas() {
        return pessoasFisicas;
    }

    public List<PessoaJuridica> getPessoasJuridicas() {
        return pessoasJuridicas;
    }

    public void listarTodasPessoasFisicas() {
        System.out.println("--- Pessoas Físicas ---");
        for (PessoaFisica pf : pessoasFisicas) {
            pf.imprimir();
        }
    }

    public void listarTodasPessoasJuridicas() {
        System.out.println("--- Pessoas Jurídicas ---");
        for (PessoaJuridica pj : pessoasJuridicas) {
            pj.imprimir();
        }
    }
}
