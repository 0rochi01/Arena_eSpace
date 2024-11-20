/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_fp07.arena.espace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author RyanS
 */
public class Menu_1 {
    
    public Menu_1(Scanner menu) {
        this.menu = menu;
    }
    
    public static Promotor promotorLogado; 
    private final Scanner menu;
    private final List<Utilizador> utilizadoresCadastrados = new ArrayList<>();  /* Eu crio uma lista de UtilizadoresCadastrados */
    
    
   
    public void executa(){
        OpcaoMenu1 opcao = mostrarMenuEDevolverOpcaoSelected();  /* Eu mostro o menu e devolvo a opção selecionada */
        
        while (opcao != OpcaoMenu1.SAIR){  /* Enquanto a opção for maior que zero e menor que três o looping é infinito */
            switch (opcao){
                case OpcaoMenu1.REGISTO:
                    Utilizador utilizador = cadastroDeUtilizador(); /* Eu cadastro um Utilizador */
                    utilizadoresCadastrados.add(utilizador); /* Adiciono o utilizador na Lista */
                    utilizador.imprimeDados(); /* E exibo seus dados cadastrados(exceto password). */
                    break;
                case OpcaoMenu1.SAIR:
                    System.out.print("\nAté Logo!!"); /* O sistema envia uma mensagem de despedida */
                    menu.close(); /* E fecha o menu, encerrando atividade */
                    break;
                case OpcaoMenu1.LOGIN:
                    loginDoUtilizador(menu, utilizadoresCadastrados); /* Eu faço o login do utilizador existente na lista de utilizador*/
                    break;
                default:
                    System.out.println("Opção Inválida");
                }

            /*opcao = mostrarMenuEDevolverOpcaoSelected(); /* Eu mostro o menu e devolvo a opção selecionada */
   
        }

      }
    
    private static void loginDoUtilizador(Scanner menu, List<Utilizador> utilizadorList) {
    // Método estático que não retorna nada, criado para login do utilizador
    System.out.println("Nome de Utilizador: ");
    String nomeDeUtilizador = menu.nextLine();
    
    System.out.println("Password: ");
    String password = menu.nextLine();

    // Verifica se a lista de utilizadores está vazia
    if (utilizadorList.isEmpty()) {
        System.out.println("Não existem utilizadores cadastrados.");
        return; // Retorna para evitar continuar o processo de login
    }

    // Itera sobre a lista de utilizadores
    for (Utilizador utilizador : utilizadorList) {
        if (utilizador.getNomeDeUtilizador().equals(nomeDeUtilizador) && utilizador.getPassword().equals(password)) {
            // Se o utilizador for um Promotor
            Promotor promotorLogado = (Promotor) utilizador; // Faz o cast para Promotor
            System.out.println("Login realizado com sucesso!");

                if (utilizador.getPrivilegio().equals("admin")) {
                    new AdminMenu2().executa(); // chama o menu do admin
                } else {
                    new PromotorMenu3().executa; // chama o menu do promotor
                }
                return; // Sai do método após login bem-sucedido
            
        } else {
                System.out.println("O utilizador não é um promotor.");
                return; // Sai do método se não for um promotor
            }
    }
    System.out.println("Credenciais Inválidas!");
} 
    
    private Utilizador cadastroDeUtilizador(){ /*Método criado para cadstrar utilizador, que só pode ser acessado pela própria classe e pelo pacote*/
        System.out.println("Digite o seu NomeCompleto: ");
            String NomeCompleto = menu.nextLine();
            
            System.out.println("Digite o seu NomeDeUtilizador: ");
            String NomeDeUtilizador = menu.nextLine();
        
            System.out.println("Digite o seu email: ");
            String email = menu.nextLine();
            
            System.out.println("Digite a sua password: ");
            String password = menu.nextLine();
            
            System.out.println("Privilegio (admin/promotor): ");
            String Privilegio = menu.nextLine();
            
            if (!Privilegio.equals("admin") && !Privilegio.equals("promotor")){
                System.out.println("Privilégio Inválido! Deve ser 'Admin' ou 'Promotor'.");
            }
            
            utilizadoresCadastrados.add(new Utilizador(NomeCompleto, NomeDeUtilizador, email, password, Privilegio));
            
            /*return new Utilizador(NomeCompleto, NomeDeUtilizador, email, password, Privilegio);*/
        return null;
    }
    
    private OpcaoMenu1 mostrarMenuEDevolverOpcaoSelected(){ /*Método criado para mostrar o menu e devolver a opção selecionada, privado e só pode ser acessado pela própria classe*/
        imprimeMenuPrincipal();
        int opcao = menu.nextInt();
        menu.nextLine();
        return OpcaoMenu1.getFromCodigo(opcao);
    }
    
    private static void imprimeMenuPrincipal() { /*Método estático que não retorna nada, criado para o sistema imprimir o menu principal, a classe não precisa ser instanciada para chamar este método*/
        System.out.print("|==   Sistema Arena-eSpace  ==|\n");
        System.out.print("|          1. login           |\n");   
        System.out.print("|          2. Registo         |\n");
        System.out.print("|          0.  Sair           |\n");
        System.out.print("|-----------------------------|\n");
        System.out.print("Digite a opção:");
    }
        
}