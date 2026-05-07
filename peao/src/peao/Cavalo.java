package peao;

public class Cavalo extends Montaria {
    public Cavalo(String nomeAnimal, double peso,int nivelBraveza,Modalidade modalidade){
    super(nomeAnimal, peso, nivelBraveza, modalidade);
    }
    @Override
    public String comportamentoNaArena(){
        return getNomeAnimal() + " corcoveia e dispara em lina reta.";
    }
    
}