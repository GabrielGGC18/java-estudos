---
type: project
scope: java-estudos
aluno: bexcbr@gmail.com
criado_em: 2026-04-15
atualizado_em: 2026-04-15
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

<!-- Próximos erros serão adicionados abaixo conforme forem surgindo. Manter o padrão de seção: título, data, contexto, causa raiz, conceito a reforçar, como abordar, sinais de superação. -->
