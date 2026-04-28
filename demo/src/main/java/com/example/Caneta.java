package com.example;
public class Caneta {
    private String modelo;
    private String cor;
    private float ponta;
    private int carga;
    private boolean tampada;
    
    void status() {
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Uma caneta " + this.cor);
        System.out.println("está tampada?" + this.tampada);
        System.out.println("Ponta:" + this.ponta);
        System.out.println("Carga:" + this.carga);

    }

    protected void rabiscar() {
        if ( this.tampada == true){
            System.out.println("ERRO! Não posso rabiscar rs" );
        }else{
            System.out.println("Estou Rabiscando");
        }
    }
    protected void tampar() {
        this.tampada = true;
        System.out.println("A caneta foi tampada");
    }   
    void destampar() {
        this.tampada = false;
        System.out.println("A caneta foi destampada");
    }
    public  String getModelo(){
        return this.modelo=
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public getCarga(){
       return this.carga 
    }
    public void setCarga(int carga){
        if (carga>== 0 && carga <= 100){
            this.carga = carga;
        }
    }
    public  getPonta(){
        return this.ponta 
        
    }
    public void setPonta(float ponta){
        this.ponta 
        if (ponta > 0){
            this.ponta = ponta;
        }
        
    }
    public getCor(){
        return this.cor = cor;
    }
    public void setCor(String cor){
        this.cor = cor;
        System.out.println("Qual a cor?"+ cor);
    }
    public getTampada(){
        return this.tampada 

    }
    public void setTampada(String tampada){
        this.tampada = tampada;
        System.out.println("Está Tampada?"+tampada);
    }
   }


