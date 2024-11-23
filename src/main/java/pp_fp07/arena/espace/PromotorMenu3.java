/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_fp07.arena.espace;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static pp_fp07.arena.espace.Menu_1.promotorLogado;

/**
 *
 * @author RyanS
 */
public class PromotorMenu3 {
       
    public PromotorMenu3(Scanner menu3, Menu_1 menuPrincipal) {
        this.menu3 = menu3;
        this.menuPrincipal = menuPrincipal;
    }
    
    private final Menu_1 menuPrincipal;
    private final Scanner menu3;
    private final List<Eventos> EventosCriados = new ArrayList<>();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    
    
    
    
    public void executa3() {
        System.out.println("Bem-vindo Promotor de Eventos!");

        OpcaoMenu3 opcao = mostrarMenuEDevolverOpcaoSelecionada();

        do {
            switch (opcao) {
                case GERIREVENTOS:
                    OpcaoGerirEventos op; // variavel declarada
                    do {
                        op = mostrarMenuEDevolverOpcaoSetada(); //// Atualiza a opção em cada iteração
                        switch (op) {
                            case VIZUALIZARRESERVAS:
                                vizualizarReservas();
                                break;
                            case EDITARRESERVAS:
                                editarReservas();
                                break;
                            case REMOVEREVENTOS:
                                removerEvento();
                                break;
                            case MENUANTERIOR:
                                // Retorna ao menu anterior
                                break;
                            case SAIR:
                                System.out.print("\nAté Logo!!");
                                menuPrincipal.executa();
                                break;
                            default:
                                System.out.println("Opção Inválida");
                                break;
                        }
                    } while (op != OpcaoGerirEventos.MENUANTERIOR);
                    break;

                case CRIAREVENTOS:
                    criarEventos();
                    break;

                case SAIR:
                    System.out.print("\nAté Logo!!");
                    menuPrincipal.executa();
                    break;

                default:
                    System.out.println("Opção Inválida");
                    break;
            }
            opcao = mostrarMenuEDevolverOpcaoSelecionada(); // Atualiza a opção para o próximo loop
        } while (opcao != OpcaoMenu3.SAIR);
    }
    
        
    private void criarEventos() {
        boolean continuar = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        while (continuar) {
            System.out.println("Digite o título do Evento:"); 
            String titulo = menu3.nextLine();

            LocalDateTime dataHora = null;
            while (dataHora == null) {
                System.out.println("Digite a Data e a Hora do seu evento (dd/MM/yyyy HH:mm):");
                String dataHoraInput = menu3.nextLine();

                try {
                    dataHora = LocalDateTime.parse(dataHoraInput, formatter);
                } catch (DateTimeParseException e) {
                    System.out.println("Formato de data e hora inválido. Tente novamente.");
                }
            }

            System.out.println("Digite a Sala do Evento:");
            String sala = menu3.nextLine();

            System.out.println("Escolha a modalidade do seu Evento:");
            String modalidade = menu3.nextLine();

            System.out.println("Digite um número máximo de participantes:");
            int numeroMaximoDeParticipantes = menu3.nextInt();
            menu3.nextLine(); // consome a nova linha

            System.out.println("Digite as condições para participação no Evento:");
            String condicoesInscricao = menu3.nextLine();

            // Cria o evento utilizando a variável promotorLogado
            Eventos evento = new Eventos(
                titulo,
                dataHora,
                sala,
                condicoesInscricao,
                modalidade,
                numeroMaximoDeParticipantes,
                Menu_1.promotorLogado.getNomeCompleto(),
                Menu_1.promotorLogado.getEmail()
            );

            EventosCriados.add(evento);

            System.out.println("Evento criado com sucesso:");
            System.out.println(evento.toString());

            // Pergunta se deseja criar outro evento
            boolean respostaValida = false;
            while (!respostaValida) {
                System.out.println("Deseja criar outro evento? (s/n)");
                String resposta = menu3.nextLine().trim().toLowerCase();

                if (resposta.equals("s")) {
                    continuar = true; // Permite criar outro evento
                    respostaValida = true;
                } else if (resposta.equals("n")) {
                    System.out.println("Até Logo!!");
                    continuar = false; // Encerra o loop
                    respostaValida = true;
                } else {
                    System.out.println("Resposta inválida. Por favor, digite 's' para sim ou 'n' para não.");
                }
            }
        }
    }
    
