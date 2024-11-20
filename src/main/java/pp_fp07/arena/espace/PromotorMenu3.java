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
import static pp_fp07.arena.espace.Menu_1.promotorLogado;

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
    
    
    
    
    public void executa3() {
        System.out.println("Bem-vindo Promotor de Eventos!");
        
        OpcaoMenu3 opcao = mostrarMenuEDevolverOpcaoSelecionada();
        
        while (opcao != OpcaoMenu3.SAIR){  
            switch (opcao){
                case OpcaoMenu3.GERIREVENTOS:
                    imprimeMenuGerirEventos();
                    break;
                case OpcaoMenu3.CRIAREVENTOS:
                    criarEventos();
                    imprimeMenuPromotor();
                    break;
                case OpcaoMenu3.VIZUALIZARRESERVAS:
                    vizualizarReservas();
                    imprimeMenuGerirEventos();
                    break;
                case OpcaoMenu3.EDITARRESERVAS:
                    editarReservas();
                    imprimeMenuGerirEventos();
                    break;
                case OpcaoMenu3.REMOVEREVENTOS:
                    removerEvento();
                    imprimeMenuGerirEventos();
                    break;
                case OpcaoMenu3.MenuAnterior:
                    imprimeMenuPromotor();
                    break;
                case OpcaoMenu3.SAIR:
                    System.out.print("\nAté Logo!!"); /* O sistema envia uma mensagem de despedida */
                    menu3.close(); /* E fecha o menu, encerrando atividade */
                default:
                    System.out.println("Opção Inválida");
                }

            opcao = mostrarMenuEDevolverOpcaoSelecionada(); /* Eu mostro o menu e devolvo a opção selecionada */
   
        }
    }
    
    
    
    
            
            
    private void criarEventos(){
        boolean aaa=true;
        while(aaa){ // loop para permitir a criação de eventos
            System.out.println("Digite título do Evento (ou 'sair' para encerrar):"); 
            String titulo = menu3.nextLine(); // o utilizador insere o título e o sistema lê a próxima linha
        
            
            
            System.out.println("Digite a Data e a Hora do seu evento (dd/MM/yyyy HH:mm)");
            String dataHoraInput = menu3.nextLine(); // O utilizador insere data e hora
           
            if (!dataHoraInput.matches("\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}")){ // Verificação do formato da data e hora
                System.out.println("Formato de data e hora inválido. Tente novamente.");
                continue; // // Retorna ao início do loop se a entrada for inválida 
            }
            
            LocalDateTime dataHora = LocalDateTime.parse(dataHoraInput, formatter); // Converte a entrada para LocalDateTime
            
            System.out.println("Digite a Sala do Evento");
            String sala = menu3.nextLine(); // O utilizador insere a sala
            
            System.out.println("Escolha a modalidade do seu Evento");
            String modalidade = menu3.nextLine();
            
            System.out.println("Digite um numero máximo de participantes:");
            int numeroMaximoDeParticipantes = menu3.nextInt();
            menu3.nextLine(); // consome a nova linha
            
            System.out.println("Digite as condições para participarem do Evento");
            String condicoesInscricao = menu3.nextLine();
            
            // pega o contato(email) do promotor logado no sistema
            
            Eventos evento = new Eventos(titulo, dataHora, sala, promotorLogado.getNomeCompleto(), promotorLogado.getEmail(), condicoesInscricao, modalidade, numeroMaximoDeParticipantes);
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
    imprimeMenuGerirEventos();
    }
    
    private void removerEvento() {
    if (EventosCriados.isEmpty()) {
        System.out.println("Não existem eventos criados.");
        return;
    }

    // Exibe a lista de eventos
    System.out.println("Eventos criados:");
    for (int i = 0; i < EventosCriados.size(); i++) {
        System.out.println((i + 1) + ". " + EventosCriados.get(i).getTitulo());
    }

    // Solicita ao utilizador que selecione um evento
    System.out.println("Digite o número do evento que deseja visualizar ou apagar (ou 0 para voltar):");
    int escolha = menu3.nextInt();
    menu3.nextLine(); // Consumir o caracter de nova linha

    if (escolha == 0) {
        return; // Voltar ao menu anterior
    }

    // Verifica se a escolha é válida
    if (escolha < 0 || escolha > EventosCriados.size()) {
        System.out.println("Opção inválida.");
        return;
    }

    // Obter o evento selecionado
    Eventos eventoSelecionado = EventosCriados.get(escolha - 1);

    // Exibe os detalhes do evento
    System.out.println("\nDetalhes do evento:");
    System.out.println(eventoSelecionado.toString());

    // Solicita ao utilizador se deseja apagar o evento
    System.out.println("Deseja apagar este evento? (s/n)");
    String respostaSN = menu3.nextLine();
    Resposta resposta = Resposta.fromString(respostaSN);

    if (null == resposta) {
        System.out.println("Rsposta inválida. Por favor, insira 's' ou 'n'.");
    } else // Apaga o evento se a resposta for "s"
        switch (resposta) {
            case SIM -> {
                if (EventosCriados.contains(eventoSelecionado)){
                    EventosCriados.remove(eventoSelecionado);
                    System.out.println("Evento apagado com sucesso!");
                } else {
                    System.out.println("Evento não encontrado.");
                    
                }
        }
            case NAO -> {
                System.out.println("Operação cancelada.");
                menu3.nextLine();
        }
            default -> System.out.println("Rsposta inválida. Por favor, insira 's' ou 'n'.");
        }
    
    // mostrar lista de eventos que restam
    System.out.println("Eventos restantes: " + EventosCriados);
    imprimeMenuGerirEventos();
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
        System.out.print("|      4. Editar Reservas     |\n");
        System.out.print("|      5. Remover Eventos     |\n");
        System.out.print("|       6. Menu Anterior      |\n");
        System.out.print("|-----------------------------|\n");
        System.out.print("Digite a opção:");
    }
    
    private OpcaoMenu3 mostrarMenuEDevolverOpcaoSelecionada(){ /*Método criado para mostrar o menu e devolver a opção selecionada, privado e só pode ser acessado pela própria classe*/
        imprimeMenuGerirEventos();
        int opcao = menu3.nextInt();
        menu3.nextLine();
        return OpcaoMenu3.getFromCodigo(opcao);
    }
    
    public enum Resposta {
        SIM("s"),
        NAO("n");

        private final String valor;

        Resposta(String valor) {
            this.valor = valor;
        }

        public String getValor() {
            return valor;
        }

        public static Resposta fromString(String valor) {
            for (Resposta resposta : Resposta.values()) {
                if (resposta.getValor().equalsIgnoreCase(valor)) {
                    return resposta;
                }
            }
            return null; // Retorna null se não encontrar uma resposta válida
        }
    }
   
    
}
    


