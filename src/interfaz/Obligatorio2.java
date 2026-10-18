/*
 * Obligatorio 1 - Programacion 2 - Universidad ORT Uruguay
 * Autores:
 *   Francisco Puchala - Nro. de estudiante: 350197
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
import dominio.Mural;

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
                case 4:
                    crearMural(sistema);
                    break;
                case 5:
                    modificarMural(sistema);
                    break;
                case 6:
                    visualizarMural(sistema);
                    break;
                case 7:
                    mostrarListaDisenadores(sistema);
                    break;
                case 8:
                    compararMurales(sistema);
                    break;
                case 9:
                    mostrarTodasLasFichas(sistema);
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
        System.out.println("- Francisco Puchala - Nro. de estudiante: 350197");
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
        while(nombre.trim().equals("") || diseñador.seRepiteNombreDiseñador(nombre, sistema)){
            System.out.println("el nombre no puede estar vacío ni repetirse, ingrese uno distinto");
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
        ArrayList<Diseñador> lista = sistema.getDiseñadoresOrdenados();
        if (lista.size() == 0) {
            System.out.println("No se ingresaron diseñadores, ingrese alguno para poder verlo en el listado");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            Diseñador d = lista.get(i);
            System.out.println(d);
            System.out.println("Cantidad de murales: " + sistema.getMuralesDe(d).size());
            System.out.println("Fichas diferentes usadas: " + sistema.getFichasDistintasDe(d).size());
            System.out.println("Colores diferentes usados: " + sistema.cantidadColoresDistintos(d));
            System.out.println();
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
    
    private static void crearMural(Sistema sistema) {
        Diseñador disenador = elegirDisenador(sistema);
        if (disenador == null) {
            return;
        }

        System.out.println("Ingrese el nombre del mural:");
        String nombreMural = teclado.nextLine();
        while (nombreMural.equals("") || sistema.existeMural(nombreMural)) {
            System.out.println("Nombre vacío o ya existente, ingrese otro:");
            nombreMural = teclado.nextLine();
        }
            System.out.println("Ingrese el formato (D, R, F, B o M):");
        String formato = teclado.nextLine().toUpperCase();
        while (formato.length() != 1 || !"DRFBM".contains(formato)) {
            System.out.println("Formato inválido. Ingrese D, R, F, B o M:");
            formato = teclado.nextLine().toUpperCase();
        }

        Ficha ficha1 = elegirFicha(sistema, "Elija la primera ficha: ");
        Ficha ficha2 = elegirFicha(sistema, "Elija la segunda ficha: ");
        while (ficha2.getNombreFicha().equals(ficha1.getNombreFicha())) {
            System.out.println("La segunda ficha debe ser distinta de la primera.");
            ficha2 = elegirFicha(sistema, "Elija la segunda ficha: ");
        }

        Mural mural = new Mural();
        mural.setNombreMural(nombreMural);
        mural.setFormato(formato);
        mural.setDiseñador(disenador);
        mural.setFicha1(ficha1);
        mural.setFicha2(ficha2);
        mural.aplicarFormato(sistema.buscarFicha("VACIA"));

        if (formato.equals("M")) {
            agregarFichasManual(mural);
        }

        mural.guardarOriginal();
        sistema.agregarMural(mural);
        System.out.println("Mural creado correctamente.");
        mostrarMuralAmbosTamanos(mural);
    }
    
    private static void mostrarMural(Mural mural, boolean grande) {
        int renglonesPorFicha = 3;
        if (grande) {
            renglonesPorFicha = 5;
        }
        for (int fila = 0; fila < 10; fila++) {
            for (int renglon = 0; renglon < renglonesPorFicha; renglon++) {
                String linea = "";
                for (int col = 0; col < 12; col++) {
                    Ficha ficha = mural.getFichaEn(fila, col);
                    String pedazo;
                    if (grande) {
                        pedazo = ficha.getFilaGrande(renglon);
                    } else {
                        pedazo = ficha.getFilaChica(renglon);
                    }
                    linea = linea + codigoColor(ficha.getColor()) + pedazo + colorNormal();
                }
                System.out.println(linea);
            }
        }
    }
    
    private static Ficha elegirFicha(Sistema sistema, String mensaje) {
        ArrayList<Ficha> fichas = sistema.getListaFichas();
        for (int i = 0; i < fichas.size(); i++) {
            System.out.println((i + 1) + ") " + fichas.get(i).getNombreFicha());
        }
        int num = leerEntero(mensaje, 1, fichas.size());
        return fichas.get(num - 1);
    }

    private static void agregarFichasManual(Mural mural) {
        System.out.println("¿Desea agregar una ficha? (S/N):");
        String respuesta = teclado.nextLine().toUpperCase();
        while (respuesta.equals("S")) {
            int fila = leerEntero("Fila (1-10): ", 1, 10);
            int columna = leerEntero("Columna (1-12): ", 1, 12);
            int cual = leerEntero("¿Cuál ficha? (1 o 2): ", 1, 2);
            if (cual == 1) {
                mural.setFichaEn(fila - 1, columna - 1, mural.getFicha1());
            } else {
                mural.setFichaEn(fila - 1, columna - 1, mural.getFicha2());
            }
            System.out.println("¿Desea agregar otra ficha? (S/N):");
            respuesta = teclado.nextLine().toUpperCase();
        }
    }

    
    
    
    
    


    private static Diseñador elegirDisenador(Sistema sistema) {
        ArrayList<Diseñador> disenadores = sistema.getListaDiseñadores();
        Diseñador elegido = null;
        if (disenadores.size() == 0) {
            System.out.println("No hay diseñadores registrados. Registre uno primero.");
        } else {
            for (int i = 0; i < disenadores.size(); i++) {
                System.out.println((i + 1) + ") " + disenadores.get(i).getNombreDiseñador());
            }
            int num = leerEntero("Elija un diseñador: ", 1, disenadores.size());
            elegido = disenadores.get(num - 1);
        }
        return elegido;
    }

    private static void visualizarMural(Sistema sistema) {
        Diseñador disenador = elegirDisenador(sistema);
        if (disenador == null) {
            return;
        }
        ArrayList<Mural> murales = sistema.getMuralesDe(disenador);
        if (murales.size() == 0) {
            System.out.println("Ese diseñador no tiene murales.");
            return;
        }
        for (int i = 0; i < murales.size(); i++) {
            System.out.println((i + 1) + ") " + murales.get(i).getNombreMural());
        }
        int num = leerEntero("Elija un mural: ", 1, murales.size());
        Mural mural = murales.get(num - 1);

        System.out.println("¿En qué tamaño? (G = grande, C = chico):");
        String tamano = teclado.nextLine().toUpperCase();
        while (!tamano.equals("G") && !tamano.equals("C")) {
            System.out.println("Ingrese G o C:");
            tamano = teclado.nextLine().toUpperCase();
        }
        boolean grande = tamano.equals("G");

        String respuesta = "";
        while (!respuesta.equals("S")) {
            mostrarMural(mural, grande);
            System.out.println("Presione ENTER para cambiar de tamaño o S para salir:");
            respuesta = teclado.nextLine().toUpperCase();
            grande = !grande;
        }
    }

    private static void mostrarMuralAmbosTamanos(Mural mural) {
        System.out.println("Tamaño grande:");
        mostrarMural(mural, true);
        System.out.println("Tamaño chico:");
        mostrarMural(mural, false);
    }

    private static void modificarMural(Sistema sistema) {
        ArrayList<Mural> murales = sistema.getListaMurales();
        if (murales.size() == 0) {
            System.out.println("No hay murales registrados.");
            return;
        }
        for (int i = 0; i < murales.size(); i++) {
            Mural m = murales.get(i);
            System.out.println((i + 1) + ") " + m.getNombreMural() + " - " + m.getDiseñador().getNombreDiseñador());
        }
        int num = leerEntero("Elija un mural: ", 1, murales.size());
        Mural mural = murales.get(num - 1);

        int opcion = -1;
        while (opcion != 0) {
            System.out.println();
            System.out.println("0) Volver al menú anterior");
            System.out.println("1) Modificar posición");
            System.out.println("2) Modificar ficha");
            System.out.println("3) Restaurar");
            opcion = leerEntero("Ingrese una opción: ", 0, 3);
            switch (opcion) {
                case 1:
                    int fila = leerEntero("Fila (1-10): ", 1, 10);
                    int columna = leerEntero("Columna (1-12): ", 1, 12);
                    Ficha nueva = elegirFicha(sistema, "Elija la nueva ficha: ");
                    mural.setFichaEn(fila - 1, columna - 1, nueva);
                    mostrarMuralAmbosTamanos(mural);
                    break;
                case 2:
                    ArrayList<Ficha> actuales = mural.getFichasDistintas();
                    for (int i = 0; i < actuales.size(); i++) {
                        System.out.println((i + 1) + ") " + actuales.get(i).getNombreFicha());
                    }
                    int numVieja = leerEntero("Elija la ficha a reemplazar: ", 1, actuales.size());
                    Ficha vieja = actuales.get(numVieja - 1);
                    Ficha reemplazo = elegirFicha(sistema, "Elija la ficha nueva: ");
                    mural.reemplazarFicha(vieja, reemplazo);
                    mostrarMuralAmbosTamanos(mural);
                    break;
                case 3:
                    mural.restaurar();
                    mostrarMuralAmbosTamanos(mural);
                    break;
            }
        }
    }

    private static void compararMurales(Sistema sistema) {
        ArrayList<Mural> murales = sistema.getListaMurales();
        if (murales.size() < 2) {
            System.out.println("Se necesitan al menos 2 murales para comparar.");
            return;
        }
        for (int i = 0; i < murales.size(); i++) {
            Mural m = murales.get(i);
            System.out.println((i + 1) + ") " + m.getNombreMural() + " - " + m.getDiseñador().getNombreDiseñador());
        }
        int num = leerEntero("Elija el mural original: ", 1, murales.size());
        Mural original = murales.get(num - 1);

        int fila = leerEntero("Fila inicial (1-10): ", 1, 10);
        int columna = leerEntero("Columna inicial (1-12): ", 1, 12);
        int maxFilas = 10 - fila + 1;
        int maxColumnas = 12 - columna + 1;
        int alto = leerEntero("Cantidad de filas (1-" + maxFilas + "): ", 1, maxFilas);
        int ancho = leerEntero("Cantidad de columnas (1-" + maxColumnas + "): ", 1, maxColumnas);

        boolean hayAlguno = false;
        for (int i = 0; i < murales.size(); i++) {
            Mural otro = murales.get(i);
            if (!otro.getNombreMural().equals(original.getNombreMural())) {
                int[] posicion = otro.buscarArea(original, fila - 1, columna - 1, alto, ancho);
                if (posicion != null) {
                    System.out.println("Mural " + otro.getNombreMural() + ": fila " + (posicion[0] + 1) + ", columna " + (posicion[1] + 1));
                    hayAlguno = true;
                }
            }
        }
        if (!hayAlguno) {
            System.out.println("Ningún otro mural tiene un área idéntica.");
        }
    }

    private static void registrarFicha(Sistema sistema) {
        Ficha ficha = new Ficha();
        System.out.println("Ingrese el nombre de la ficha:");
        String nombre = teclado.nextLine().toUpperCase();
        while(nombre.trim().equals("") || ficha.seRepiteNombreFicha(nombre, sistema)){
            System.out.println("el nombre no puede estar vacío ni repetirse, ingrese otro por favor:");
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
