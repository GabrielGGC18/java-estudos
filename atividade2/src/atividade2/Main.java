package atividade2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Pessoa> pessoas = new ArrayList<>();
        for (int i = 0; i < 4 ; i++){
            String nome = sc.nextLine();
            String cpf = sc.nextLine();
            String s = sc.nextLine();
            Sexo sexo = Sexo.valueOf(s);
            pessoas.add(new Pessoa(nome, cpf, sexo));
        }
        imprimirTudo(pessoas);
        pessoas.removeIf(p -> p.getSexo() == Sexo.MASCULINO);
        imprimirTudo(pessoas);
    }
    public static void imprimirTudo(List<Pessoa> lista) {
        for (Pessoa p : lista){
            System.out.println(p);
        }
    }
}
