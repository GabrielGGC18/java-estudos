package atividade1;

import java.time.LocalDate;

public class Animal {
    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private Fazenda fazenda;

    public Animal(int id, String nome, LocalDate dataNascimento, Fazenda fazenda) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
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
    public LocalDate getDataNascimento(){
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
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
                ", dataNascimento=" + dataNascimento +
                ", fazenda=" + fazenda +
                '}';
    }
}
