/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pp_fp07.arena.espace;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author RyanS
 */
public class ArenaESpace {

    public static void main(String[] args) {
        
        Scanner menu = new Scanner (System.in);
        
        System.out.println("|==   Sistema Arena-eSpace  ==|");
        System.out.println("|          1. login           |");   
        System.out.println("|          2. Registo         |");
        System.out.println("|          3.  Sair           |");
        System.out.println("|-----------------------------|");
        System.out.println("Digite a opção:"                );
        
        int opcao = menu.nextInt();
        menu.nextLine();
        
        while (opcao != 0 && opcao < 3){
        if (opcao == 2){
        
            System.out.println("Digite o seu NomeCompleto: ");
            String NomeCompleto = menu.nextLine();
            
            System.out.println("Digite o seu NomeDeUtilizador: ");
            String NomeDeUtilizador = menu.nextLine();
        
            System.out.println("Digite o seu email: ");
            String email = menu.nextLine();
            
            System.out.println("Digite a sua password: ");
            String password = menu.nextLine();
           
            Utilizador utilizador = new Utilizador(NomeCompleto, NomeDeUtilizador, email, password);
            
        }
        
        else if (opcao == 1){
            System.out.println("Nome de Utilizador: ");
            String NomeDeUtilizador = menu.nextLine();
             
            System.out.println("Password: ");
            String password = menu.nextLine(); 
        }
      }  
        
        System.out.println("|==Menu Sistema Arena-eSpace==|");
        System.out.println("|   1. Gestão de Promotores   |");   
        System.out.println("|   2. Gestão de Eventos      |");
        System.out.println("|          3.  Sair           |");
        System.out.println("|-----------------------------|");
        System.out.println("Digite a opção:"                );
        
        opcao = menu.nextInt();
        menu.nextLine(); 
        
        
        
    }
}
