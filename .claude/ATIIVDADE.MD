## ATIVIDADE DE JAVA — ONDE PARAMOS

**Data ultima sessao:** 2026-05-19

### Sessao 2026-05-19 — interface Treinavel concluida

FEITO:
- `Montaria.java` limpa: removido `a p` lixo, removido atributo `treinar` + getters/setters errados
- `setNivelBraveza` consertado: valida 1-10 com `return` e atribui no caminho valido
- Construtor de Montaria agora chama `setNivelBraveza(nivelBraveza)` em vez de atribuicao direta
- Criada interface `Treinavel.java` com `void treinar();`
- `Touro` e `Cavalo` agora `implements Treinavel`, cada um sobrescreve `treinar()` com mensagem propria
- `Main.java` chama `treinar()` via `instanceof Treinavel` + cast `((Treinavel) m).treinar()`

### Conceitos POO trabalhados

- Classe abstrata vs interface ("e um" vs "capaz de")
- Heranca simples (`extends`) + multipla via interfaces (`implements`)
- Polimorfismo via interface
- Operador `instanceof` + cast explicito
- Validacao centralizada em setter (construtor chama setter)
- Package = namespace, estrutura de pasta = estrutura de pacote

### Proxima fase

- ArrayList<Montaria> dinamico em vez de array fixo
- equals/hashCode de Peao
- Mais subclasses (ex: Sela, Corda) cobrindo todas as Modalidades
- Talvez nova interface (ex: Vacinavel) pra praticar multiplas interfaces no mesmo objeto
