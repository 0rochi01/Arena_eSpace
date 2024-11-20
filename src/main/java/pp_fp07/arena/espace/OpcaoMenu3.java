/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_fp07.arena.espace;

/**
 *
 * @author aigor
 */
public enum OpcaoMenu3 {
    GERIREVENTOS(1),
    
    CRIAREVENTOS(2),
    
    VIZUALIZARRESERVAS(3),
    
    EDITARRESERVAS(4),
    
    REMOVEREVENTOS(5),
    
    MenuAnterior(6),
    
    SAIR(0);
    
    
    private final int codigoMenu3;
    
    OpcaoMenu3(int codigoMenu3){
        this.codigoMenu3 = codigoMenu3;
    }
    
    public static OpcaoMenu3 getFromCodigo(int codigoMenu){
        OpcaoMenu3[] todasAsOpcoes = OpcaoMenu3.values();
        for (OpcaoMenu3 opcao : todasAsOpcoes){
            if (opcao.codigoMenu3 == codigoMenu){
                return opcao;
            }
        }
        
        return null;
    }   
}
