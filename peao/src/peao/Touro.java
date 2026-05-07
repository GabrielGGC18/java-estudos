package peao;

public class Touro extends Montaria {
    public Touro(String nomeAnimal, double peso, int nivelBraveza, Modalidade modalidade){
        super(nomeAnimal, peso, nivelBraveza, modalidade);

    }
    @Override
    public String comportamentoNaArena() {
        return getNomeAnimal() + "gira, pula e tenta derrubar o peão.";
    }
}