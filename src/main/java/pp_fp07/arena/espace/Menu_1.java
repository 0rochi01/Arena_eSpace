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
    
    
    private final Scanner menu;
    private final List<Utilizador> utilizadoresCadastrados = new ArrayList<>();  /* Eu crio uma lista de Utilizadores */

    public Menu_1(Scanner menu) {
        this.menu = menu;
    }
    
    
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

            opcao = mostrarMenuEDevolverOpcaoSelected(); /* Eu mostro o menu e devolvo a opção selecionada */
   
        }

      }
    
    private static void loginDoUtilizador(Scanner menu, List<Utilizador> utilizadorList) {
        System.out.println("Nome de Utilizador: ");
        String NomeDeUtilizador = menu.nextLine();
        
        System.out.println("Password: ");
        String password = menu.nextLine();
        
        if (utilizadorList.isEmpty()){
            System.out.println("Credenciais inválidas");
            menu.close();
            
        } else{
            System.out.println("Longin com Sucesso!!");
            ImprimeMenuArena();
        }
    }
    
    private static void ImprimeMenuArena(){
        System.out.println("|==Menu Sistema Arena-eSpace==|");
        System.out.println("|   1. Gestão de Promotores   |");   
        System.out.println("|   2. Gestão de Eventos      |");
        System.out.println("|          3.  Sair           |");
        System.out.println("|-----------------------------|");
        System.out.println("Digite a opção:"                );
    }
    
    
    private Utilizador cadastroDeUtilizador(){
        System.out.println("Digite o seu NomeCompleto: ");
            String NomeCompleto = menu.nextLine();
            
            System.out.println("Digite o seu NomeDeUtilizador: ");
            String NomeDeUtilizador = menu.nextLine();
        
            System.out.println("Digite o seu email: ");
            String email = menu.nextLine();
            
            System.out.println("Digite a sua password: ");
            String password = menu.nextLine();
           
            return new Utilizador(NomeCompleto, NomeDeUtilizador, email, password);
    }
    
    private OpcaoMenu1 mostrarMenuEDevolverOpcaoSelected(){
        imprimeMenuPrincipal();
        int opcao = menu.nextInt();
        menu.nextLine();
        return OpcaoMenu1.getFromCodigo(opcao);
    }
    
    private static void imprimeMenuPrincipal() {
        System.out.print("|==   Sistema Arena-eSpace  ==|\n");
        System.out.print("|          1. login           |\n");   
        System.out.print("|          2. Registo         |\n");
        System.out.print("|          3.  Sair           |\n");
        System.out.print("|-----------------------------|\n");
        System.out.print("Digite a opção:");
    }
        
}