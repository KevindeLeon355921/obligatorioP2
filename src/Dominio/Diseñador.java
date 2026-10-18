/*
 * Obligatorio 1 - Programacion 2 - Universidad ORT Uruguay
 * Autores:
 *   Francisco Puchala - Nro. de estudiante: 350197
 *   Kevin de León - Nro. de estudiante: 359921
 */
package dominio;

import java.util.ArrayList;

public class Diseñador implements Comparable<Diseñador> {
    private String nombre;
    private String mail;
    private String direccion;
    
    public Diseñador(){
        this.setNombreDiseñador("Sin nombre");
        this.setMail("Sin Mail");
        this.setDireccion("Sin dirección");
    }
    public void setNombreDiseñador(String unNombre){
        this.nombre=unNombre;
    }
    public String getNombreDiseñador(){
        return this.nombre;
    }
    public void setMail(String unMail){
        this.mail=unMail;
    }
    public String getMail(){
        return this.mail;
    }
    public void setDireccion(String unaDireccion){
        this.direccion=unaDireccion;
    }
    public String getDireccion(){
        return this.direccion;
    }
    public boolean seRepiteNombreDiseñador(String nombre, Sistema sistema){
        boolean repetido=false;
        ArrayList<Diseñador> lista= sistema.getListaDiseñadores();
        for(int i=0;i<lista.size() && !repetido;i++){
            Diseñador diseñador=lista.get(i);
            String nom= diseñador.getNombreDiseñador();
            if(nombre.equals(nom)){
                repetido=true;
            }
        }
        return repetido; 
    }
    
    @Override
    public String toString(){
        return "Nombre: "+nombre+"  Mail: "+mail+"  Dirección: "+direccion;
    }

    @Override
    public int compareTo(Diseñador otro) {
        return this.nombre.compareToIgnoreCase(otro.getNombreDiseñador());
    }
}
