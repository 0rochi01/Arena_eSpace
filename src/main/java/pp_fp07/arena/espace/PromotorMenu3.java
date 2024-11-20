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
    
    
    
    
            
            
    private void criarEventos(){
        boolean aaa=true;
        while(aaa){ // loop para permitir a criação de eventos
            System.out.println("Digite título do Evento (ou 'sair' para encerrar):"); 
            String Titulo = menu3.nextLine(); // o utilizador insere o título e o sistema lê a próxima linha
        
            
            
            System.out.println("Digite a Data e a Hora do seu evento (dd/MM/yyyy HH:mm)");
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
            menu3.nextLine(); // consome a nova linha
            
            System.out.println("Digite as condições para participarem do Evento");
            String condicoesInscricao = menu3.nextLine();
            
            String contacto = promotorLogado.getEmail(); // pega o contato(email) do promotor logado no sistema
            
            Eventos evento = new Eventos(Titulo, DataHora, Sala, promotorLogado, condicoesInscricao, modalidade, numeroMaximoDeParticipantes);
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
    
    private void vizualizarReservas(){
        if (EventosCriados.isEmpty()){
            System.out.println("Não existe reservas cadastradas");
        } else {
            for (Eventos evento : EventosCriados){
                System.out.println(evento.toString()); // Exibe detalhes do evento 
            }
           
        }
    }
    
    private void editarReservas() {
    if (EventosCriados.isEmpty()) {
        System.out.println("Não existem eventos cadastrados para editar.");
        return;
    }

    // Exibir eventos existentes
    System.out.println("Eventos cadastrados:");
    for (int i = 0; i < EventosCriados.size(); i++) {
        Eventos evento = EventosCriados.get(i);
        System.out.println((i + 1) + ". " + evento.toString());
    }

    // Solicitar ao usuário para escolher um evento para editar
    System.out.println("Digite o número do evento que deseja editar:");
    int eventoIndex = menu3.nextInt() - 1; // Ajusta para índice zero
    menu3.nextLine(); // Consumir a nova linha

    if (eventoIndex < 0 || eventoIndex >= EventosCriados.size()) {
        System.out.println("Número de evento inválido. Tente novamente.");
        return;
    }

    Eventos eventoSelecionado = EventosCriados.get(eventoIndex);

    // Editar título
    System.out.println("Título atual: " + eventoSelecionado.getTitulo());
    System.out.println("Digite o novo título (ou pressione Enter para manter o atual):");
    String novoTitulo = menu3.nextLine();
    if (!novoTitulo.isEmpty()) {
        eventoSelecionado.setTitulo(novoTitulo);
    }

    // Editar data e hora
    System.out.println("Data e Hora atual: " + eventoSelecionado.getDataHora().format(formatter));
    System.out.println("Digite a nova data e hora (dd/MM/yyyy HH:mm) ou pressione Enter para manter a atual:");
    String novaDataHoraInput = menu3.nextLine();
    if (!novaDataHoraInput.isEmpty()) {
        if (!novaDataHoraInput.matches("\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}")) {
            System.out.println("Formato de data e hora inválido. Tente novamente.");
        } else {
            try {
                LocalDateTime novaDataHora = LocalDateTime.parse(novaDataHoraInput, formatter);
                eventoSelecionado.setDataHora(novaDataHora);
            } catch (Exception e) {
                System.out.println("Erro ao processar a nova data e hora. Tente novamente.");
            }
        }
    }

    // Editar sala
    System.out.println("Sala atual: " + eventoSelecionado.getSala());
    System.out.println("Digite a nova sala (ou pressione Enter para manter a atual):");
    String novaSala = menu3.nextLine();
    if (!novaSala.isEmpty()) {
        eventoSelecionado.setSala(novaSala);
    }

    // Exibir mensagem de sucesso
    System.out.println("Evento editado com sucesso:");
    System.out.println(eventoSelecionado.toString());
    
    }
    
    private static void imprimeMenuPromotor(){
        System.out.print("|==   Sistema Arena-eSpace  ==|\n");
        System.out.print("|       1. Gerir Eventos      |\n");   
        System.out.print("|       2. Criar Eventos      |\n");
        System.out.print("|          0.  Sair           |\n");
        System.out.print("|-----------------------------|\n");
        System.out.print("Digite a opção:");
    }
    
    
    
    private static void imprimeMenuGerirEventos(){
        System.out.print("|==   Sistema Arena-eSpace  ==|\n");
        System.out.print("|    3. Vizualizar Reservas   |\n");   
        System.out.print("|    4. Editar Reservas       |\n");
        System.out.print("|    5. Remover Eventos       |\n");
        System.out.print("|          0.  Sair           |\n");
        System.out.print("|-----------------------------|\n");
        System.out.print("Digite a opção:");
    }
   
    
}
    


