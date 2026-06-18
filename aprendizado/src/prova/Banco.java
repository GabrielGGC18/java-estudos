package prova;

// =========================================================
// IMPORTAÇÕES — java.util
// =========================================================
// ArrayList = implementação de List usando array dinâmico.
//   Cresce automaticamente conforme adiciona elementos.
//   Permite acesso por índice: lista.get(0), lista.get(1)...
//
// Collections = classe utilitária com métodos estáticos.
//   Collections.sort(lista) → ordena usando compareTo().
//
// List = INTERFACE de lista (não uma classe concreta).
//   List<Cliente> lista = new ArrayList<>();
//   ↑ tipo declarado como interface (boa prática)
//   ↑ instanciado como ArrayList (implementação concreta)
//   Por que? Se trocar ArrayList por LinkedList amanhã,
//   só muda uma linha. O resto do código não muda.
// =========================================================
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// =========================================================
// CLASSE Banco — implements CRUD
// =========================================================
// implements CRUD = Banco assina o contrato da interface CRUD.
// Banco É OBRIGADO a implementar todos os métodos de CRUD:
//   inserir(), excluir(), listarTodosClientes(),
//   listarTodasPessoasFisicas(), listarTodasPessoasJuridicas()
//
// Se faltar qualquer um → ERRO DE COMPILAÇÃO.
// O Eclipse mostra: "The type Banco must implement..."
// =========================================================

public class Banco implements CRUD {

    private String nome;
    private String codigo;

    // =====================================================
    // LISTA ESTÁTICA — listaCliente
    // =====================================================
    // static = pertence à CLASSE Banco, não a uma instância.
    //   Todos os objetos Banco compartilham a mesma lista.
    //   Acesso: Banco.listaCliente (sem precisar de objeto)
    //
    // List<Cliente> = lista de Clientes
    //   <Cliente> = GENERIC — só aceita objetos do tipo Cliente
    //   (ou subclasses: PessoaFisica, PessoaJuridica)
    //   Isso é POLIMORFISMO: a lista guarda os dois tipos!
    //
    // new ArrayList<>() = cria lista vazia
    //   <> = diamond operator — Java infere o tipo (<Cliente>)
    // =====================================================
    public static List<Cliente> listaCliente = new ArrayList<>();

    public Banco(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() { return nome; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    // =====================================================
    // inserir(Cliente cliente) — @Override de CRUD
    // =====================================================
    // Recebe Cliente (tipo pai) — POLIMORFISMO!
    //   Pode passar PessoaFisica ou PessoaJuridica aqui.
    //   Java aceita porque ambas SÃO Clientes (extends Cliente).
    //
    // listaCliente.add(cliente) = adiciona no fim da lista.
    // =====================================================
    @Override
    public void inserir(Cliente cliente) {
        listaCliente.add(cliente);
    }

    // =====================================================
    // excluir(int posicao) — @Override de CRUD
    // =====================================================
    // remove(int index) = remove pelo índice (posição).
    //   lista: [Ana, Bruno, Carla]
    //          pos 0  pos 1  pos 2
    //   remove(1) → remove Bruno.
    //
    // CUIDADO: se posição inválida → IndexOutOfBoundsException
    // =====================================================
    @Override
    public void excluir(int posicao) {
        listaCliente.remove(posicao);
    }

    // =====================================================
    // listarTodosClientes() — @Override de CRUD
    // =====================================================
    // Collections.sort(listaCliente):
    //   Ordena a lista usando compareTo() de Cliente.
    //   Cliente implements Comparable<Cliente> → compareTo()
    //   ordena por nome (implementamos lá).
    //
    // for com índice — necessário para mostrar posição:
    //   for-each não dá acesso ao índice i.
    //   listaCliente.get(i) → pega objeto na posição i.
    //   .imprimir() → POLIMORFISMO: chama imprimir() do tipo
    //   real (PF ou PJ), não de Cliente.
    // =====================================================
    @Override
    public void listarTodosClientes() {
        Collections.sort(listaCliente); // ordena por nome
        for (int i = 0; i < listaCliente.size(); i++) {
            System.out.print("Posição " + i + ": ");
            listaCliente.get(i).imprimir(); // polimorfismo aqui!
        }
    }

    // =====================================================
    // listarTodasPessoasFisicas() — @Override de CRUD
    // =====================================================
    // Filtra lista por tipo usando instanceof.
    //
    // instanceof = operador que verifica o tipo real do objeto.
    //   c instanceof PessoaFisica → true se c for PF.
    //   Funciona mesmo com variável declarada como Cliente
    //   (que é o tipo da lista).
    //
    // Ordenação por agência usando Lambda:
    //   lista.sort((a, b) -> a.getAgencia().compareTo(b.getAgencia()))
    //   Lambda = função anônima passada como parâmetro.
    //   (a, b) → dois elementos comparados.
    //   Retorna negativo/zero/positivo (mesmo que compareTo).
    // =====================================================
    @Override
    public void listarTodasPessoasFisicas() {
        System.out.println("--- Pessoas Físicas (ordenado por agência) ---");

        // 1. Filtra só PessoaFisica da lista geral
        List<PessoaFisica> listaPF = new ArrayList<>();
        for (Cliente c : listaCliente) {
            if (c instanceof PessoaFisica) {
                listaPF.add((PessoaFisica) c); // cast: converte Cliente → PessoaFisica
            }
        }

        // 2. Ordena por agência (lambda)
        listaPF.sort((a, b) -> a.getAgencia().compareTo(b.getAgencia()));

        // 3. Imprime
        for (PessoaFisica pf : listaPF) {
            pf.imprimir();
        }
    }

    // =====================================================
    // listarTodasPessoasJuridicas() — @Override de CRUD
    // =====================================================
    // Mesmo padrão de listarTodasPessoasFisicas(),
    // mas filtra PessoaJuridica e ordena por conta.
    // =====================================================
    @Override
    public void listarTodasPessoasJuridicas() {
        System.out.println("--- Pessoas Jurídicas (ordenado por conta) ---");

        // 1. Filtra só PessoaJuridica
        List<PessoaJuridica> listaPJ = new ArrayList<>();
        for (Cliente c : listaCliente) {
            if (c instanceof PessoaJuridica) {
                listaPJ.add((PessoaJuridica) c); // cast: Cliente → PessoaJuridica
            }
        }

        // 2. Ordena por conta (lambda)
        listaPJ.sort((a, b) -> a.getConta().compareTo(b.getConta()));

        // 3. Imprime
        for (PessoaJuridica pj : listaPJ) {
            pj.imprimir();
        }
    }
}
