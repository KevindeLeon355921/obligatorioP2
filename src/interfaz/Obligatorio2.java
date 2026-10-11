/*
 * Obligatorio 1 - Programacion 2 - Universidad ORT Uruguay
 * Autores:
 *   Francisco Puchala - Nro. de estudiante: XXXXXX
 *   NOMBRE COMPLETO COMPANERO - Nro. de estudiante: XXXXXX
 */
package interfaz;

import dominio.Sistema;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Obligatorio2 {

    public static void main(String[] args) throws UnsupportedEncodingException {
           System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
           Sistema sistema = new Sistema();
           Scanner teclado =  Scanner(System.in);
    }

    private static class Scanner {

        public Scanner() {
        }
    }
}
