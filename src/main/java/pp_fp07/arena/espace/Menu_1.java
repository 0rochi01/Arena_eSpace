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
    
    
    
    public static Promotor promotorLogado; 
    private final Scanner menu;
    private final List<Utilizador> utilizadoresCadastrados = new ArrayList<>();  /* Eu crio uma lista de UtilizadoresCadastrados */
    private PromotorMenu3 menuPromotor;
    
    public Menu_1(Scanner menu, List<Utilizador> utilizadoresCadastrados, PromotorMenu3 menuPromotor) {
        this.menu = menu;
        this.menuPromotor = menuPromotor;
    }
   
    public void executa() {
    OpcaoMenu1 opcao = mostrarMenuEDevolverOpcaoSelected();  /* Eu mostro o menu e devolvo a opção selecionada */
    
    while (opcao != OpcaoMenu1.SAIR) {  /* Enquanto a opção for diferente de SAIR, o looping continua */
        switch (opcao) {
            case OpcaoMenu1.REGISTO:
                Utilizador utilizador = cadastroDeUtilizador(); /* Eu cadastro um Utilizador */
                if (utilizador != null) { // Verifica se o cadastro foi bem-sucedido
                    utilizadoresCadastrados.add(utilizador); /* Adiciono o utilizador na Lista */
                    utilizador.imprimeDados(); /* E exibo seus dados cadastrados (exceto password). */
                }
                break;
            case OpcaoMenu1.LOGIN:
                loginDoUtilizador(menu, utilizadoresCadastrados); /* Eu faço o login do utilizador existente na lista de utilizador */
                break;
            default:
                System.out.println("Opção Inválida");
        }

        // Atualiza a opção para mostrar o menu novamente
        opcao = mostrarMenuEDevolverOpcaoSelected(); /* Eu mostro o menu e devolvo a opção selecionada */
    }

    System.out.print("\nAté Logo!!"); /* O sistema envia uma mensagem de despedida */
    menu.close(); /* E fecha o menu, encerrando atividade */
}
    
    private void loginDoUtilizador(Scanner menu, List<Utilizador> utilizadorList) {
        
        boolean continuar = true;
        
        while (continuar){
            System.out.println("Nome de Utilizador: ");
        String nomeDeUtilizador = menu.nextLine();
        
        System.out.println("Password: ");
        String password = menu.nextLine();

        // Verifica se a lista de utilizadores está vazia
        // Aqui você pode verificar se as credenciais são válidas
        if (nomeDeUtilizador.isEmpty() || password.isEmpty()) {
            System.out.println("Credenciais inválidas! Tente novamente.");
        } else {
            // Se as credenciais forem válidas, você pode parar o loop
            continuar = false; // Para sair do loop
            
        }
        
            
        // Itera sobre a lista de utilizadores
        for (Utilizador utilizador : utilizadorList) {
            if (utilizador.getNomeDeUtilizador().equals(nomeDeUtilizador) && utilizador.getPassword().equals(password)) {
                System.out.println("Login realizado com sucesso!");

                // Verifica o privilégio do utilizador
                if (utilizador.getPrivilegio().equalsIgnoreCase("admin")) {
                    // Chama o menu do admin
                    AdminMenu2 adminMenu = new AdminMenu2(menu, utilizadorList, this); 
                    adminMenu.executa2(); // Chama o menu do admin
                } else if (utilizador instanceof Promotor) {
                    Promotor promotorLogado = (Promotor) utilizador;
                    PromotorMenu3 menuPromotor = new PromotorMenu3(menu, this);
                    menuPromotor.executa3(); // Chama o menu do promotor
                } else {
                    System.out.println("O utilizador não tem privilégios adequados.");
                }
                return; // Sai do método após login bem-sucedido
            }
        }
        System.out.println("Credenciais Inválidas!");
        }
        
        
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
            
            System.out.println("Selecione um privilégio: ");
            System.out.println("1. 'admin' ");
            System.out.println("2. 'promotor' ");
            
            int opcaoPrivilegio;
            
            try {
                opcaoPrivilegio = Integer.parseInt(menu.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Opção inválida!! Digite o número da opção.");
                return null;
            }
            
            // Obtém a opção correspondente ao número digitado
            Privilegio privilegio = Privilegio.getFromCodigo(opcaoPrivilegio);
            if (privilegio == null || (privilegio != Privilegio.ADMIN && privilegio != Privilegio.PROMOTOR)){
                System.out.println("Privilégio inválido!!");
                return null;
            }
            
            Utilizador utilizador;
            if (privilegio == Privilegio.ADMIN){
                utilizador = new Utilizador(NomeCompleto, NomeDeUtilizador, email, password, privilegio.name());
            } else {
                utilizador = new Promotor(NomeCompleto, NomeDeUtilizador, email, password, privilegio.name());
            }
            // Insere o utilizador na lista
            utilizadoresCadastrados.add(utilizador);
            // Exibe os dados do utilizador
            utilizador.imprimeDados(); 
            return utilizador;
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