/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pp_fp07.arena.espace;

/**
 *
 * @author RyanS
 */
public enum OpcaoMenu1 {
    
    LOGIN(1),
    
    REGISTO(2),
    
    SAIR(3);
    
    
    private final int codigoMenu1;
    
    OpcaoMenu1(int codigoMenu1){
        this.codigoMenu1 = codigoMenu1;
    }
    
    public static OpcaoMenu1 getFromCodigo(int codigoMenu){
        OpcaoMenu1[] todasAsOpcoes = OpcaoMenu1.values();
        for (OpcaoMenu1 opcao : todasAsOpcoes){
            if (opcao.codigoMenu1 == codigoMenu){
                return opcao;
            }
        }
        
        return null;
    }
}
