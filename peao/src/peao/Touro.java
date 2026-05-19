package peao;

public class Touro extends Montaria implements Treinavel{
    public Touro(String nomeAnimal, double peso, int nivelBraveza, Modalidade modalidade){
        super(nomeAnimal, peso, nivelBraveza, modalidade);

    }
    @Override
    public String comportamentoNaArena() {
        return getNomeAnimal() + "gira, pula e tenta derrubar o peão.";
    }
    @Override
    public void treinar(){
        System.out.println(getNomeAnimal()+ " Treina força: investidas no boneco.");
    }
}