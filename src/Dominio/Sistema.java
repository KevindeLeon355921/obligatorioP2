/*
 * Obligatorio 1 - Programacion 2 - Universidad ORT Uruguay
 * Autores:
 *   Francisco Puchala - Nro. de estudiante: XXXXXX
 *   NOMBRE COMPLETO COMPANERO - Nro. de estudiante: XXXXXX
 */
package dominio;

import java.util.ArrayList;

public class Sistema {

    private ArrayList<Disenador> listaDisenadores;

    public Sistema() {
        listaDisenadores = new ArrayList<Disenador>();
    }
    
    public ArrayList<Disenador> getListaDisenadores() {
        return this.listaDisenadores;
    }

    public void agregarDisenador(Disenador unDisenador){
        this.getListaDisenadores().add(unDisenador);
    }

    
}
