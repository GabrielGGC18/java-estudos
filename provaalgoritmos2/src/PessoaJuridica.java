package provaalgoritmos2;

import java.util.Scanner;

public class PessoaJuridica extends Cliente {
    private String cnpj;

    public PessoaJuridica(String nome, String conta, String agencia) {
        super(nome, conta, agencia);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public static PessoaJuridica lerDados() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Conta: ");
        String conta = sc.nextLine();
        System.out.print("Agência: ");
        String agencia = sc.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = sc.nextLine();
        PessoaJuridica pj = new PessoaJuridica(nome, conta, agencia);
        pj.setCnpj(cnpj);
        return pj;
    }

    @Override
    public void imprimir() {
        System.out.println("[PessoaJuridica] " + toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PessoaJuridica)) return false;
        PessoaJuridica other = (PessoaJuridica) obj;
        return cnpj != null && cnpj.equals(other.cnpj);
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" + super.toString() + ", cnpj='" + cnpj + "'}";
    }
}
