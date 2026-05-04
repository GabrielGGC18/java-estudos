public class Montaria {
    private String nomeAnimal;
    private double peso;
    private int nivelBraveza;
    private Modalidade modalidade;


    public Montaria(String nomeAnimal, double peso, int nivelBraveza, Modalidade modalidade) {
        this.nomeAnimal = nomeAnimal;
        this.peso = peso;
        this.nivelBraveza = nivelBraveza;
        this.modalidade = modalidade;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }


    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getNivelBraveza() {
        return nivelBraveza;
    }

    public void setNivelBraveza(int nivelBraveza) {
        if (nivelBraveza < 1 ||  nivelBraveza > 10){
            System.out.println("Nível Inválido (1 a 10)");
            return;
        }
        this.nivelBraveza = nivelBraveza;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public void exibirInfo(){
        System.out.println("Animal: " + nomeAnimal);
        System.out.println("Peso: "+ peso);
        System.out.println("Nivel Braveza: "+nivelBraveza);
        System.out.println("Modalidade: "+modalidade);
    }    
}