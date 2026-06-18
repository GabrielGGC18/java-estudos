package prova;

// =========================================================
// INTERFACE — Impressao
// =========================================================
// O que é uma interface?
//   - Um CONTRATO. Define o que uma classe DEVE ter,
//     mas NÃO implementa nada (só assina os métodos).
//   - Qualquer classe que "implements Impressao" É OBRIGADA
//     a ter os métodos declarados aqui.
//   - Palavra-chave: interface (no lugar de class)
//
// Por que usar interface aqui?
//   - Garante que TODO objeto que implementa Impressao
//     sabe se imprimir e retornar o nome.
//   - Permite polimorfismo: posso tratar PessoaFisica e
//     PessoaJuridica como "Impressao" sem saber o tipo exato.
// =========================================================

public interface Impressao {

    // Método abstrato de interface — sem corpo, sem chaves.
    // Quem implementar DEVE sobrescrever com @Override.
    String getNome();

    // Outro método do contrato.
    // Cada classe vai imprimir seus dados do seu jeito.
    void imprimir();
}
