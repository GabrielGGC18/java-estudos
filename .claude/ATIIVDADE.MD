## ATIVIDADE DE JAVA — ONDE PARAMOS

**Data ultima sessao:** 2026-05-05

### Status Peao.java

FEITO:
- Classe `Peao` (PascalCase) renomeada
- Atributos `private`: nome, apelido, categoria, montarias[]
- Construtor 4 args (nome, apelido, categoria, montarias[])
- Getters/setters todos
- `exibirInfo()` versao completa
- `@Override toString()` retornando `"Peao{nome=..., apelido=...}"`

FALTA (proxima sessao):

1. **Construtor default** — inicializa `new Montaria[5]`:
```java
public Peao() {
    this.montarias = new Montaria[5];
}
```

2. **Construtor 3 args** chamando `this(...)`:
```java
public Peao(String nome, String apelido, Categoria categoria) {
    this(nome, apelido, categoria, new Montaria[5]);
}
```

3. **Sobrecarga `exibirInfo(boolean resumido)`**:
```java
public void exibirInfo(boolean resumido) {
    if (resumido) {
        System.out.println(nome + " (" + apelido + ")");
    } else {
        exibirInfo();
    }
}
```

4. **`equals(Object o)`** — igual se nome+apelido iguais:
```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Peao)) return false;
    Peao p = (Peao) o;
    return nome.equals(p.nome) && apelido.equals(p.apelido);
}
```

### Depois de Peao.java

Arrumar `main.java`:
- Renomear arquivo/classe `main` → `Main`
- Remover `import java.peao;` (invalido)
- L15: `List<Peao> peaos = new ArrayList<>();` (era `:` no final)
- Instanciar `Peao` e testar `exibirInfo`, `toString`, `equals`

### Proxima fase

Polimorfismo + classes abstratas / interfaces.