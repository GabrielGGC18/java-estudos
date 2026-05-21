package atividade3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // TODO Q3: cadastrar 5 pessoas (lerDados) e imprimirLista
        // TODO Q4: imprimirLista(lista, Sexo.MASCULINO)
        // TODO Q5: testar ordenacoes por nome, idade, sexo (classes anonimas)
        // TODO Q6: testar ordenacoes via lambda
    }

    // Q3
    public static Pessoa lerDados() {
        // TODO: ler dados do usuario (Scanner) e retornar Pessoa
        return null;
    }

    // Q3
    public static void imprimirLista(List<Pessoa> lista) {
        // TODO: imprimir todas as pessoas, inclusive relacionamentos
    }

    // Q4
    public static void imprimirLista(List<Pessoa> lista, Sexo sexo) {
        // TODO: imprimir apenas as pessoas do sexo informado
    }

    // Q5 — classes anonimas (Comparator)
    public static void imprimirListaOrdenadaPorNome(List<Pessoa> lista) {
        // TODO: ordenar por nome usando classe anonima
    }

    public static void imprimirListaOrdenadaPorIdade(List<Pessoa> lista) {
        // TODO: ordenar por idade usando classe anonima
    }

    public static void imprimirListaOrdenadaPorSexo(List<Pessoa> lista) {
        // TODO: ordenar por sexo usando classe anonima
    }

    // Q6 — reimplementar Q5 com lambda
    // TODO: versoes lambda dos tres metodos de ordenacao
}
