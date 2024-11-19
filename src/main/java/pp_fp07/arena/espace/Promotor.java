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
    
    protected String Contacto; /* Mais o atributo contacto(que não tem na Classe Utilizador */

    /*Construtor para criar um promotor*/
    public Promotor(String NomeCompleto, String NomeDeUtilizador, String email, String password, String Privilegio) {
        super(NomeCompleto, NomeDeUtilizador, email, password, Privilegio);
        //this.Contacto = Contacto; /*O construtor recebe todos os tributos da super classe, mais o atributo contacto*/
    }

 
    //*public String getContacto() { /*Método para acessar o contacto do promotor*/
     //*   return Contacto;*//
    
    
    //* public void setContacto(String Contacto) { /*Método para modificar o contacto do promotor
     /*   if (Contacto.length() < 9){  // Se o número de telemóvel do promotor ter menos do que 9 números
         /*   throw new RuntimeException("telemóvel inválido"); // Aparece uma mensagem dizendo que o "telemóvel inválido" */
        
      /*  this.Contacto = Contacto;
    } */

    public String toString(){ /*M+etodo para fornecer representação legível do objeto 'Promotor' */
        return "Promotor: " + NomeCompleto + " (Contacto: " + email + ")";
    }
    
}
