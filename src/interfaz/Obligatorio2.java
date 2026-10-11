/*
 * Obligatorio 1 - Programacion 2 - Universidad ORT Uruguay
 * Autores:
 *   Francisco Puchala - Nro. de estudiante: XXXXXX
 *   Kevin de León - Nro. de estudiante: 359921
 */
package interfaz;

import dominio.Disenador;
import dominio.Sistema;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Obligatorio2 {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
        Sistema sistema = new Sistema();
        menuPrincipal(sistema);
    }

    private static void menuPrincipal(Sistema sistema) {
        int opcion = -1;
        while (opcion != 0) {
            mostrarOpciones();
            opcion = leerEntero("Ingrese una opción: ", 0, 9);
            switch (opcion) {
                case 0:
                    System.out.println("Fin del programa.");
                    break;
                case 1:
                    mostrarAutores();
                    break;
                case 2:
                    registrarDisenador(sistema);
                    break;
                case 7:
                    mostrarListaDisenadores(sistema);
                    break;
                default:
                    System.out.println("Opción todavía no implementada.");
                    break;
            }
        }
    }

    private static void mostrarOpciones() {
        System.out.println();
        System.out.println("===== MENÚ PRINCIPAL =====");
        System.out.println("0) Terminar");
        System.out.println("1) Información de autores");
        System.out.println("2) Registrar diseñador");
        System.out.println("3) Registrar ficha");
        System.out.println("4) Creación de mural");
        System.out.println("5) Modificar mural");
        System.out.println("6) Visualizar mural");
        System.out.println("7) Listado de diseñadores");
        System.out.println("8) Comparar similitud de murales");
        System.out.println("9) Visualizar todas las fichas");
    }

    private static void mostrarAutores() {
        System.out.println("Autores del obligatorio:");
        System.out.println("- Francisco Puchala - Nro. de estudiante: XXXXXX");
        System.out.println("- Kevin de León - Nro. de estudiante: 359921");
    }

    private static int leerEntero(String mensaje, int min, int max) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String entrada = teclado.nextLine().trim();
            try {
                numero = Integer.parseInt(entrada);
                if (numero >= min && numero <= max) {
                    valido = true;
                } else {
                    System.out.println("Error: el número debe estar entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número.");
            }
        }
        return numero;
    }
    
    private static void registrarDisenador(Sistema sistema){
        System.out.println("Ingrese el nombre del diseñador:");
        String nombre=teclado.nextLine();
        System.out.println("Ingrese el mail del diseñador");
        String mail=teclado.nextLine();
        System.out.println("Ingrese la dirección del diseñador");
        String direccion=teclado.nextLine();
        Disenador disenador= new Disenador();
        disenador.setNombre(nombre);
        disenador.setMail(mail);
        disenador.setDireccion(direccion);
        sistema.agregarDisenador(disenador);
        System.out.println("Se registró correctamente el diseñador");
    }
    
    private static void mostrarListaDisenadores(Sistema sistema){
        ArrayList<Disenador> lista=sistema.getListaDisenadores();
        if(lista.size()>=1){
            for(int i=0; i<lista.size(); i++){
                System.out.println(lista.get(i));
                System.out.println("");
            }
        }else{
            System.out.println("No se ingresaron diseñadores, ingrese alguno para poder verlo en el listado");
        }
    }
}
