package peao;

//Desenvolva um sistema em Java para gerenciar Peões de Rodeio e suas Montarias. Aplique os conceitos de POO
public class Main {
    public static void main(String[] args) {
        Montaria montaria = m1;
        Montaria montaria1 = m2;
        
        Peao peao1 = new Peao("CLADIANILSON", "CLEIBAMAR", Categoria.JUNIOR, new Montaria[]{m1, m2});

        Montaria[] arena = {m1, m2};
        for (Montaria m : arena) {
            m.exibirInfo();
            System.out.println("-----ARENA-----");
            System.out.println("Comportamento: " + m.comportamentoNaArena());
            System.out.println("-------");
        }

    }    

}
