/*
 * Obligatorio 1 - Programacion 2 - Universidad ORT Uruguay
 * Autores:
 *   Francisco Puchala - Nro. de estudiante: XXXXXX
 *   Kevin de León - Nro. de estudiante: 359921
 */
package interfaz;

import dominio.Diseñador;
import dominio.Sistema;
import dominio.Ficha;
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
                case 3:
                    registrarFicha(sistema);
                    break;
                case 7:
                    mostrarListaDisenadores(sistema);
                    break;
                case 9:
                    mostrarTodasLasFichas(sistema);
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

    private static void registrarDisenador(Sistema sistema) {
        Diseñador diseñador = new Diseñador();
        System.out.println("Ingrese el nombre del diseñador:");
        String nombre = teclado.nextLine();
        while(diseñador.seRepiteNombreDiseñador(nombre, sistema)){
            System.out.println("ya se ingresó un diseñador con ese nombre, ingrese uno distinto");
            nombre=teclado.nextLine();
        }
        System.out.println("Ingrese el mail del diseñador");
        String mail = teclado.nextLine();
        System.out.println("Ingrese la dirección del diseñador");
        String direccion = teclado.nextLine();
        diseñador.setNombreDiseñador(nombre);
        diseñador.setMail(mail);
        diseñador.setDireccion(direccion);
        sistema.agregarDiseñador(diseñador);
        System.out.println("Se registró correctamente el diseñador");
    }

    private static void mostrarListaDisenadores(Sistema sistema) {
        ArrayList<Diseñador> lista = sistema.getListaDiseñadores();
        if (lista.size() >= 1) {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i));
                System.out.println("");
            }
        } else {
            System.out.println("No se ingresaron diseñadores, ingrese alguno para poder verlo en el listado");
        }
    }
    
    private static String codigoColor(String letra){
        String codigo = "";
        switch(letra){
            case "N":
                codigo = "\u001B[30m";
                break;
            case "R":
                codigo = "\u001B[31m";
                break;
            case "V":
                codigo = "\u001B[32m";
                break;
            case "M":
                codigo = "\u001B[33m";
                break;
            case "A":
                codigo = "\u001B[34m";
                break;
            case "G":
                codigo = "\u001B[35m";
                break;
            case "C":
                codigo = "\u001B[36m";
                break;
            case "B":
                codigo = "\u001B[37m";
                break;
        }
        return codigo;
    }

    private static String colorNormal(){
        return "\u001B[0m";
    }
    
    private static void mostrarFichaChica(Ficha ficha){
        for(int i = 0;i<3;i++){
            System.out.println(codigoColor(ficha.getColor()) + ficha.getFilaChica(i) + colorNormal() );
            
        }
    }
    
    private static void mostrarFichaGrande(Ficha ficha){
        for(int i= 0;i<5;i++){
            System.out.println(codigoColor(ficha.getColor()) + ficha.getFilaGrande(i) + colorNormal() );

        }
    }
    
    private static void mostrarTodasLasFichas(Sistema sistema){
    ArrayList<Ficha> fichas = sistema.getListaFichas();
    for(int i=0; i< fichas.size(); i++){
        Ficha ficha = fichas.get(i);
        System.out.println("Ficha: " + ficha.getNombreFicha());
        System.out.println("Color: " + ficha.getColor());
        System.out.println("Tamaño chico:");
        mostrarFichaChica(ficha);
        System.out.println("Tamaño grande:");
        mostrarFichaGrande(ficha);
        System.out.println();
    }
}

    private static void registrarFicha(Sistema sistema) {
        Ficha ficha = new Ficha();
        System.out.println("Ingrese el nombre de la ficha:");
        String nombre = teclado.nextLine().toUpperCase();
        while(ficha.seRepiteNombreFicha(nombre, sistema)){
            System.out.println("ese nombre ya existe, ingrese otro por favor:");
            nombre = teclado.nextLine().toUpperCase();
        }
        ficha.setNombreFicha(nombre);
        System.out.println("Ingrese el diseño chico de la ficha, los puntos serán interpretados como espacios:");
        String diseñoChico = teclado.nextLine();
        while (diseñoChico.length() != 9 || ficha.tieneEspacios(diseñoChico)) {
            if (diseñoChico.length() != 9) {
                System.out.println("el tamaño chico de la ficha debe ser de 9");
            } else if (ficha.tieneEspacios(diseñoChico)) {
                System.out.println("el diseño no puede contener espacios");
            }
            System.out.println("Ingrese el diseño chico de la ficha, los puntos serán interpretados como espacios:");
            diseñoChico = teclado.nextLine();
        }
        ficha.setDiseñoChico(diseñoChico);
        System.out.println("Ingrese el diseño grande de la ficha, los puntos serán interpretados como espacios");
        String diseñoGrande = teclado.nextLine();
        while (diseñoGrande.length() != 25 || ficha.tieneEspacios(diseñoGrande)) {
            if (diseñoGrande.length() != 25) {
                System.out.println("el tamaño grande de la ficha debe ser de 25");
            } else if (ficha.tieneEspacios(diseñoGrande)) {
                System.out.println("el diseño no puede contener espacios");
            }
            System.out.println("Ingrese el diseño grande de la ficha, los puntos serán interpretados como espacios:");
            diseñoGrande = teclado.nextLine();
        }
        ficha.setDiseñoGrande(diseñoGrande);
        System.out.println("Ingrese el color de la ficha(R,A,B,N,M,V,G,C):");
        String color=teclado.nextLine().toUpperCase();
        String coloresValidos="RABNMVGC";
        while(!coloresValidos.contains(color.toUpperCase()) || color.length() > 1 || color.equals("")){
            System.out.println("debe ingresar un color válido");
            System.out.println("Ingrese el color de la ficha(R,A,B,N,M,V,G,C):");
            color=teclado.nextLine().toUpperCase();
        }
        ficha.setColor(color);
        sistema.agregarFicha(ficha);
        System.out.println("se registró correctamente la ficha");
        mostrarFichaGrande(ficha);
        mostrarFichaChica(ficha);
    }
}
