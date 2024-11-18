/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_fp07.arena.espace;

/**
 *
 * @author RyanS
 */
public class Promotor extends Utilizador { /* O Promotor herda da super classe Utilizador todas a caracteres */
    
    protected String Contacto; /* Mais contacto(que não tem na Classe Utilizador */

    public Promotor(String NomeCompleto, String NomeDeUtilizador, String email, String Contacto, String password) {
        super(NomeCompleto, NomeDeUtilizador, email, password);
        this.Contacto = Contacto;
    }

    public Promotor (String NomeDeUtilizador, String password){
        super(NomeDeUtilizador, password);
        this.password = password;
        this.NomeDeUtilizador = NomeDeUtilizador;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        if (Contacto.length() < 9){  /* Se o tamanho do número do telemóvel for menopr do que 9*/
            throw new RuntimeException("telemóvel inválido"); /* Aparece uma mensagem dizendo que o telemóvel é inválido */
        }
        this.Contacto = Contacto;
    }


    
}
