public class Animal {  
    private String nome;
    private int idade;
    private Porte porte;

    public Animal(String nome, int idade, Porte porte) {
        this.nome = nome;
        this.idade = idade;
        this.porte = porte;
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

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }
    @Override
    
}
