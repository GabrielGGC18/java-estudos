package com.example;

public class Main {
    public static void main(String[] args) {
        String Nome ;
        boolean idade;
        int altura; 
        
        Caneta c0 = new Caneta();
        c0.cor = "vermelho";
        c0.ponta = 0.2f;
        c0.destampar();
        c0.status();
        c0.rabiscar();

        Caneta c2 = new Caneta();
        c2.modelo = "Ferrari";
        c2.cor = "Azul";
        c2.ponta = 0.8f;

        c2.destampar();
        c2.status();
        c2.rabiscar();

    }       
}