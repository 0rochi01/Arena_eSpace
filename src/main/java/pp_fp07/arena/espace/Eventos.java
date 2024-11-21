package pp_fp07.arena.espace;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author RyanS
 */
public class Eventos { 
  /*Atributos da classe Eventos*/  
    protected String titulo; /*Título do Evento*/
    protected LocalDateTime dataHora; /*Data e Hora do evento*/
    protected String sala; /*Sala onde será realizado o evento*/
    //protected final Promotor Promotor; /*Promotor(do tipo Promotor) responsável pelo evento*/
    protected String modalidade;
    protected int numeroMaximoDeParticipantes;
    protected String condicoesDeInscricao;
    
    /*Construtor para criar um evento*/
    public Eventos(String titulo, LocalDateTime dataHora, String sala, String condicoesDeInscricao, String modalidade, int numeroMaximoDeParticipantes) {
        
        this.titulo = titulo; /*O construtor recebe o título do evento*/
        this.dataHora = dataHora; /*O construtor recebe a data e hora do evento*/
        this.sala = sala; /*O construtor recebe a sala do evento*/
        //this.Promotor = Promotor; /*O construtor recebe o Promotor do evento*/
        this.condicoesDeInscricao = condicoesDeInscricao;
        this.modalidade = modalidade;
        this.numeroMaximoDeParticipantes = numeroMaximoDeParticipantes;
        
    }

    Eventos(String titulo, LocalDateTime dataHora, String sala, String nomeCompleto, String email, String condicoesInscricao, String modalidade, int numeroMaximoDeParticipantes) {
        
    }

    /* Métodos para acessar e modifica os atributos da classe Eventos*/
    public String getTitulo() { /*Método para acessar o título do evento*/
        return titulo;
    }
    public void setTitulo(String titulo) { /*Método para alterar o título do evento*/
        this.titulo = titulo;
    }

    
    public LocalDateTime getDataHora() {  /*Método para acessar a data e hora do evento*/
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) { /*Método para modificiar a data e hora do evento*/
        this.dataHora = dataHora;
    }

    
    public String getSala() { /*Método para acessar a sala do evento*/
        return sala;
    }
    public void setSala(String sala) { /*Método para modificar a sala do evento*/
        this.sala = sala;
    }

    
    //public Promotor getPromotor() { /*Método para acessar o Promotor do evento*/
      //  return Promotor;
    //}

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public int getNumeroMaximoDeParticipantes() {
        return numeroMaximoDeParticipantes;
    }

    public void setNumeroMaximoDeParticipantes(int numeroMaximoDeParticipantes) {
        this.numeroMaximoDeParticipantes = numeroMaximoDeParticipantes;
    }

    public String getCondicoesDeInscricao() {
        return condicoesDeInscricao;
    }

    public void setCondicoesDeInscricao(String condicoesDeInscricao) {
        this.condicoesDeInscricao = condicoesDeInscricao;
    }
    
    
    public String toString(){ /* Método para fornecer uma representação legível do objeto 'Evento', formatando a data e hora de acordo com o padrão imposto(dd/MM/yyyy HH:mm)*/
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Evento: " + titulo + "\n" +
                "Data e Hora: " + dataHora.format(formatter) + "\n" +
                "Sala :" + sala + "\n" +
                "Modalidade :" + modalidade + "\n" +
                "Número máximo de participantes :" + numeroMaximoDeParticipantes + "\n" +
                "Condições de Inscrição :" + condicoesDeInscricao + "\n";// +
               // "-" + Promotor.toString(); /*Chama a representação legível(toString) do Promotor*/
    }
    
    
}