    private void vizualizarReservas(){
        if (EventosCriados.isEmpty()){
            System.out.println("Não existe reservas efetuadas");
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
        String novoTitulo = solicitarEntrada("Título atual: " + eventoSelecionado.getTitulo() + 
                                            "\nDigite o novo título (ou pressione Enter para manter o atual):");
        if (!novoTitulo.isEmpty()) {
            eventoSelecionado.setTitulo(novoTitulo);
        }

        // Editar data e hora
        String novaDataHoraInput = solicitarEntrada("Data e Hora atual: " + eventoSelecionado.getDataHora().format(formatter) + 
                                                    "\nDigite a nova data e hora (dd/MM/yyyy HH:mm) ou pressione Enter para manter a atual:");
        if (!novaDataHoraInput.isEmpty()) {
            if (validarDataHora(novaDataHoraInput)) {
                try {
                    LocalDateTime novaDataHora = LocalDateTime.parse(novaDataHoraInput, formatter);
                    eventoSelecionado.setDataHora(novaDataHora);
                } catch (Exception e) {
                    System.out.println("Erro ao processar a nova data e hora. Tente novamente.");
                }
            } else {
                System.out.println("Formato de data e hora inválido. Tente novamente.");
            }
        }

        // Editar sala
        String novaSala = solicitarEntrada("Sala atual: " + eventoSelecionado.getSala() + 
                                           "\nDigite a nova sala (ou pressione Enter para manter a atual):");
        if (!novaSala.isEmpty()) {
            eventoSelecionado.setSala(novaSala);
        }

        // Exibir mensagem de sucesso
        System.out.println("Evento editado com sucesso:");
        System.out.println(eventoSelecionado.toString());
    }

    private String solicitarEntrada(String mensagem) {
        System.out.println(mensagem);
        return menu3.nextLine();
    }

    private boolean validarDataHora(String dataHoraInput) {
        return dataHoraInput.matches("\\d{2}/\\d{2}/\\d{4} \\d{2}:\\d{2}");
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
        imprimeMenuPromotor();
        int opcao = menu3.nextInt();
        menu3.nextLine();
        return OpcaoMenu3.getFromCodigo(opcao);
    }
    
    private OpcaoGerirEventos mostrarMenuEDevolverOpcaoSetada(){ /*Método criado para mostrar o menu e devolver a opção selecionada, privado e só pode ser acessado pela própria classe*/
        imprimeMenuGerirEventos();
        int opcao = menu3.nextInt();
        menu3.nextLine();
        return OpcaoGerirEventos.getFromCodigo(opcao);
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
   
    public enum Privilegio {
    
    ADMIN(1),
    PROMOTOR(2);

    private final int codigoPrivilegio;

    Privilegio(int codigoPrivilegio) {
        this.codigoPrivilegio = codigoPrivilegio;
    }

    public static Privilegio getFromCodigo(int codigoPrivilegio) {
        for (Privilegio privilegio : values()) {
            if (privilegio.codigoPrivilegio == codigoPrivilegio) {
                return privilegio;
            }
        }
        return null; // Retorna null se não encontrar
        }
    
    }
    
    public enum OpcaoMenu3 {
    GERIREVENTOS(1),
    
    CRIAREVENTOS(2),
    
    SAIR(0);
    
    
    private final int codigoMenu3;
    
        OpcaoMenu3(int codigoMenu3){
            this.codigoMenu3 = codigoMenu3;
        }

        public static OpcaoMenu3 getFromCodigo(int codigoMenu){
            OpcaoMenu3[] todasAsOpcoes = OpcaoMenu3.values();
            for (OpcaoMenu3 opcao : todasAsOpcoes){
                if (opcao.codigoMenu3 == codigoMenu){
                    return opcao;
                }
            }

            return null;
        }   
    }

    public enum OpcaoGerirEventos {
        
        VIZUALIZARRESERVAS(3),

        EDITARRESERVAS(4),

        REMOVEREVENTOS(5),

        MENUANTERIOR(6),

        SAIR(0);
    
    
    private final int codigoGerirEventos;
    
        OpcaoGerirEventos(int codigoGerirEventos){
            this.codigoGerirEventos = codigoGerirEventos;
        }

        public static OpcaoGerirEventos getFromCodigo(int codigoGerirEventos){
            OpcaoGerirEventos[] todasAsOpcoes = OpcaoGerirEventos.values();
            for (OpcaoGerirEventos opcao : todasAsOpcoes){
                if (opcao.codigoGerirEventos == codigoGerirEventos){
                    return opcao;
                }
            }

            return null;
        }   
    }
    
}