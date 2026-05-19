package peao;

public class Cavalo extends Montaria implements Treinavel{
    public Cavalo(String nomeAnimal, double peso,int nivelBraveza,Modalidade modalidade){
    super(nomeAnimal, peso, nivelBraveza, modalidade);
    }
    @Override
    public String comportamentoNaArena(){
        return getNomeAnimal() + " corcoveia e dispara em lina reta.";
    }
    @Override
    public void treinar(){
        System.out.println(getNomeAnimal()+ "Treina Velocidade: galope em circuito.");
    }
    
}