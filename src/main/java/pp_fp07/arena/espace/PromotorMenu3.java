/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_fp07.arena.espace;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author RyanS
 */
public class PromotorMenu3 {

    public PromotorMenu3(Scanner menu3) {
        this.menu3 = menu3;
    }
    
    private final Scanner menu3;
    private final List<Eventos> EventosCriados = new ArrayList<>();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    
    
    
    public void MenuPromotor() {
        System.out.println("Bem-vindo Promotor de Eventos!");
        //Adicionar funcionalidades ao promotor
    }
    
    
    
    private void vizualizarEventos
    // Método para criação de eventos 
    private void criarEventos(){
        boolean aaa=true;
        while(aaa){ // loop para permitir a criação de eventos
            System.out.println("Digite título do Evento (ou 'sair' para encerrar):"); 
            String Titulo = menu3.nextLine(); // o utilizador insere o título e o sistema lê a próxima linha
        
            if(Titulo.equalsIgnoreCase("sair")){ // Se o utilizador digitar "sair" (ou qualquer variação em maiúsculas/minúsculas), o programa informará que o usuário escolheu sair. Caso contrário, ele exibirá o título digitado.
                System.out.print("Até Logo!!"); // O sistema envia mensagem de Despedida
                break; // E encerra o loop 
            }
            
            
            System.out.println("Digite a Data e a Hora do seu evento (dd/MM/yyyy HH:MM)");
            String DataHoraInput = menu3.nextLine(); // O utilizador insere data e hora
           
            if (!DataHoraInput.matches("\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}")){ // Verificação do formato da data e hora
                System.out.println("Formato de data e hora inválido. Tente novamente.");
                continue; // // Retorna ao início do loop se a entrada for inválida 
            }
            
            LocalDateTime DataHora = LocalDateTime.parse(DataHoraInput, formatter); // Converte a entrada para LocalDateTime
            
            System.out.println("Digite a Sala do Evento");
            String Sala = menu3.nextLine(); // O utilizador insere a sala
            
            System.out.println("Escolha a modalidade do seu Evento");
            String modalidade = menu3.nextLine();
            
            System.out.println("Digite um numero máximo de participantes:");
            int numeroMaximoDeParticipantes = menu3.nextInt();
            
            System.out.println("Digite as condições para participarem do Evento");
            String condicoesInscricao = menu3.nextLine();
            
            String contacto = promotorLogado.getEmail(); // pega o contato(email) do promotor logado no sistema
            
            Eventos evento = new Eventos(Titulo, DataHora, Sala, promotorLogado);
            EventosCriados.add(evento); //adiciona evento à lista
            
            System.out.println("Evento criado com sucesso:");
            System.out.println(evento.toString()); // Chama o to String da classe Evento
            
            // Pergunta se o utilizador quer criar outro evento
            System.out.println("Deseja criar outro eventi) (s/n)");
            String resposta = menu3.nextLine();
            
            if (resposta.equalsIgnoreCase("n")){
                System.out.println("Até Logo!!");
                break; // Encerra o loop
            }
                
        } 
       
    }
    
}
