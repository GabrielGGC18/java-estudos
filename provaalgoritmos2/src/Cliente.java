package provaalgoritmos2;

import java.time.LocalDate;

public abstract class Cliente implements Impressao, Comparable<Cliente> {
    private String nome;
    private String conta;
    private String agencia;
    private LocalDate dataCadastro;

    public Cliente(String nome, String conta, String agencia) {
        this.nome = nome;
        this.conta = conta;
        this.agencia = agencia;
        this.dataCadastro = LocalDate.now();
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConta() {
        return conta;
    }

    public boolean setConta(String inserir) {
        if (inserir != null && !inserir.isBlank()) {
            this.conta = inserir;
            return true;
        }
        return false;
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

    @Override
    public int compareTo(Cliente outro) {
        return this.nome.compareToIgnoreCase(outro.nome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cliente)) return false;
        Cliente other = (Cliente) obj;
        return conta != null && conta.equals(other.conta);
    }

    @Override
    public String toString() {
        return "nome='" + nome + "', conta='" + conta + "', agencia='" + agencia + "', cadastro=" + dataCadastro;
    }
}
