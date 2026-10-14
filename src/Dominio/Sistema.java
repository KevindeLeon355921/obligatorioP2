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
        precargarFicha();
    }
    private void crearFichaPrecargada(String nombre, String color, String chico, String grande){
        Ficha ficha = new Ficha();
        ficha.setNombreFicha(nombre);
        ficha.setColor(color);
        ficha.setDiseñoChico(chico);
        ficha.setDiseñoGrande(grande);
        this.agregarFicha(ficha);
    }
    
    private void precargarFicha(){
        crearFichaPrecargada("SOL","M","\\|/-*-/|\\","..|...\\|/.--*--./|\\...|..");
        crearFichaPrecargada("CUADRADO","N","+-+|.|+-+","+---+|...||...||...|+---+");
        crearFichaPrecargada("CORAZON","R","*.****.*.","**.************.***...*..");
        crearFichaPrecargada("COPA","C","\\./.|./_\\","\\.../.\\./...|....|.../_\\.");
        crearFichaPrecargada("ARBOL","V",".^.^^^.|.","..^...^^^.^^^^^..|.../.\\.");
        crearFichaPrecargada("GATO","A","^.^o.o=^=","/\\_/\\(o.o).>^<../|\\../.\\.");
        crearFichaPrecargada("DIAMANTE","G",".*.*.*.*.","..*...*.*.*...*.*.*...*..");
        crearFichaPrecargada("VACIA","B",".........",".........................");
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