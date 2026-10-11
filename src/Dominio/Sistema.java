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

    public Sistema() {
        listaDisenadores = new ArrayList<Disenador>();
    }

    public void agregarDisenador(Disenador disenador) {
        listaDisenadores.add(disenador);
    }
    
    public ArrayList<Disenador> getListaDisenadores() {
        return this.listaDisenadores;
    }
}
