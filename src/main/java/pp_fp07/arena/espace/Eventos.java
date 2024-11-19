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
    private String Titulo; /*Título do Evento*/
    private LocalDateTime DataHora; /*Data e Hora do evento*/
    private String Sala; /*Sala onde será realizado o evento*/
    private final Promotor Promotor; /*Promotor(do tipo Promotor) responsável pelo evento*/
    private String modalidade;
    private int numeroMaximoDeParticipantes;
    
    /*Construtor para criar um evento*/
    public Eventos(String Titulo, LocalDateTime DataHora, String Sala, Promotor Promotor) {
        this.Titulo = Titulo; /*O construtor recebe o título do evento*/
        this.DataHora = DataHora; /*O construtor recebe a data e hora do evento*/
        this.Sala = Sala; /*O construtor recebe a sala do evento*/
        this.Promotor = Promotor; /*O construtor recebe o Promotor do evento*/
    }

    /* Métodos para acessar e modifica os atributos da classe Eventos*/
    public String getTitulo() { /*Método para acessar o título do evento*/
        return Titulo;
    }
    public void setTitulo(String Titulo) { /*Método para alterar o título do evento*/
        this.Titulo = Titulo;
    }

    
    public LocalDateTime getDataHora() {  /*Método para acessar a data e hora do evento*/
        return DataHora;
    }
    public void setDataHora(LocalDateTime DataHora) { /*Método para modificiar a data e hora do evento*/
        this.DataHora = DataHora;
    }

    
    public String getSala() { /*Método para acessar a sala do evento*/
        return Sala;
    }
    public void setSala(String Sala) { /*Método para modificar a sala do evento*/
        this.Sala = Sala;
    }

    
    public Promotor getPromotor() { /*Método para acessar o Promotor do evento*/
        return Promotor;
    }
    
    
    public String toString(){ /* Método para fornecer uma representação legível do objeto 'Evento', formatando a data e hora de acordo com o padrão imposto(dd/MM/yyyy HH:mm)*/
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Evento: " + Titulo + "\n" +
                "Data e Hora: " + DataHora.format(formatter) + "\n" +
                "Sala :" + Sala + "\n" +
                "Promotor: " + Promotor.toString(); /*Chama a representação legível(toString) do Promotor*/
    }
    
    
}
