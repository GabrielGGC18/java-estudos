# Atividade 3 — Pessoa, Telefone, Interface, Ordenação

## Questão 01
Implemente em Java o modelo (Pessoa e Telefone), com seus métodos de acesso
(getters/setters) e construtores. Sobrescreva o `toString`, retornando todas
as informações de seus atributos.

## Questão 02
Crie uma interface `Impressao` contendo apenas:
```java
public void imprimir();
```
Implemente essa interface nas classes `Pessoa` e `Telefone` da questão
anterior. O método deve imprimir todas as informações (atributos) da classe.

## Questão 03
Aplicação que cadastra 5 pessoas em uma lista (usar Coleções) e imprime os
dados. Implementar:
- `public static Pessoa lerDados();` — solicita os dados ao usuário e retorna uma Pessoa.
- `public static void imprimirLista(List<Pessoa> lista);` — recebe a lista e imprime tudo, inclusive os relacionamentos (Telefone).

Obs.: reutilizar as classes/métodos das questões 1 e 2.

## Questão 04
Implemente um método de impressão que filtra por sexo:
```java
public void imprimirLista(List<Pessoa> lista, Sexo sexo);
```
Adicione na questão anterior e imprima apenas as pessoas do sexo masculino.

## Questão 05
Métodos de ordenação usando **classes anônimas** (`Comparator`):
1. `public static void imprimirListaOrdenadaPorNome(List<Pessoa> lista);`
2. `public static void imprimirListaOrdenadaPorIdade(List<Pessoa> lista);`
3. `public static void imprimirListaOrdenadaPorSexo(List<Pessoa> lista);`

Crie um `main` e teste todos os métodos.

## Questão 06
Reimplemente todos os métodos da questão 05 usando **expressões lambda**.
Faça os testes.
