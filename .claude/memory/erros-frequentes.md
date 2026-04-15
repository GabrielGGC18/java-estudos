---
type: project
scope: java-estudos
aluno: bexcbr@gmail.com
criado_em: 2026-04-15
atualizado_em: 2026-04-15
ultima_sessao: 2026-04-15 — Caneta.java (primeira classe instanciada)
descricao: Registro de padrões de erro recorrentes do aluno durante a trilha de Java/POO. Usado pelo mentor para reforçar conceitos e evitar repetir explicações.
---

# Erros Frequentes — Trilha Java/POO

Este arquivo documenta padrões de erro que o aluno cometeu durante a jornada de aprendizado, para que o mentor possa retomá-los em momentos oportunos e reforçar a raiz do conceito, não apenas a correção pontual.

---

## 1. Confusão entre pacote e subpacote (pastas faltando)

- **Data da primeira ocorrência:** 2026-04-15
- **Fase da trilha:** Fundamentos Java / Maven — estrutura de projeto
- **Contexto:** Foi pedido para criar a classe `Pessoa` no pacote `com.example.modelo`.
- **Resposta do aluno:** `demo/src/main/java/com/example/Pessoa.java` (sem a subpasta `modelo`).
- **Resposta correta:** `demo/src/main/java/com/example/modelo/Pessoa.java`.

### Causa raiz
O aluno entendeu que o pacote vira estrutura de pastas, mas não internalizou que **cada ponto (`.`) no nome do pacote corresponde a uma nova subpasta no disco**. Ele parou num nível acima do necessário.

### Conceito a reforçar
- Mapeamento 1-para-1 entre segmentos do pacote e diretórios.
- `com.example.modelo` → `com/example/modelo/` (três níveis de pasta).
- A declaração `package com.example.modelo;` no topo do arquivo DEVE bater exatamente com o caminho físico, senão o compilador reclama.

### Como abordar se reincidir
1. Pedir para o aluno contar os pontos no nome do pacote e afirmar quantas subpastas são necessárias.
2. Mostrar a árvore visual do projeto antes dele criar o arquivo.
3. Só depois deixar ele criar o diretório e o arquivo.

### Sinais de que o conceito foi superado
- O aluno cria subpacotes novos (ex: `servico`, `controle`) sem se confundir.
- Consegue explicar com as próprias palavras por que o caminho precisa bater com o pacote.

---

## 2. Vírgula no lugar de ponto em `System.out.println`

- **Data da primeira ocorrência:** 2026-04-15
- **Fase da trilha:** Fundamentos Java — primeira classe com método de instância (`Caneta.status()`).
- **Contexto:** Dentro do método `status()` da classe `Caneta`, o aluno escreveu `System.out,println("Modelo: " + this.modelo);` — vírgula entre `out` e `println` no lugar do ponto. As outras linhas do mesmo método estavam corretas.
- **Erro do compilador esperado:** `';' expected` / `not a statement` — o compilador interpreta a vírgula como operador e não consegue casar a expressão.

### Causa raiz
Erro de digitação puro (a vírgula fica ao lado do ponto no teclado), mas revela que o aluno ainda não "lê" mentalmente `System.out.println` como uma cadeia de acessos: `System` (classe) → `out` (atributo estático) → `println` (método). Cada ponto é um acesso. Trocar por vírgula quebra a cadeia.

### Conceito a reforçar
- `.` é o operador de acesso a membro (atributo ou método).
- `System.out.println(...)` se lê como "dentro da classe `System`, pegue o objeto `out`, e nele chame `println`".
- Quando aparecer erro de sintaxe nessa linha, o primeiro lugar a olhar é justamente a pontuação.

### Como abordar se reincidir
1. Pedir pro aluno ler a linha em voz alta pronunciando "ponto".
2. Mostrar o erro exato do `javac` e perguntar o que ele acha que significa antes de explicar.
3. Reforçar que o primeiro reflexo ao ver `cannot find symbol` ou `not a statement` numa linha de impressão é verificar pontuação.

### Sinais de que o conceito foi superado
- Aluno escreve várias linhas de `println` seguidas sem errar a pontuação.
- Quando erra, localiza sozinho antes de pedir ajuda.

---

## 3. Variáveis declaradas mas nunca usadas

- **Data da primeira ocorrência:** 2026-04-15
- **Fase da trilha:** Fundamentos Java — dentro do `main`.
- **Contexto:** No `Main.java` o aluno declarou `String Nome;`, `boolean idade;` e `int altura;` mas não atribuiu valor nem usou em nenhum lugar.

