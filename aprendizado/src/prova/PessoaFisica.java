package prova;

// =========================================================
// IMPORTAÇÃO
// =========================================================
// Scanner está em java.util — precisa importar para ler
// dados do teclado (System.in).
// =========================================================
import java.util.Scanner;

// =========================================================
// HERANÇA — PessoaFisica extends Cliente
// =========================================================
// extends = PessoaFisica HERDA tudo de Cliente:
//   - atributos: nome, conta, agencia, dataCadastro
//   - métodos: getNome(), getConta(), equals(), toString()...
//
// PessoaFisica ADICIONA seu próprio atributo: cpf
//
// POLIMORFISMO:
//   PessoaFisica É UM Cliente.
//   Posso guardar PessoaFisica em variável do tipo Cliente:
//     Cliente c = new PessoaFisica(...);  ← válido!
//   Isso permite listas List<Cliente> com PF e PJ juntos.
// =========================================================

public class PessoaFisica extends Cliente {

    // Atributo específico de PessoaFisica — não existe em Cliente
    private String cpf;

    // =====================================================
    // CONSTRUTOR com TODOS os atributos
    // =====================================================
    // super(...) = chama o construtor da classe PAI (Cliente).
    // OBRIGATÓRIO ser a primeira linha do construtor filho.
    // Os atributos de Cliente são inicializados lá.
    // cpf é inicializado aqui mesmo, pois é de PessoaFisica.
    // =====================================================
    public PessoaFisica(String nome, String conta, String agencia, String cpf) {
        super(nome, conta, agencia); // chama construtor de Cliente
        this.cpf = cpf;             // inicializa atributo próprio
    }

    // Getter e setter de cpf — encapsulamento
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // =====================================================
    // lerDados() — método STATIC
    // =====================================================
    // static = pertence à CLASSE, não a um objeto.
    // Chamada: PessoaFisica.lerDados()
    //   NÃO precisa criar objeto antes de chamar.
    //   NÃO usa "this" — não há objeto ainda.
    //
    // Por que static aqui?
    //   Faz sentido: ainda não temos PessoaFisica criada.
    //   lerDados() coleta os dados e RETORNA um objeto novo.
    //   É uma "fábrica" de PessoaFisica.
    //
    // Scanner sc = new Scanner(System.in)
    //   System.in = entrada padrão (teclado)
    //   Scanner = lê o que o usuário digita
    //
    // sc.nextLine() = lê uma linha inteira como String
    // =====================================================
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

        // Cria e retorna o objeto com todos os dados
        // Passa cpf direto no construtor (não precisa setCpf depois)
        return new PessoaFisica(nome, conta, agencia, cpf);
    }

    // =====================================================
    // imprimir() — @Override de Impressao
    // =====================================================
    // A interface Impressao exige imprimir().
    // Cliente não implementou (é abstract).
    // PessoaFisica DEVE implementar.
    //
    // toString() aqui chama o toString() desta classe
    // (que por sua vez chama super.toString()).
    // =====================================================
    @Override
    public void imprimir() {
        System.out.println("[PessoaFisica] " + toString());
    }

    // =====================================================
    // equals() — @Override de Cliente
    // =====================================================
    // PessoaFisica redefine equals(): duas PF são iguais
    // se têm o mesmo CPF (identificador único).
    //
    // Note: instanceof PessoaFisica (não Cliente) —
    // garante que só compara PF com PF.
    // =====================================================
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PessoaFisica)) return false;
        PessoaFisica other = (PessoaFisica) obj;
        return cpf != null && cpf.equals(other.cpf);
    }

    // =====================================================
    // toString() — @Override de Cliente
    // =====================================================
    // super.toString() = pega a String de Cliente
    //   (nome, conta, agencia, cadastro)
    // Adiciona cpf específico de PessoaFisica.
    // =====================================================
    @Override
    public String toString() {
        return "PessoaFisica{" + super.toString() + ", cpf='" + cpf + "'}";
    }
}
