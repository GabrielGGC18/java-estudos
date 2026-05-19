package petshop;

public abstract class Animal {  
    private String nome;
    private int idade;
    private Porte porte;

    public Animal(String nome, int idade, Porte porte) {
        this.nome = nome;
        setIdade(idade);
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
        if ( idade < 0 || idade > 50 ){
            System.out.println("Idade fora do padrão estipulado ")
            return;    
        }
        this.idade = idade;  
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }
    public void apresentar(){
        System.out.println("Nome" + nome);
        System.out.println("Idade" + idade);
        System.out.println("Porte" + porte);
    }
    public abstract String emitirSom();
    
}
