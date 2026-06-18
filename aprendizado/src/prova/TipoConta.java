package prova;

// =========================================================
// ENUM — TipoConta
// =========================================================
// O que é um enum?
//   - Uma classe especial que representa um conjunto fixo
//     de constantes nomeadas.
//   - Aqui: conta só pode ser CONTA_CORRENTE ou POUPANCA.
//     Impossível passar valor inválido.
//
// Por que usar enum e não String?
//   - Com String alguém pode digitar "poupanca", "Poupança",
//     "POUPANÇA"... erro garantido.
//   - Com enum só existe TipoConta.POUPANCA. Seguro e claro.
//
// Enum com valor inteiro:
//   - Cada constante recebe um int no construtor.
//   - O construtor do enum é PRIVADO por padrão.
//   - getValor() expõe o número associado.
// =========================================================

public enum TipoConta {

    // Constantes do enum com valor inteiro associado
    CONTA_CORRENTE(1),
    POUPANCA(2);

    // Atributo que guarda o valor inteiro
    // final = não muda depois de atribuído
    private final int valor;

    // Construtor do enum — sempre privado
    // Chamado automaticamente na declaração acima
    TipoConta(int valor) {
        this.valor = valor;
    }

    // Getter do valor inteiro
    public int getValor() {
        return valor;
    }
}
