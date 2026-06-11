# A2 – Algoritmos e Programação II
**Professor:** Jânio Elias Teixeira Júnior | **Valor:** 7.0

---

## Requisitos gerais (leia antes de começar)

- `Cliente` é **abstract**
- `lerDados()` de `PessoaFisica` e `PessoaJuridica` são **static**
- `listaCliente` em `Banco` é `static List<Cliente>`
- Ao imprimir: usar `toString()` **e** mostrar a posição do objeto na lista
- Seguir o UML abaixo fielmente

---

## UML

```
<<interface>>              <<interface>>
    CRUD                    Impressao
+ inserir(cliente: Cliente) : void    + imprimir() : void
+ excluir(posicao: int) : void
+ listarTodosClientes() : void
+ listarTodasPessoasFisicas() : void
+ listarTodasPessoasJuridicas() : void

         Banco ──────────────── Cliente (abstract) ──── <<enum>> TipoConta
+ main(args: String[]) : void   - agencia : String      - CONTA_CORRENTE : int
+ listaCliente : static List    - conta : String         - POUPANCA : int
                                - nome : String
                                - dataCadastro : LocalDate
                     ┌──────────────┴──────────────┐
               PessoaFisica                  PessoaJuridica
               - cpf : String                - cnpj : String
               + lerDados() : PessoaFisica   + lerDados() : PessoaJuridica
```

---

## Itens da prova

### A – Menu infinito (0.6 pts)
Menu que repete até opção 6 (Sair):
1. Inserir um Cliente
2. Excluir um Cliente
3. Listar Todos os Clientes
4. Listar Todas as Pessoas Físicas
5. Listar Todas as Pessoas Jurídicas
6. Sair

---

### B – Criar a estrutura UML (0.9 pts)
1. Criar todas as Classes, Interfaces e Enumeradores do diagrama
2. Construtor com **todos** os atributos como parâmetro para: `Cliente`, `PessoaFisica`, `PessoaJuridica`
3. Métodos `get` e `set` para `Cliente`, `PessoaFisica`, `PessoaJuridica`

**Atenção:**
- `Banco` implementa `CRUD`
- `Cliente` implementa `Impressao`
- `TipoConta` tem valores inteiros (`CONTA_CORRENTE`, `POUPANCA`)
- `listaCliente` é `static List<Cliente>` dentro de `Banco`

---

### C – Sobrescrever e implementar (0.8 pts)
1. Método `toString()` em `Cliente`, `PessoaFisica`, `PessoaJuridica`
2. Método `equals()` em `Cliente`

---

### D – Inserir um Cliente (1.0 pt)
- Perguntar ao usuário: PessoaFisica ou PessoaJuridica?
- Chamar `lerDados()` da classe correta (Scanner)
- Adicionar na `listaCliente`

---

### E – Excluir um Cliente (0.7 pts)
- Solicitar a **posição** (índice da lista)
- Remover da `listaCliente`

---

### F – Listar Todos os Clientes (0.7 pts)
- Ordenar por **nome** antes de imprimir
- Imprimir com `toString()` + posição na lista

---

### G – Listar Todas as Pessoas Físicas (0.7 pts)
- Filtrar só `PessoaFisica` da `listaCliente`
- Ordenar por **agência** antes de imprimir

---

### H – Listar Todas as Pessoas Jurídicas (0.7 pts)
- Filtrar só `PessoaJuridica` da `listaCliente`
- Ordenar por **conta** antes de imprimir

---

## Checklist antes de entregar

- [ ] `Cliente` é `abstract`
- [ ] `Banco` implementa `CRUD`
- [ ] `listaCliente` é `static List<Cliente>` em `Banco`
- [ ] `lerDados()` é `static` em `PessoaFisica` e `PessoaJuridica`
- [ ] Construtor com todos atributos em Cliente/PF/PJ
- [ ] `toString()` nas 3 classes
- [ ] `equals()` em `Cliente`
- [ ] Menu infinito funcionando
- [ ] Inserir chama `lerDados()` e adiciona na lista
- [ ] Excluir usa posição (índice)
- [ ] Listar todos: ordenado por nome + posição impressa
- [ ] Listar PF: ordenado por agência
- [ ] Listar PJ: ordenado por conta
