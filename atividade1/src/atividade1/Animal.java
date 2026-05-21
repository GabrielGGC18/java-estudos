package atividade1;

public class Animal {
    private int id;
    private String nome;
    private Fazenda fazenda;

    public Animal(int id, String nome, Fazenda fazenda) {
        this.id = id;
        this.nome = nome;
        this.fazenda = fazenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Fazenda getFazenda() {
        return fazenda;
    }

    public void setFazenda(Fazenda fazenda) {
        this.fazenda = fazenda;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", fazenda=" + fazenda +
                '}';
    }
}
