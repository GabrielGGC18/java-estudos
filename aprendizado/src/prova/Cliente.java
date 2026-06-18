package prova;

// =========================================================
// IMPORTAÇÕES
// =========================================================
// import = diz ao Java onde encontrar classes de outras
//          bibliotecas que você vai usar neste arquivo.
//
// LocalDate está no pacote java.time — não vem automático,
// precisa importar explicitamente.
// =========================================================
import java.time.LocalDate;

// =========================================================
// CLASSE ABSTRATA — Cliente
// =========================================================
// O que é abstract?
//   - Classe que NÃO pode ser instanciada diretamente.
//   - Ou seja: new Cliente() → ERRO DE COMPILAÇÃO.
//   - Serve de BASE para PessoaFisica e PessoaJuridica.
//   - Agrupa atributos e comportamentos COMUNS a ambas.
//
// implements Impressao
//   → Cliente assina o contrato da interface Impressao.
//   → É obrigado a ter getNome() e imprimir().
//   → Como Cliente é abstract, pode deixar imprimir()
//     para as subclasses implementarem.
//
// implements Comparable<Cliente>
//   → Permite comparar dois Clientes (para ordenação).
//   → Obriga a ter o método compareTo().
//   → Collections.sort() usa compareTo() internamente.
//
// HERANÇA:
//   PessoaFisica extends Cliente
//   PessoaJuridica extends Cliente
//   → "é um" → PessoaFisica É UM Cliente. Faz sentido.
// =========================================================

public abstract class Cliente implements Impressao, Comparable<Cliente> {

    // =====================================================
    // ENCAPSULAMENTO — atributos privados
    // =====================================================
    // private = só esta classe acessa diretamente.
    // Fora da classe, obrigatório usar getters/setters.
    // Por que? Protege os dados. Você controla o acesso.
    // =====================================================
    private String nome;
    private String conta;
    private String agencia;
    private LocalDate dataCadastro; // data automática do cadastro

    // =====================================================
    // CONSTRUTOR
    // =====================================================
    // Construtor = método especial chamado no "new".
    // Nome IGUAL ao da classe, sem tipo de retorno.
    // this.nome = nome → atribui o parâmetro ao atributo.
    // "this" = referência ao objeto atual.
    //
    // dataCadastro não é parâmetro — é automático (hoje).
    // =====================================================
    public Cliente(String nome, String conta, String agencia) {
        this.nome = nome;
        this.conta = conta;
        this.agencia = agencia;
        this.dataCadastro = LocalDate.now(); // pega data de hoje automaticamente
    }

    // =====================================================
    // GETTERS E SETTERS — Encapsulamento em ação
    // =====================================================
    // getter = retorna o valor do atributo privado
    // setter = altera o valor com validação opcional
    //
    // @Override em getNome():
    //   A interface Impressao declara getNome().
    //   Esta classe está IMPLEMENTANDO esse método.
    //   @Override avisa o compilador: "estou sobrescrevendo".
    //   Se errar o nome, compilador avisa.
    // =====================================================

    @Override // implementando método da interface Impressao
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConta() {
        return conta;
    }

    // setter com validação — retorna boolean indicando sucesso
    public boolean setConta(String inserir) {
        if (inserir != null && !inserir.isBlank()) {
            this.conta = inserir;
            return true;
        }
        return false; // não alterou — valor inválido
    }

    public String getAgencia() {
        return agencia;
    }

    public boolean setAgencia(String agencia) {
        if (agencia != null && !agencia.isBlank()) {
            this.agencia = agencia;
            return true;
        }
        return false;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    // =====================================================
    // compareTo() — necessário para ordenação
    // =====================================================
    // Vem do Comparable<Cliente> que implementamos.
    // Collections.sort(lista) chama este método.
    // Retorno:
    //   negativo → this vem ANTES de outro
    //   zero     → iguais
    //   positivo → this vem DEPOIS de outro
    //
    // compareToIgnoreCase = ignora maiúsculo/minúsculo
    // =====================================================
    @Override
    public int compareTo(Cliente outro) {
        return this.nome.compareToIgnoreCase(outro.nome);
    }

    // =====================================================
    // equals() — comparação de igualdade
    // =====================================================
    // Java usa equals() para comparar objetos (não ==).
    // == compara referência de memória, não conteúdo.
    // Aqui: dois clientes são iguais se têm mesma conta.
    //
    // Padrão de implementação:
    //   1. this == obj → mesmo objeto na memória? igual.
    //   2. instanceof → é do tipo certo? se não, diferente.
    //   3. cast → converte para acessar atributos.
    //   4. compara o campo identificador.
    // =====================================================
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;                    // mesma referência
        if (!(obj instanceof Cliente)) return false;     // tipo errado
        Cliente other = (Cliente) obj;                   // cast seguro
        return conta != null && conta.equals(other.conta); // compara conta
    }

    // =====================================================
    // toString() — representação textual do objeto
    // =====================================================
    // Chamado automaticamente em System.out.println(obj).
    // Subclasses vão chamar super.toString() para reusar.
    // =====================================================
    @Override
    public String toString() {
        return "nome='" + nome + "', conta='" + conta +
               "', agencia='" + agencia + "', cadastro=" + dataCadastro;
    }
}
