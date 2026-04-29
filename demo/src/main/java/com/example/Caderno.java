package com.example;

public class Caderno {
    private String cor;
    private String tipo;
    private String marca;
    private int folhas;
    private boolean aberto;

    void status() {
        System.out.println("Cor: " + this.cor);
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Marca: " + this.marca);
        System.out.println("Folhas: " + this.folhas);
        System.out.println("Aberto: " + this.aberto);
    }

    void abrir() {
        if (this.aberto == true) {
            System.out.println("ERRO! O caderno já está aberto.");
        } else {
            this.aberto = true;
            System.out.println("O caderno foi aberto.");
        }
    }

    void fechar() {
        if (this.aberto == false) {
            System.out.println("ERRO! O caderno já está fechado.");
        } else {
            this.aberto = false;
            System.out.println("O caderno foi fechado.");
        }
    }

    void escrever() {
        if (this.aberto == false) {
            System.out.println("ERRO! Não posso escrever com o caderno fechado.");
        } else {
            System.out.println("Estou escrevendo no caderno.");
        }
    }
    public getAbrir(){
        return this.aberto;

    }
    public setAbrir(String aberto){
        this.aberto = aberto;
        if{
            System.out.println("Caderno aberto"+aberto);
        } 
    }
    
}
