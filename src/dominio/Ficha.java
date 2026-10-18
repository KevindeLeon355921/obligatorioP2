/*
 * Obligatorio 1 - Programacion 2 - Universidad ORT Uruguay
 * Autores:
 *   Francisco Puchala - Nro. de estudiante: 350197
 *   Kevin de León - Nro. de estudiante: 359921
 */
package dominio;

import java.util.ArrayList;

public class Ficha {
    private String nombreFicha;
    private String diseñoChico;
    private String diseñoGrande;
    private String color;
    
    public Ficha(){
        this.setNombreFicha("sin nombre");
        this.setDiseñoChico("sin diseño chico");
        this.setDiseñoGrande("sin diseño grande");
        this.setColor("sin color");
    }
    public void setNombreFicha(String unNombreFicha){
        this.nombreFicha=unNombreFicha;
    }
    public String getNombreFicha(){
        return this.nombreFicha;
    }
    public void setDiseñoChico(String unDiseñoChico){
        this.diseñoChico=unDiseñoChico;
    }
    public String getDiseñoChico(){
        return this.diseñoChico;
    }
    public void setDiseñoGrande(String unDiseñoGrande){
        this.diseñoGrande=unDiseñoGrande;
    }
    public String getDiseñoGrande(){
        return this.diseñoGrande;
    }
    public void setColor(String unColor){
        this.color=unColor;
    }
    public String getColor(){
        return this.color;
    }
    public boolean tieneEspacios(String string){
        boolean tiene=false;
        for(int i =0; i<string.length() && !tiene; i++){
            char caracter=string.charAt(i);
            if(caracter == ' '){
                tiene=true;
            }
        }
        return tiene;
    }
    public boolean seRepiteNombreFicha(String nombre, Sistema sistema){
        boolean repetido=false;
        ArrayList<Ficha> lista= sistema.getListaFichas();
        for(int i=0;i<lista.size() && !repetido;i++){
            Ficha ficha=lista.get(i);
            String nom= ficha.getNombreFicha();
            if(nombre.equals(nom)){
                repetido=true;
            }
        }
        return repetido; 
    }
    
    public String getFilaChica(int fila){
        int inicio = fila * 3;
        int fin = inicio + 3;
        String pedazo = this.diseñoChico.substring(inicio, fin);
        return pedazo.replace("."," ");
    }
    
    public String getFilaGrande(int fila){
        int inicio = fila * 5;
        int fin = inicio + 5;
        String pedazo = this.diseñoGrande.substring(inicio, fin);
        return pedazo.replace("."," ");
                
    }
    
    @Override
    public String toString(){
        return "Nombre: "+nombreFicha+"  Diseño chico de la ficha : "+diseñoChico+"  Diseño grande de la ficha: "+diseñoGrande;
    }
}
