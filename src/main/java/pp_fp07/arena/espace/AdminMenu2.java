/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_fp07.arena.espace;

import java.util.Scanner;
import java.time.LocalDateTime;

/**
 *
 * @author RyanS
 */
public class AdminMenu2 {

    public AdminMenu2(Scanner menu2) {
        this.menu2 = menu2;
    }
    
    private final Scanner menu2;
    
    
    

    
    
    
    public void executa(Scanner menu2) {

        
        
        
    }
    
    private static void 
            
            
    private OpcaoMenu2 mostrarMenuEDevolverOpcaoSelected(){
        imprimeMenuAdmin();
        int opcao = menu2.nextInt();
        menu2.nextLine();
        return OpcaoMenu2.getFromCodigo(opcao);
    }
    
    private static void imprimeMenuAdmin(){
        System.out.print("|==   Sistema Arena-eSpace  ==|\n");
        System.out.print("|   1. Gestão de Promotores   |\n");   
        System.out.print("|    2. Gestão de Eventos     |\n");
        System.out.print("|          3.  Sair           |\n");
        System.out.print("|-----------------------------|\n");
        System.out.print("Digite a opção:");
    }
        
        
}
