/*
 * Obligatorio 1 - Programacion 2 - Universidad ORT Uruguay
 * Autores:
 *   Francisco Puchala - Nro. de estudiante: XXXXXX
 *   Kevin de León - Nro. de estudiante: 359921
 */
package dominio;

public class Mural {

    private String nombreMural;
    private String formato;
    private Ficha[][] mural = new Ficha[10][12];

    public Mural() {
        this.setNombreMural("sin nombre");
        this.setFormato("sin formato");
    }
    public void setNombreMural(String unNombreMural){
        this.nombreMural=unNombreMural;
    }
    public String getNombreMural(){
        return this.nombreMural;
    }
    public void setFormato(String unFormato){
        this.formato=unFormato;
    }
    public String getFormato(){
        return this.formato;
    }
    //public Ficha [][] mostrarMural(tamaño){
        
    //}
}
