package atividade3;

public class Pessoa implements Impressao {
    private String nome;
    private int idade;
    private Sexo sexo;
    private Telefone telefone; 

    public Pessoa(String nome, int idade, Sexo sexo, Telefone telefone){
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.telefone = telefone;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString(){
        return "Pessoa{nome='" + nome + "', idade=" + idade + ", sexo=" + sexo + ", telefone='" + telefone + "}";
    }

    @Override
    public void imprimir() {
        System.out.println("Nome: " + nome + ", idade: " + idade + ", sexo: " + sexo + ", telefone: " + telefone);
                

        
    }
}
