package prova;

import java.util.Scanner;

// =========================================================
// HERANÇA — PessoaJuridica extends Cliente
// =========================================================
// Mesmo padrão de PessoaFisica, mas com cnpj no lugar de cpf.
// Demonstra que a MESMA estrutura de herança se repete —
// isso é reutilização de código, um dos benefícios da POO.
//
// POLIMORFISMO:
//   PessoaJuridica também É UM Cliente.
//   Cliente c = new PessoaJuridica(...); ← válido!
// =========================================================

public class PessoaJuridica extends Cliente {

    // Atributo específico de PessoaJuridica
    private String cnpj;

    // =====================================================
    // CONSTRUTOR — chama super() com atributos de Cliente
    // e inicializa cnpj próprio.
    // =====================================================
    public PessoaJuridica(String nome, String conta, String agencia, String cnpj) {
        super(nome, conta, agencia); // inicializa atributos herdados
        this.cnpj = cnpj;           // inicializa atributo próprio
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    // =====================================================
    // lerDados() STATIC — mesma lógica de PessoaFisica
    // =====================================================
    // Chamada: PessoaJuridica.lerDados()
    // Lê dados do teclado e retorna objeto PessoaJuridica.
    // static porque ainda não existe objeto — cria um novo.
    // =====================================================
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

        // Passa cnpj direto no construtor
        return new PessoaJuridica(nome, conta, agencia, cnpj);
    }

    // =====================================================
    // imprimir() — @Override de Impressao (via Cliente)
    // =====================================================
    // POLIMORFISMO EM AÇÃO:
    //   Se tenho Cliente c = new PessoaJuridica(...);
    //   e chamo c.imprimir(); → executa ESTE método aqui,
    //   não o de Cliente. Java decide em TEMPO DE EXECUÇÃO
    //   qual imprimir() chamar baseado no tipo real do objeto.
    //   Isso se chama: POLIMORFISMO DE SOBRESCRITA (override).
    // =====================================================
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
        // super.toString() reutiliza toString() de Cliente
        return "PessoaJuridica{" + super.toString() + ", cnpj='" + cnpj + "'}";
    }
}
