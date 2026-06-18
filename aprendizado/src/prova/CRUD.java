package prova;

// =========================================================
// INTERFACE — CRUD
// =========================================================
// CRUD = Create, Read, Update, Delete
//   Padrão famoso em sistemas que gerenciam dados.
//   Aqui define as operações que o Banco deve ter.
//
// Por que separar em interface?
//   - Se amanhã criar outro sistema (ex: Seguradora),
//     ela também pode implementar CRUD com sua lógica.
//   - O contrato é o mesmo, a implementação muda.
//     ISSO É POLIMORFISMO DE INTERFACE.
//
// Regra: Banco implements CRUD
//   → Banco É OBRIGADO a ter todos esses métodos.
//   → Se faltar um, Eclipse mostra erro de compilação.
// =========================================================

public interface CRUD {

    // Adiciona um cliente na lista.
    // Recebe Cliente (tipo pai) — aceita PF e PJ por POLIMORFISMO.
    void inserir(Cliente cliente);

    // Remove cliente pelo índice da lista (posição 0, 1, 2...).
    // NÃO recebe o objeto — recebe a posição (int).
    void excluir(int posicao);

    // Lista todos os clientes ordenados por nome.
    void listarTodosClientes();

    // Lista apenas PessoaFisica, ordenado por agência.
    void listarTodasPessoasFisicas();

    // Lista apenas PessoaJuridica, ordenado por conta.
    void listarTodasPessoasJuridicas();
}
