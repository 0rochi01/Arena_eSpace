/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pp_fp07.arena.espace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author RyanS
 */
public class ArenaESpace {
    public static void main(String[] args) {
        /*Crio o Scanner*/
        Scanner menu = new Scanner (System.in);   /* Crio o Scanner(menu) */
        
        int opcao = mostrarMenuEDevolverOpcaoSelected(menu);  /* Eu mostro o menu e devolvo a opção selecionada */
        List<Utilizador> utilizadorList = new ArrayList<>();  /* Eu crio uma lista de Utilizadores */
        
        while (opcao > 0 && opcao < 3){  /* Enquanto a opção for maior que zero e menor que três o looping é infinito */
        if (opcao == 2){  /* Se a opção for igual a 2 */
            Utilizador utilizador = cadastroDeUtilizador(menu); /* Eu cadastro um Utilizador */
            utilizadorList.add(utilizador); /* Adiciono o utilizador na Lista */
            utilizador.imprimeDados(); /* E exibo seus dados cadastrados(exceto password). */   
        }
        
        opcao = mostrarMenuEDevolverOpcaoSelected(menu); /* Eu mostro o menu e devolvo a opção selecionada */
        
        if (opcao == 3){ /* Se a opção for igual a 3 */
            System.out.print("\nAté Logo!!"); /* O sistema envia uma mensagem de despedida */
            menu.close(); /* E fecha o menu, encerrando atividade */
        }
            
        if (opcao == 1){  /* Se a opção for igual a 1 */
                loginDoUtilizador(menu, utilizadorList); /* Eu faço o login do utilizador existente na lista de utilizador*/   
        }
        else; /* Se a opção for diferente de 1, 2, e 3 */
            System.out.print("\nOpção Inválida"); /* O sistema envia uma mensagem de opção inválida */
            imprimeMenuPrincipal(); /* E retorna para o menu prncipal */
      }  

        ImprimeMenuArena(); /* E Mostro o menu Sistema Arena-eSpace */
        
        
    }
    
    
    private static void ImprimeMenuArena(){
        System.out.println("|==Menu Sistema Arena-eSpace==|");
        System.out.println("|   1. Gestão de Promotores   |");   
        System.out.println("|   2. Gestão de Eventos      |");
        System.out.println("|          3.  Sair           |");
        System.out.println("|-----------------------------|");
        System.out.println("Digite a opção:"                );
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
            menu.close();
        }
    }
    
    private static Utilizador cadastroDeUtilizador(Scanner menu){
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
    
    private static int mostrarMenuEDevolverOpcaoSelected(Scanner menu){
        imprimeMenuPrincipal();
        int opcao = menu.nextInt();
        menu.nextLine();
        return opcao;
    }

    private static void imprimeMenuPrincipal() {
        System.out.print("|==   Sistema Arena-eSpace  ==|\n");
        System.out.print("|          1. login           |\n");   
        System.out.print("|          2. Registo         |\n");
        System.out.print("|          3.  Sair           |\n");
        System.out.print("|-----------------------------|\n");
        System.out.print("Digite a opção:"                  );
    }




}
