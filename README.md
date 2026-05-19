# java-estudos

Repositorio de estudos pessoais em Java focado em Programacao Orientada a Objetos (POO).

## Projeto atual: peao

Sistema simples para gerenciar Peoes de Rodeio e suas Montarias. Serve como exercicio progressivo dos pilares de POO: encapsulamento, heranca, abstracao, polimorfismo, e tambem interfaces.

### Estrutura

```
peao/
  src/
    peao/
      Main.java         ponto de entrada
      Peao.java         classe concreta (nome, apelido, categoria, montarias[])
      Montaria.java     classe abstrata (nomeAnimal, peso, nivelBraveza, modalidade)
      Touro.java        extends Montaria implements Treinavel
      Cavalo.java       extends Montaria implements Treinavel
      Treinavel.java    interface com metodo treinar()
      Modalidade.java   enum (TOURO, CAVALO_FERRARI, SELA_BRASILEIRA, CORDA_BRASILEIRA)
      Categoria.java    enum (JUNIOR, PROFISSIONAL, MASTER)
```

### Como funciona

1. `Montaria` e uma classe abstrata que define os atributos comuns de qualquer animal de rodeio e expoe o metodo abstrato `comportamentoNaArena()`. Cada subclasse concreta e obrigada a implementar esse metodo do seu jeito.

2. `Touro` e `Cavalo` herdam de `Montaria` (`extends`) e tambem assinam o contrato da interface `Treinavel` (`implements`). Cada uma sobrescreve:
   - `comportamentoNaArena()` (herdado da classe abstrata)
   - `treinar()` (herdado da interface)

3. `Peao` agrega um array de `Montaria`, demonstrando composicao.

4. Validacao do atributo `nivelBraveza` (1 a 10) e centralizada no setter `setNivelBraveza`. O proprio construtor chama o setter em vez de atribuir direto, garantindo que objetos invalidos nao escapem da validacao.

5. `Main` instancia um `Touro` e um `Cavalo`, coloca os dois num array tipado como `Montaria[]` e itera. Dentro do loop:
   - Chama `exibirInfo()` (metodo concreto herdado da Montaria)
   - Chama `comportamentoNaArena()` (polimorfismo de subtipo: cada subclasse responde diferente)
   - Verifica `instanceof Treinavel` e, com cast `((Treinavel) m).treinar()`, chama o metodo da interface (polimorfismo via interface)

### Conceitos POO praticados

- Encapsulamento (atributos privados + getters/setters)
- Heranca (`extends`)
- Classe abstrata vs concreta (`abstract class`, metodo abstrato)
- Interface (`interface`, `implements`)
- Diferenca conceitual entre classe abstrata ("e um") e interface ("capaz de")
- Polimorfismo de subtipo (variavel tipo pai, objeto tipo filho)
- Polimorfismo via interface
- Operador `instanceof` e cast explicito
- Enums
- Validacao centralizada via setter chamado pelo construtor
- Package = namespace; estrutura de pastas reflete estrutura do pacote

### Como compilar e executar

A partir da raiz do projeto:

```
cd peao/src
javac peao/*.java
java peao.Main
```

### Tracking de sessao

O arquivo `.claude/ATIIVDADE.MD` guarda o estado da ultima sessao de estudo (o que foi feito, o que falta, conceitos cobertos, proxima fase). Sempre consultado no inicio de uma nova sessao para retomar de onde parou.

### Proximos passos

- Substituir `Montaria[]` por `ArrayList<Montaria>` dinamico
- Implementar `equals` e `hashCode` em `Peao`
- Criar mais subclasses cobrindo as modalidades restantes (Sela, Corda)
- Praticar implementacao de multiplas interfaces no mesmo objeto
