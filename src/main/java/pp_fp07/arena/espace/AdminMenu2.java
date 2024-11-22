/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_fp07.arena.espace;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AdminMenu2 {

    private final Scanner menu2;
    private final List<Utilizador> utilizadoresCadastrados; // Lista de utilizadores cadastrados
    private final Menu_1 menuPrincipal;
    public AdminMenu2(Scanner menu2, List<Utilizador> utilizadoresCadastrados, Menu_1 menuPrincipal) {
        this.menu2 = menu2;
        this.utilizadoresCadastrados = utilizadoresCadastrados; // Inicializa a lista de utilizadores
        this.menuPrincipal = menuPrincipal; // Inicializa a referencia ao Menu_1
    }

    public void executa2() {
        System.out.println("Bem-vindo Administrador!");
        
        OpcaoMenu2 opcao;
        do {
            opcao = mostrarMenuEDevolverOpcaoSelected();
            switch (opcao) {
                case GestãoDePromotores:
                    gerenciarPromotores();
                    break;
                case GestãoDeEventos:
                    // Chamar método para gerenciar eventos
                    break;
                case SAIR:
                    System.out.println("Saindo do menu.");
                    menuPrincipal.executa();
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != OpcaoMenu2.SAIR);
    }

    private void gerenciarPromotores() {
        int opcao;
        do {
            System.out.println("\n|==   Gestão de Promotores   ==|");
            System.out.println("|    1. Listar Promotores      |");
            System.out.println("|    2. Remover Promotor       |");
            System.out.println("|    0. Voltar                 |");
            System.out.print("|------------------------------|\n");
            opcao = lerInteiro("Digite a opção: ");

            switch (opcao) {
                case 1:
                    listarPromotores();
                    break;
                case 2:
                    removerPromotor();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal.");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 0);
    }

    private void listarPromotores() {
        if (utilizadoresCadastrados.isEmpty()) {
            System.out.println("Não existem promotores cadastrados.");
        } else {
            System.out.println("Lista de Promotores:");
            for (Utilizador utilizador : utilizadoresCadastrados) {
                System.out.println(utilizador);
            }
        }
    }

    private void removerPromotor() {
        if(utilizadoresCadastrados.isEmpty()){
            System.out.println("Não existe promotores cadstrados.");
        } else {
            String nome = lerString("Digite o nome do promotor a ser removido: ");
        boolean encontrado = false;

        // Verifica se o promotor está na lista de utilizadores cadastrados
        for (int i = 0; i < utilizadoresCadastrados.size(); i++) {
            if (utilizadoresCadastrados.get(i).toString().contains(nome)) {
                utilizadoresCadastrados.remove(i);
                System.out.println("Promotor removido com sucesso!");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Promotor não encontrado.");
            }
        }
        
    }

    private OpcaoMenu2 mostrarMenuEDevolverOpcaoSelected() {
        imprimeMenuAdmin();
        int opcao = menu2.nextInt();
        menu2.nextLine();
        return OpcaoMenu2.getFromCodigo(opcao);
    }

    private static void imprimeMenuAdmin() {
        System.out.print("|==   Sistema Arena-eSpace  ==|\n");
        System.out.print("|   1. Gestão de Promotores   |\n");
        System.out.print("|    2. Gestão de Eventos     |\n");
        System.out.print("|          0.  Sair           |\n");
        System.out.print("|-----------------------------|\n");
        System.out.print("Digite a opção:");
    }

    private int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        while (true) {
            try {
                return Integer.parseInt(menu2.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. " + mensagem);
            }
        }
    }

    private String lerString(String mensagem) {
        System.out.print(mensagem);
        return menu2.nextLine();
    }
}
