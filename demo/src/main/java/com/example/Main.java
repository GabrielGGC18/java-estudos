package com.example;

public class Main {
    public static void main(String[] args) {
        String Nome ;
        boolean idade;
        int altura; 
        
        Caneta c0 = new Caneta();
        c0.setCor("vermelho");
        c0.ponta( 0.2f);
        c0.destampar();
        c0.status();
        c0.rabiscar();

        Caneta c2 = new Caneta();
        c2.setModelo("Ferrari");
        c2.setCorcor("Azul");
        c2.setPonta(0.8f);

        c2.destampar();
        c2.status();
        c2.rabiscar();

        Caderno d0 = new Caderno();
        d0.setCor("corinthias");
        d0.setMarca("Tilibra");
        d0.setFolhas(10000);
    }       
}