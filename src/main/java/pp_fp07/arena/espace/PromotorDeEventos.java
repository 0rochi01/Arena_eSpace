/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_fp07.arena.espace;

/**
 *
 * @author RyanS
 */
public class PromotorDeEventos extends Utilizador {
    
    protected int Contacto;

    public PromotorDeEventos(String NomeCompleto, String NomeDeUtilizador, String email, int Contacto, String password) {
        super(NomeCompleto, NomeDeUtilizador, email, password);
        this.Contacto = Contacto;
    }

    public PromotorDeEventos (String NomeDeUtilizador, String password){
        super(NomeDeUtilizador, password);
        this.password = password;
        this.NomeDeUtilizador = NomeDeUtilizador;
    }

    public int getContacto() {
        return Contacto;
    }

    public void setContacto(int Contacto) {
        this.Contacto = Contacto;
    }

    @Override
    public String getNomeDeUtilizador() {
        return NomeDeUtilizador;
    }

    @Override
    public void setNomeDeUtilizador(String NomeDeUtilizador) {
        this.NomeDeUtilizador = NomeDeUtilizador;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }


    
}
