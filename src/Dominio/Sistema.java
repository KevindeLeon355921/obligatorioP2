/*
 * Obligatorio 1 - Programacion 2 - Universidad ORT Uruguay
 * Autores:
 *   Francisco Puchala - Nro. de estudiante: XXXXXX
 *   Kevin de León - Nro. de estudiante: 359921
 */
package dominio;

import java.util.ArrayList;

public class Sistema {

    private ArrayList<Disenador> listaDisenadores;
    private ArrayList<Ficha> listaFichas;

    public Sistema() {
        listaDisenadores = new ArrayList<Disenador>();
        listaFichas= new ArrayList<Ficha>();
    }

    public void agregarDisenador(Disenador disenador) {
        listaDisenadores.add(disenador);
    }
    
    public ArrayList<Disenador> getListaDisenadores() {
        return this.listaDisenadores;
    }
    
    public void agregarFicha(Ficha ficha){
        listaFichas.add(ficha);
    }
    
    public ArrayList<Ficha> getListaFichas(){
        return this.listaFichas;
    }
}