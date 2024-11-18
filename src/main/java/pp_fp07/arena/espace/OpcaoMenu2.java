/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_fp07.arena.espace;

/**
 *
 * @author RyanS
 */
public enum OpcaoMenu2 {
    
    GestãoDePromotores(1),
    
    GestãoDeEventos(2),
    
    SAIR(3);
    
    
    private final int codigoMenu2;
    
    OpcaoMenu2(int codigoMenu2){
        this.codigoMenu2 = codigoMenu2;
    }
    
    public static OpcaoMenu2 getFromCodigo(int codigoMenu){
        OpcaoMenu2[] todasAsOpcoes = OpcaoMenu2.values();
        for (OpcaoMenu2 opcao : todasAsOpcoes){
            if (opcao.codigoMenu2 == codigoMenu){
                return opcao;
            }
        }
        
        return null;
    }
}
