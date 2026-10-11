/*
 * Obligatorio 1 - Programacion 2 - Universidad ORT Uruguay
 * Autores:
 *   Francisco Puchala - Nro. de estudiante: XXXXXX
 *   Kevin de León - Nro. de estudiante: 359921
 */
package dominio;

public class Disenador {
    private String nombre;
    private String mail;
    private String direccion;
    
    public Disenador(){
        this.setNombre("Sin nombre");
        this.setMail("Sin Mail");
        this.setDireccion("Sin dirección");
    }
    public void setNombre(String unNombre){
        this.nombre=unNombre;
    }
    public String getNombre(){
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
    
    @Override
    public String toString(){
        return "Nombre: "+nombre+"  Mail: "+mail+"  Dirección: "+direccion;
    }
}