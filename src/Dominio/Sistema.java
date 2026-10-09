/*
 * Obligatorio 1 - Programacion 2 - Universidad ORT Uruguay
 * Autores:
 *   Francisco Puchala - Nro. de estudiante: XXXXXX
 *   NOMBRE COMPLETO COMPANERO - Nro. de estudiante: XXXXXX
 */
package dominio;

import java.util.ArrayList;

public class Sistema {

    private ArrayList<String> listaDisenadores;

    public Sistema() {
        listaDisenadores = new ArrayList<String>();
    }

    public void setDisenador(String nombre) {
        listaDisenadores.add(nombre);
    }

    public ArrayList getListaDisenadores() {
        return this.listaDisenadores;
    }
}
