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
    private final List<Eventos> EventosCriados = new ArrayList<>();
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
                    vizualizarEventosPorPromotr();// Chamar método para gerenciar eventos
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
    
    private void vizualizarEventosPorPromotr(){
        if (EventosCriados.isEmpty()){
            System.out.println("Não existe eventos promovidos");
        } else {
            for (Eventos evento : EventosCriados){
                System.out.println(evento.toString()); // Exibe detalhes do evento 
            }
           
        }
    }

    private void gerenciarPromotores() {
        int opcao;
        do {
            System.out.println("\n|==  Gestão de Promotores  ==|");
            System.out.println("|    1. Listar Promotores      |");
            System.out.println("|    2. Remover Promotor       |");
            System.out.println("|    3. Editar Promotor        |");
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
                case 3:
                    editarPromotor();
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
    
    private void editarPromotor() {
    if (utilizadoresCadastrados.isEmpty()) {
        System.out.println("Não existem promotores cadastrados.");
        return;
    }

    String nome = lerString("Digite o nome do promotor a ser editado: ");
    boolean encontrado = false;

    // Procura o promotor na lista de utilizadores cadastrados
    for (Utilizador utilizador : utilizadoresCadastrados) {
        if (utilizador instanceof Promotor && utilizador.getNomeDeUtilizador().equalsIgnoreCase(nome)) {
            encontrado = true;

            // Exibir informações atuais do promotor
            System.out.println("Informações atuais do promotor:");
            System.out.println(utilizador);

            // Solicitar novas informações
            String novoNome = lerString("Digite o novo nome (ou pressione Enter para manter o mesmo): ");
            String novoEmail = lerString("Digite o novo email (ou pressione Enter para manter o mesmo): ");
            String novaSenha = lerString("Digite a nova senha (ou pressione Enter para manter a mesma): ");

            // Atualizar informações se o usuário fornecer novos dados
            if (!novoNome.isEmpty()) {
                utilizador.setNomeDeUtilizador(novoNome);
            }
            if (!novoEmail.isEmpty()) {
                utilizador.setEmail(novoEmail);
            }
            if (!novaSenha.isEmpty()) {
                utilizador.setPassword(novaSenha);
            }

            System.out.println("Promotor atualizado com sucesso!");
            break; // Sai do loop após encontrar e editar o promotor
        }
    }

    if (!encontrado) {
        System.out.println("Promotor não encontrado.");
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
    
    public enum OpcaoMenu2 {
    
    GestãoDePromotores(1),
    
    GestãoDeEventos(2),
    
    SAIR(0);
    
    
    private final int codigoMenu2;
    
    OpcaoMenu2(int codigoMenu2){
        this.codigoMenu2 = codigoMenu2;
    }
    
    public static OpcaoMenu2 getFromCodigo(int codigoMenu){
        OpcaoMenu2[] todasAsOpcoes = OpcaoMenu2.values();
        for (OpcaoMenu2 opcao : todasAsOpcoes){
            if (opcao.codigoMenu2 == codigoMenu){
                return opcao;
            }
        }
        
        return null;
        }
    }
    
    
}
