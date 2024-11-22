/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_fp07.arena.espace;

/**
 *
 * @author RyanS
 */
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
