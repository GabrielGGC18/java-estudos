package peao;

//Desenvolva um sistema em Java para gerenciar Peões de Rodeio e suas Montarias. Aplique os conceitos de POO
public class Main {
    public static void main(String[] args) {
        Montaria montaria = new Touro("Touro Ferrari", 500, 8, Modalidade.TOURO);
        Montaria montaria1 = new Cavalo("Dragao Cospidor de Fogo", 100, 9, Modalidade.CAVALO_FERRARI);
        
        Peao peao1 = new Peao("CLADIANILSON", "CLEIBAMAR", Categoria.JUNIOR, new Montaria[]{montaria, montaria1});

        Montaria[] arena = {montaria, montaria1};
        for (Montaria m : arena) {
            m.exibirInfo();
            System.out.println("-----ARENA-----");
            System.out.println("Comportamento: " + m.comportamentoNaArena());
            System.out.println("---------------");
            if (m instanceof Treinavel){
                ((Treinavel)m).treinar();
            }
        }
        


    }    

}
