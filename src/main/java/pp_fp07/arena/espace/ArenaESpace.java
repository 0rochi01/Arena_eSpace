/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pp_fp07.arena.espace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author RyanS
 */
public class ArenaESpace {
    public static void main(String[] args) {
        /*Crio o Scanner*/
        Scanner menu = new Scanner (System.in);   /* Crio o Scanner(menu) */
        Menu_1 menu1 = new Menu_1(menu);
        
        menu1.executa();
        
    }
   
}
