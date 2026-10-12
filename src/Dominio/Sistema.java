/*
 * Obligatorio 1 - Programacion 2 - Universidad ORT Uruguay
 * Autores:
 *   Francisco Puchala - Nro. de estudiante: XXXXXX
 *   Kevin de León - Nro. de estudiante: 359921
 */
package dominio;

import java.util.ArrayList;

public class Sistema {

    private ArrayList<Diseñador> listaDiseñadores;
    private ArrayList<Ficha> listaFichas;

    public Sistema() {
        listaDiseñadores = new ArrayList<Diseñador>();
        listaFichas= new ArrayList<Ficha>();
    }

    public void agregarDiseñador(Diseñador disenador) {
        listaDiseñadores.add(disenador);
    }
    
    public ArrayList<Diseñador> getListaDiseñadores() {
        return this.listaDiseñadores;
    }
    
    public void agregarFicha(Ficha ficha){
        listaFichas.add(ficha);
    }
    
    public ArrayList<Ficha> getListaFichas(){
        return this.listaFichas;
    }
}