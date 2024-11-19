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
    
    SAIR(0);
    
    
    private final int OpcaoMenu3;
    
    OpcaoMenu1(int codigoOpcaoMenu3){
        this.codigoOpcaoMenu3 = codigoOpcaoMenu3;
    }
    
    public static OpcaoMenu1 getFromCodigo(int codigoMenu){
        OpcaoMenu3[] todasAsOpcoes = OpcaoMenu3.values();
        for (OpcaoMenu3 opcao : todasAsOpcoes){
            if (opcao.codigoMenu3 == codigoMenu){
                return opcao;
            }
        }
        
        return null;
    }   
}
