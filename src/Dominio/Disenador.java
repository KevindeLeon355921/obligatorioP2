/*
 * Obligatorio 1 - Programacion 2 - Universidad ORT Uruguay
 * Autores:
 *   Francisco Puchala - Nro. de estudiante: XXXXXX
 *   NOMBRE COMPLETO COMPANERO - Nro. de estudiante: XXXXXX
 */
package dominio;

public class Disenador {
    private String nombre;
    private String mail;
    private String direccion;
    
    public Disenador(String nombre, String mail, String direccion){
        this.nombre = nombre;
        this.mail = mail;
        this.direccion = direccion;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getMail(){
        return this.mail;
    }
    
    public String getDireccion(){
        return this.direccion;
    }
}
