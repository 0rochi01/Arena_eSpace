/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_fp07.arena.espace;

/**
 *
 * @author RyanS
 */
public class Promotor extends Utilizador { 
    
   

    /*Construtor para criar um promotor*/
    public Promotor(String NomeCompleto, String NomeDeUtilizador, String email, String password, String Privilegio) {
        super(NomeCompleto, NomeDeUtilizador, email, password, Privilegio);
    }


    public String toString(){ /*Método para fornecer representação legível do objeto 'Promotor' */
        return "Promotor: " + NomeCompleto + " (Contacto: " + email + ")";
    }
    
}
