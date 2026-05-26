package atividade3;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {    
        List<Pessoa> lista = new ArrayList<>();
        for (int i = 0; i < 3 ; i++ ) { 
            lista.add(lerDados());
        }
        imprimirLista(lista);

        System.out.println("--- Por Nome (Anônima) ---");
        imprimirListaOrdenadaPorNome(lista);
        
        System.out.println("--- Por idade (Anônima) ---");
        imprimirListaOrdenadaPorIdade(lista);
        
        System.out.println("--- Por sexo (Anônima) ---");
        imprimirListaOrdenadaPorSexo(lista);
        
        System.out.println("--- Por nome (lambda) ---");
        imprimirListaOrdenadaPorNomeLambda(lista);
        
        System.out.println("--- Por idade (lambda) ---");
        imprimirListaOrdenadaPorIdadeLambda(lista);
        
        System.out.println("--- Por sexo (lambda) ---");
        imprimirListaOrdenadaPorSexoLambda(lista);
        
        System.out.println("--- Só Masculino ---");
        imprimirLista(lista, Sexo.MASCULINO);
    }

    public static Pessoa lerDados() {
        Scanner sc = new Scanner(System.in);
        String nome = sc.nextLine();
        int idade = sc.nextInt();
        sc.nextLine();
        Sexo sexo = Sexo.valueOf(sc.next().toUpperCase());
        String ddd = sc.next();
        int numero = sc.nextInt();
        Telefone telefone = new Telefone(ddd, numero);

        return new Pessoa(nome, idade, sexo, telefone);
    }

    public static void imprimirLista(List<Pessoa> lista) {
        for (Pessoa p : lista ) {p.imprimir(); }
    }

    public static void imprimirLista(List<Pessoa> lista, Sexo sexo) {
        for (Pessoa p : lista ){
            if (p.getSexo() == sexo) {
                p.imprimir();
            }
        }
    }
    public static void imprimirListaOrdenadaPorNome(List<Pessoa> lista) {
        lista.sort(new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa x, Pessoa y){
                return x.getNome().compareTo(y.getNome());
            }
        });
        imprimirLista(lista);    }

    public static void imprimirListaOrdenadaPorIdade(List<Pessoa> lista) {
        lista.sort(new Comparator<Pessoa>(){
            @Override
            public int compare(Pessoa a, Pessoa b){
                return a.getIdade() - (b.getIdade());
            } 
        });
        imprimirLista(lista);        
    }

    public static void imprimirListaOrdenadaPorSexo(List<Pessoa> lista) {
        lista.sort(new Comparator<Pessoa>(){
            @Override
            public int compare(Pessoa x , Pessoa y){
                return x.getSexo().compareTo(y.getSexo());
            }   
        });
        imprimirLista(lista);

    }

    public static void imprimirListaOrdenadaPorNomeLambda(List<Pessoa> lista){
        lista.sort(((x, y) -> x.getNome().compareTo(y.getNome())));
        imprimirLista(lista);

    }
    public static void imprimirListaOrdenadaPorIdadeLambda(List<Pessoa> lista){
        lista.sort(((a, b) -> a.getIdade() - b.getIdade()));
        imprimirLista(lista);

    }
    public static void imprimirListaOrdenadaPorSexoLambda(List<Pessoa> lista){
        lista.sort((x, y)-> x.getSexo().compareTo(y.getSexo()));
        imprimirLista(lista);
    }

}