### Causa raiz
Provavelmente começou a esboçar um exemplo diferente e não apagou. Também pode estar confundindo "declarar variável" com "deixar preparado caso precise depois".

### Conceito a reforçar
- Variável declarada e não usada gera warning do compilador e é "código morto".
- Em Java, declarar não custa execução, mas polui e confunde quem lê.
- Melhor declarar apenas quando for usar, e o mais próximo possível do uso.

### Como abordar se reincidir
- Perguntar: "Essa variável vai ser usada? Se não, por que ela está aí?".
- Mostrar o warning do IDE/compilador.

---

## 4. Convenção de nomes — variável começando com maiúscula

- **Data da primeira ocorrência:** 2026-04-15
- **Fase da trilha:** Fundamentos Java — estilo/convenção.
- **Contexto:** Aluno escreveu `String Nome;` no `main`.

### Causa raiz
Ainda não absorveu a convenção Java de nomenclatura: **classes** começam com maiúscula (`Caneta`, `Main`), **variáveis e métodos** começam com minúscula (`nome`, `idade`, `calcularArea`).

### Conceito a reforçar
- PascalCase → classes, interfaces, enums.
- camelCase → variáveis, atributos, métodos, parâmetros.
- Constantes (`static final`) → UPPER_SNAKE_CASE.
- O compilador aceita `Nome`, mas qualquer revisor de código vai estranhar.

### Como abordar se reincidir
- Apontar a inconsistência: "Olha aqui, `Caneta` é classe e começa com maiúscula, faz sentido. Mas `Nome` é variável — segue a mesma regra?".

---

## 5. Tipo errado para representar idade (`boolean` em vez de `int`)

- **Data da primeira ocorrência:** 2026-04-15
- **Fase da trilha:** Fundamentos Java — tipos primitivos.
- **Contexto:** `boolean idade;` no `main`.

### Causa raiz
Possível confusão entre os tipos primitivos. `boolean` só armazena `true`/`false`, então "idade booleana" não faz sentido semântico. Pode ter sido descuido ou realmente uma confusão de quando usar cada tipo.

### Conceito a reforçar
- Tipos primitivos numéricos: `byte`, `short`, `int`, `long`, `float`, `double`.
- `boolean` é só para respostas sim/não (está vivo? está tampada? maior de idade?).
- Antes de declarar, pergunte: "que tipo de valor essa variável vai guardar? número inteiro, número com vírgula, texto, ou sim/não?".

### Como abordar se reincidir
- Perguntar o que a variável representa no mundo real e qual tipo de valor cabe ali.
- Usar a própria `Caneta` como exemplo: `tampada` é boolean (sim/não), `carga` é int (quantidade), `ponta` é float (medida).

### Sinais de que o conceito foi superado
- Aluno escolhe o tipo correto de primeira ao modelar novos atributos.

---

## 6. Esquecer de inicializar atributos antes de usar o objeto

- **Data da primeira ocorrência:** 2026-04-15
- **Fase da trilha:** Introdução à POO — instanciação e valores padrão.
- **Contexto:** Aluno criou `Caneta c0 = new Caneta();`, setou `cor`, `ponta`, `tampada`, mas não setou `modelo` nem `carga`. Ao chamar `status()`, a saída mostraria `Modelo: null` e `Carga: 0`.

### Causa raiz
Ainda não sabe que Java atribui valores padrão a atributos de instância quando o objeto é criado:
- Tipos numéricos → `0` / `0.0`
- `boolean` → `false`
- Referências (String, objetos) → `null`

### Conceito a reforçar
- Ao fazer `new Caneta()`, a JVM reserva memória e preenche cada atributo com o valor padrão do seu tipo.
- `null` é a ausência de objeto — chamar método em algo `null` dá `NullPointerException`.
- Este é o gancho perfeito para introduzir **construtores**: garantir que o objeto nasça num estado válido.

### Como abordar se reincidir
- Rodar o código e mostrar a saída com `null` e `0`.
- Perguntar: "Como garantir que nunca saia uma Caneta incompleta da fábrica?" → resposta: construtor.

### Sinais de que o conceito foi superado
- Aluno começa a escrever construtores espontaneamente.
- Reconhece `null` na saída como "esqueci de setar".

---

<!-- Próximos erros serão adicionados abaixo conforme forem surgindo. Manter o padrão de seção: título, data, contexto, causa raiz, conceito a reforçar, como abordar, sinais de superação. -->
