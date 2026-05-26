package atividade3;

public class Telefone implements Impressao {

    private String ddd;
    private int numero;

    public Telefone(String ddd, int numero){
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd(){
        return ddd;
    }
    public void setDdd(String ddd) {
        this.ddd = ddd;
        }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString(){
        return "Telefone{ddd= '"+ ddd + "', numero= " + numero +"}";
    }
    @Override
    public void imprimir() {
        System.out.println( "Telefone{"+
                "ddd='" + ddd +'\''+
                ", numero='" + numero +
                "}");

    }
}
