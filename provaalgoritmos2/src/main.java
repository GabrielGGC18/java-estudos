package provaalgoritmos2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class main {

    public static void main(String[] args) {

        // --- Array de clientes (polimorfismo) ---
        Cliente[] arrayClientes = {
            criarPF("Zara Lima",    "3001", "0001-1", "333.333.333-33"),
            criarPF("Ana Costa",    "1001", "0001-1", "111.111.111-11"),
            criarPJ("Tech Ltda",    "4001", "0001-1", "44.444.444/0001-44"),
            criarPF("Bruno Melo",   "2001", "0001-1", "222.222.222-22"),
            criarPJ("Alpha S/A",    "5001", "0001-1", "55.555.555/0001-55"),
        };

        System.out.println("=== Array (sem ordem) ===");
        for (Cliente c : arrayClientes) {
            c.imprimir();
        }

        Arrays.sort(arrayClientes); // usa compareTo por nome
        System.out.println("\n=== Array ordenado por nome ===");
        for (Cliente c : arrayClientes) {
            c.imprimir();
        }

        // --- List de clientes ---
        List<Cliente> listaClientes = new ArrayList<>(Arrays.asList(arrayClientes));

        // adiciona mais um fora de ordem
        PessoaJuridica nova = criarPJ("Beta Corp", "6001", "0001-1", "66.666.666/0001-66");
        listaClientes.add(nova);

        Collections.sort(listaClientes); // usa compareTo por nome
        System.out.println("\n=== List ordenada por nome ===");
        for (Cliente c : listaClientes) {
            c.imprimir();
        }

        // --- Banco gerenciando separado ---
        Banco banco = new Banco("Banco Central", "001");

        for (Cliente c : listaClientes) {
            if (c instanceof PessoaFisica) {
                banco.inserir((PessoaFisica) c);
            } else if (c instanceof PessoaJuridica) {
                banco.inserir((PessoaJuridica) c);
            }
        }

        System.out.println("\n=== Banco: " + banco.getNome() + " ===");
        banco.listarTodasPessoasFisicas();
        banco.listarTodasPessoasJuridicas();
    }

    private static PessoaFisica criarPF(String nome, String conta, String agencia, String cpf) {
        PessoaFisica pf = new PessoaFisica(nome, conta, agencia);
        pf.setCpf(cpf);
        return pf;
    }

    private static PessoaJuridica criarPJ(String nome, String conta, String agencia, String cnpj) {
        PessoaJuridica pj = new PessoaJuridica(nome, conta, agencia);
        pj.setCnpj(cnpj);
        return pj;
    }
}
