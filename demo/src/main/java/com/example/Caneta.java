package com.example;
public class Caneta {
    String modelo;
    String cor;
    float ponta;
    int carga;
    boolean tampada;

    void status() {
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Uma caneta " + this.cor);
        System.out.println("está tampada?" + this.tampada);
        System.out.println("Ponta:" + this.ponta);
        System.out.println("Carga:" + this.carga);

    }

    void rabiscar() {
        if ( this.tampada == true){
            System.out.println("ERRO! Não posso rabiscar rs" );
        }else{
            System.out.println("Estou Rabiscando");
        }
    }
    void tampar() {

    }
    void destampar() {

   }

}
