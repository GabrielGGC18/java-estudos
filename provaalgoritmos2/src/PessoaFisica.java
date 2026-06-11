package provaalgoritmos2;

import java.util.Scanner;

public class PessoaFisica extends Cliente {
    private String cpf;

    public PessoaFisica(String nome, String conta, String agencia) {
        super(nome, conta, agencia);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static PessoaFisica lerDados() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Conta: ");
        String conta = sc.nextLine();
        System.out.print("Agência: ");
        String agencia = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        PessoaFisica pf = new PessoaFisica(nome, conta, agencia);
        pf.setCpf(cpf);
        return pf;
    }

    @Override
    public void imprimir() {
        System.out.println("[PessoaFisica] " + toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PessoaFisica)) return false;
        PessoaFisica other = (PessoaFisica) obj;
        return cpf != null && cpf.equals(other.cpf);
    }

    @Override
    public String toString() {
        return "PessoaFisica{" + super.toString() + ", cpf='" + cpf + "'}";
    }
}
