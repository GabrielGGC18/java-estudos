# Atividade 02 — Sistema de Petshop

## Objetivo

Construir um sistema simples de Petshop praticando conceitos novos alem dos ja vistos em `peao/`:

- `ArrayList<T>` (colecao dinamica) no lugar de array fixo
- Multiplas interfaces no mesmo objeto (`implements A, B`)
- `equals` e `hashCode` (igualdade de valor vs igualdade de referencia)
- Enum com atributo proprio (nao so constantes secas)
- `toString` em todas as classes de dominio

## Regras de aprendizado

- Codigo todo escrito a mao, sem copiar/colar.
- Quando travar, descrever o erro em portugues antes de pedir solucao.
- Cada classe num arquivo proprio dentro do pacote `petshop`.

## Estrutura esperada

```
petshop/
  src/
    petshop/
      Main.java
      Animal.java         (classe abstrata)
      Cachorro.java
      Gato.java
      Passaro.java
      Banhavel.java       (interface)
      Tosavel.java        (interface)
      Voador.java         (interface)
      Cliente.java
      Petshop.java
      Porte.java          (enum)
```

## Especificacao das classes

### Enum `Porte`

Constantes: `PEQUENO`, `MEDIO`, `GRANDE`.

Atributo proprio: `double precoBaseBanho`. Construtor do enum recebe o preco. Getter publico.

Exemplo de uso esperado:
```
Porte.PEQUENO.getPrecoBaseBanho()
```

### Classe abstrata `Animal`

Atributos privados: `String nome`, `int idade`, `Porte porte`.

- Construtor com os tres atributos.
- Getters/setters com validacao: `idade` nao pode ser negativa.
- Metodo abstrato `String emitirSom()`.
- Metodo concreto `void apresentar()` que imprime `nome`, `idade`, `porte` e o retorno de `emitirSom()`.
- Sobrescrever `equals`: dois `Animal` sao iguais se tem o mesmo `nome` (case-insensitive) e o mesmo tipo concreto (`getClass()`).
- Sobrescrever `hashCode` coerente com `equals` (usar `Objects.hash`).
- Sobrescrever `toString`.

### Interfaces

- `Banhavel` com `void darBanho()`.
- `Tosavel` com `void tosar()`.
- `Voador` com `void voar()`.

### Subclasses concretas

- `Cachorro implements Banhavel, Tosavel`. `emitirSom()` retorna `"Au au"`.
- `Gato implements Banhavel`. `emitirSom()` retorna `"Miau"`.
- `Passaro implements Voador`. `emitirSom()` retorna `"Piu piu"`.

Cada subclasse imprime mensagens proprias em `darBanho`, `tosar`, `voar`.

### `Cliente`

Atributos: `String nome`, `ArrayList<Animal> animais`.

- Construtor recebe apenas `nome` e ja inicializa `animais = new ArrayList<>()`.
- Metodo `adicionarAnimal(Animal a)` adiciona na lista. Recusa duplicatas usando `contains` (que depende do `equals` da Animal).
- Metodo `removerAnimal(Animal a)`.
- `toString` mostra nome + quantidade de animais.

### `Petshop`

Atributos: `String razaoSocial`, `ArrayList<Cliente> clientes`.

- Metodo `registrarCliente(Cliente c)`.
- Metodo `atenderTodos()` que para cada cliente, para cada animal, chama `apresentar()` e:
  - se o animal e `Banhavel`, chama `darBanho`
  - se e `Tosavel`, chama `tosar`
  - se e `Voador`, chama `voar`

Usar `instanceof` + cast.

### `Main`

Criar 1 Petshop, 2 clientes, dar pelo menos 1 Cachorro, 1 Gato, 1 Passaro distribuidos entre eles. Registrar e chamar `atenderTodos()`.

Testar tambem:
- Tentar adicionar dois `Cachorro` com mesmo nome no mesmo cliente: o segundo deve ser recusado.
- Imprimir `cachorro1.equals(cachorro2)` para confirmar.

## Conceitos novos que aparecem

- `ArrayList<T>`, `import java.util.ArrayList;`
- `Objects.hash`, `import java.util.Objects;`
- Multiplas interfaces no mesmo `implements` (separadas por virgula)
- Enum com construtor + atributo
- Contrato `equals`/`hashCode`: se dois objetos sao `equals`, devem ter o mesmo `hashCode`. O contrario nao precisa valer.

## Ordem sugerida de implementacao

1. `Porte` (enum com construtor) — testa que `Porte.GRANDE.getPrecoBaseBanho()` funciona.
2. `Animal` (abstrata, sem `equals`/`hashCode` ainda) + uma subclasse so (`Cachorro`) + uma `Main` minima que cria 1 cachorro e chama `apresentar()`.
3. Adicionar `Gato` e `Passaro`.
4. Criar as 3 interfaces e fazer cada subclasse implementar as suas.
5. Implementar `Cliente` com `ArrayList`. Testar adicionar e remover.
6. Implementar `equals` e `hashCode` em `Animal`. Testar duplicata sendo recusada.
7. Implementar `Petshop` e `atenderTodos()`.
8. Finalizar `Main` com cenario completo.

## O que registrar ao final

Atualizar `Mentor/JAVA-ESTUDOS.MD` (ou criar `Mentor/ATIVIDADE-02-STATUS.md`) com:
- O que foi feito hoje
- O que travou e por que
- Conceitos que ainda parecem nebulosos
- Proximo passo
