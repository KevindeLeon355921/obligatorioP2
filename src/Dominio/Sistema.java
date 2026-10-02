/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;

/**
 *
 * @author KEVIN
 */
public class Sistema {
     private ArrayList <String> listaDisenadores;
     public  Sistema(){
         listaDisenadores=new ArrayList<String>();
    }
     public void setDisenador(String nombre) {
        listaDisenadores.add(nombre);
    }
    public ArrayList getListaDisenadores(){
        return this.listaDisenadores;
    }
}
