/*
 * Obligatorio 1 - Programacion 2 - Universidad ORT Uruguay
 * Autores:
 *   Francisco Puchala - Nro. de estudiante: XXXXXX
 *   Kevin de León - Nro. de estudiante: 359921
 */
package dominio;

import java.util.ArrayList;
import java.util.Collections;

public class Sistema {

    private ArrayList<Diseñador> listaDiseñadores;
    private ArrayList<Ficha> listaFichas;
    private ArrayList<Mural> listaMurales;

    public Sistema() {  
        listaDiseñadores = new ArrayList<Diseñador>();
        listaFichas= new ArrayList<Ficha>();
        listaMurales = new ArrayList<Mural>();
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
    
    public void agregarMural(Mural mural) {               
        listaMurales.add(mural);
    }

    public ArrayList<Mural> getListaMurales() {           
        return this.listaMurales;
    }
    public boolean existeMural(String nombre){
        boolean existe = false;
        for(int i = 0; i < listaMurales.size(); i++){
            Mural mural = listaMurales.get(i);
            if(mural.getNombreMural().equals(nombre)){
                existe = true;
            }
        }
        return existe;
    }
    
    public Ficha buscarFicha(String nombre){
        Ficha encontrada = null;
        for(int i = 0; i < listaFichas.size(); i++){
            Ficha ficha = listaFichas.get(i);
            if(ficha.getNombreFicha().equals(nombre)){
                encontrada = ficha;
            }
        }
        return encontrada;  
                
    }
    public ArrayList<Mural> getMuralesDe(Diseñador disenador) {
        ArrayList<Mural> resultado = new ArrayList<Mural>();
        for (int i = 0; i < listaMurales.size(); i++) {
            Mural mural = listaMurales.get(i);
            if (mural.getDiseñador().getNombreDiseñador().equals(disenador.getNombreDiseñador())) {
                resultado.add(mural);
            }
        }
        return resultado;
    }

    public ArrayList<Diseñador> getDiseñadoresOrdenados() {
        ArrayList<Diseñador> ordenados = new ArrayList<Diseñador>(listaDiseñadores);
        Collections.sort(ordenados);
        return ordenados;
    }

    public ArrayList<Ficha> getFichasDistintasDe(Diseñador disenador) {
        ArrayList<Ficha> distintas = new ArrayList<Ficha>();
        ArrayList<Mural> murales = getMuralesDe(disenador);
        for (int i = 0; i < murales.size(); i++) {
            ArrayList<Ficha> fichasMural = murales.get(i).getFichasDistintas();
            for (int j = 0; j < fichasMural.size(); j++) {
                Ficha ficha = fichasMural.get(j);
                boolean yaEsta = false;
                for (int k = 0; k < distintas.size(); k++) {
                    if (distintas.get(k).getNombreFicha().equals(ficha.getNombreFicha())) {
                        yaEsta = true;
                    }
                }
                if (!yaEsta && !ficha.getNombreFicha().equals("VACIA")) {
                    distintas.add(ficha);
                }
            }
        }
        return distintas;
    }

    public int cantidadColoresDistintos(Diseñador disenador) {
        ArrayList<Ficha> fichas = getFichasDistintasDe(disenador);
        String colores = "";
        for (int i = 0; i < fichas.size(); i++) {
            String color = fichas.get(i).getColor();
            if (!colores.contains(color)) {
                colores = colores + color;
            }
        }
        return colores.length();
    }
}
