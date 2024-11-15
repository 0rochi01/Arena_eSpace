/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_fp07.arena.espace;

/**
 *
 * @author RyanS
 */
public class ResponsavelEquipa extends Utilizador {
    protected String NomeDaEquipa;

    public ResponsavelEquipa(String NomeDaEquipa, String NomeCompleto, String NomeDeUtilizador, String email, String password) {
        super(NomeCompleto, NomeDeUtilizador, email, password);
        this.NomeDaEquipa = NomeDaEquipa;
    }

    public String getNomeDaEquipa() {
        return NomeDaEquipa;
    }

    public void setNomeDaEquipa(String NomeDaEquipa) {
        this.NomeDaEquipa = NomeDaEquipa;
    }

    public String getNomeDeUtilizador() {
        return NomeDeUtilizador;
    }

    public void setNomeDeUtilizador(String NomeDeUtilizador) {
        this.NomeDeUtilizador = NomeDeUtilizador;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    
    
    
    
    
}
