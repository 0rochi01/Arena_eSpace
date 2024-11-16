/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_fp07.arena.espace;


/**
 *
 * @author RyanS
 */
public class Utilizador {
    protected String NomeCompleto;
    protected String NomeDeUtilizador;
    protected String email;
    protected String password;

    public Utilizador(String NomeCompleto, String NomeDeUtilizador) {
        this.NomeCompleto = NomeCompleto;
        this.NomeDeUtilizador = NomeDeUtilizador;
    }

    public Utilizador(String NomeCompleto, String NomeDeUtilizador, String email, String password) {
        this.NomeCompleto = NomeCompleto;
        this.NomeDeUtilizador = NomeDeUtilizador;
        this.email = email;
        this.password = password;
    }

    public String getNomeCompleto() {
        return NomeCompleto;
    }

    public void setNomeCompleto(String NomeCompleto) {
        this.NomeCompleto = NomeCompleto;
    }

    public String getNomeDeUtilizador() {
        return NomeDeUtilizador;
    }

    public void setNomeDeUtilizador(String NomeDeUtilizador) {
        this.NomeDeUtilizador = NomeDeUtilizador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
