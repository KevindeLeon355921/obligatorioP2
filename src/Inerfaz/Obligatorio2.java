/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Inerfaz;

import Dominio.Sistema;

/**
 *
 * @author franp
 */
public class Obligatorio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        
        sistema.setDisenador("Kevin");
        
        System.out.println(sistema.getListaDisenadores());
        
    }
    
}
