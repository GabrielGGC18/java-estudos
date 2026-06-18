package prova;

// =========================================================
// IMPORTAÇÕES do Main
// =========================================================
// ArrayList e List → para criar listas temporárias de filtro
// Collections → para Collections.sort()
// Scanner → para ler entrada do teclado
// =========================================================
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// =========================================================
// CLASSE Main — ponto de entrada do programa
// =========================================================
// Todo programa Java começa pelo método main().
// Assinatura obrigatória: public static void main(String[] args)
//   public  = acessível de qualquer lugar
//   static  = chamado pela JVM sem criar objeto de Main
//   void    = não retorna nada
//   String[] args = argumentos de linha de comando (não usamos)
// =========================================================

public class Main {

    public static void main(String[] args) {

        // =====================================================
        // Scanner — leitura do teclado
        // =====================================================
        // new Scanner(System.in) = conecta Scanner ao teclado.
        // Uma única instância para toda a sessão.
        // IMPORTANTE: não crie Scanner novo dentro do loop —
        //   cada lerDados() cria o seu próprio internamente,
        //   mas o Scanner principal fica aqui.
        // =====================================================
        Scanner sc = new Scanner(System.in);

        // =====================================================
        // MENU INFINITO — while(true)
        // =====================================================
        // while(true) = loop eterno. Só para com:
        //   return → sai do método main() inteiro
        //   break  → sai só do switch (NÃO do while!)
        //   System.exit(0) → encerra JVM
        //
        // Fluxo:
        //   1. Mostra menu
        //   2. Lê opção
        //   3. Executa ação no switch
        //   4. Volta ao início (repete)
        // =====================================================
        while (true) {

            // Mostra opções ao usuário
            System.out.println("\n========== BANCO ==========");
            System.out.println("1. Inserir Cliente");
            System.out.println("2. Excluir Cliente");
            System.out.println("3. Listar Todos os Clientes");
            System.out.println("4. Listar Pessoas Físicas");
            System.out.println("5. Listar Pessoas Jurídicas");
            System.out.println("6. Sair");
            System.out.print("Opção: ");

            // sc.nextInt() = lê número inteiro digitado
            int opcao = sc.nextInt();

            // =====================================================
            // ARMADILHA DO SCANNER — nextInt() + nextLine()
            // =====================================================
            // nextInt() lê o número mas DEIXA o "\n" (Enter)
            // no buffer. Se o próximo read for nextLine(),
            // ele vai ler esse "\n" vazio e pular a pergunta.
            // Solução: sempre chamar sc.nextLine() depois de
            // nextInt() para "limpar" o Enter do buffer.
            // =====================================================
            sc.nextLine(); // limpa o Enter do buffer

            // =====================================================
            // switch(opcao) — executa ação conforme escolha
            // =====================================================
            // switch avalia opcao e pula direto para o case.
            // break; = sai do switch e volta ao while.
            // Sem break → "fall-through": executa próximo case!
            // default → executado se nenhum case bater.
            // =====================================================
            switch (opcao) {

                // =================================================
                // CASE 1 — Inserir Cliente
                // =================================================
                // POLIMORFISMO AQUI:
                //   Pergunta PF ou PJ, chama lerDados() estático
                //   da classe correta, adiciona em listaCliente
                //   (que é List<Cliente> — aceita ambos!).
                //
                // PessoaFisica.lerDados() = método static,
                //   chamado na CLASSE, não em objeto.
                //   Retorna um objeto PessoaFisica novo.
                //
                // Banco.listaCliente.add(pf):
                //   listaCliente é static em Banco.
                //   Acesso: NomeClasse.atributoStatic
                //   PessoaFisica é aceita porque extends Cliente.
                // =================================================
                case 1:
                    System.out.println("1 - Pessoa Física  |  2 - Pessoa Jurídica");
                    int tipo = sc.nextInt();
                    sc.nextLine(); // limpa buffer novamente!

                    if (tipo == 1) {
                        // lerDados() static — chama na classe, retorna PF
                        PessoaFisica pf = PessoaFisica.lerDados();
                        Banco.listaCliente.add(pf); // polimorfismo: PF -> Cliente
                    } else {
                        // lerDados() static — chama na classe, retorna PJ
                        PessoaJuridica pj = PessoaJuridica.lerDados();
                        Banco.listaCliente.add(pj); // polimorfismo: PJ -> Cliente
                    }
                    break; // sai do switch, volta ao while

                // =================================================
                // CASE 2 — Excluir Cliente por posição
                // =================================================
                // remove(int) da List remove pelo índice.
                // Índices começam em 0.
                //   lista: [Ana(0), Bruno(1), Carla(2)]
                //   remove(1) → remove Bruno
                //   lista fica: [Ana(0), Carla(1)]
                // =================================================
                case 2:
                    System.out.print("Posição para excluir: ");
                    int posicao = sc.nextInt();
                    sc.nextLine(); // limpa buffer
                    Banco.listaCliente.remove(posicao);
                    System.out.println("Cliente removido.");
                    break;

                // =================================================
                // CASE 3 — Listar Todos os Clientes
                // =================================================
                // Collections.sort() usa compareTo() de Cliente
                // que ordenamos por nome.
                // for com índice → mostra posição + dados.
                // .imprimir() → POLIMORFISMO:
                //   Se objeto for PF → chama imprimir() de PF
                //   Se objeto for PJ → chama imprimir() de PJ
                //   Java decide em TEMPO DE EXECUÇÃO (dynamic dispatch)
                // =================================================
                case 3:
                    System.out.println("--- Todos os Clientes (por nome) ---");
                    Collections.sort(Banco.listaCliente); // ordena por nome
                    for (int i = 0; i < Banco.listaCliente.size(); i++) {
                        System.out.print("Posição " + i + ": ");
                        Banco.listaCliente.get(i).imprimir(); // polimorfismo!
                    }
                    break;

                // =================================================
                // CASE 4 — Listar Pessoas Físicas
                // =================================================
                // 1. Cria lista temporária de PF
                // 2. Percorre listaCliente com for-each
                // 3. instanceof verifica tipo real do objeto
                //    (mesmo declarado como Cliente, o tipo real
                //     pode ser PessoaFisica — polimorfismo)
                // 4. Cast (PessoaFisica) c → converte para acessar
                //    métodos específicos de PF (getCpf, getAgencia etc)
                // 5. Lambda ordena por agência
                //    (a, b) -> comparação entre dois elementos
                // =================================================
                case 4:
                    System.out.println("--- Pessoas Físicas (por agência) ---");

                    // Lista temporária só com PF
                    List<PessoaFisica> listaPF = new ArrayList<>();

                    for (Cliente c : Banco.listaCliente) {
                        // instanceof = verifica tipo real em tempo de execução
                        if (c instanceof PessoaFisica) {
                            // cast necessário: variável c é Cliente,
                            // mas precisamos de PessoaFisica para add na listaPF
                            listaPF.add((PessoaFisica) c);
                        }
                    }

                    // Lambda: ordena por agência
                    // (a, b) -> a.getAgencia().compareTo(b.getAgencia())
                    //   a e b são dois PessoaFisica da lista
                    //   compareTo retorna negativo/zero/positivo
                    //   sort usa esse resultado para ordenar
                    listaPF.sort((a, b) -> a.getAgencia().compareTo(b.getAgencia()));

                    for (PessoaFisica pf : listaPF) {
                        pf.imprimir();
                    }
                    break;

                // =================================================
                // CASE 5 — Listar Pessoas Jurídicas
                // =================================================
                // Mesmo padrão do case 4, mas:
                //   - filtra PessoaJuridica
                //   - ordena por conta (não agência)
                // =================================================
                case 5:
                    System.out.println("--- Pessoas Jurídicas (por conta) ---");

                    List<PessoaJuridica> listaPJ = new ArrayList<>();

                    for (Cliente c : Banco.listaCliente) {
                        if (c instanceof PessoaJuridica) {
                            listaPJ.add((PessoaJuridica) c); // cast: Cliente → PJ
                        }
                    }

                    // Ordena por conta
                    listaPJ.sort((a, b) -> a.getConta().compareTo(b.getConta()));

                    for (PessoaJuridica pj : listaPJ) {
                        pj.imprimir();
                    }
                    break;

                // =================================================
                // CASE 6 — Sair
                // =================================================
                // sc.close() = fecha o Scanner (boa prática).
                // return = SAI DO main(). Encerra o programa.
                //
                // NÃO use break aqui — break sai do switch
                // mas while(true) continua rodando!
                // return encerra o método main() → JVM para.
                // =================================================
                case 6:
                    System.out.println("Encerrando sistema...");
                    sc.close();
                    return; // encerra main() → programa termina

                // =================================================
                // default — opção inválida
                // =================================================
                // Executado se nenhum case bater (ex: usuário digita 9)
                // =================================================
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
