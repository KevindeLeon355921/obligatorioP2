/*
 * Obligatorio 1 - Programacion 2 - Universidad ORT Uruguay
 * Autores:
 *   Francisco Puchala - Nro. de estudiante: 350197
 *   Kevin de León - Nro. de estudiante: 359921
 */
package dominio;

import java.util.ArrayList;

public class Mural {

    private String nombreMural;
    private String formato;
    private Diseñador diseñador;
    private Ficha ficha1;
    private Ficha ficha2;
    private Ficha[][] mural = new Ficha[10][12];
    private Ficha[][] original = new Ficha[10][12];

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
    public void setDiseñador(Diseñador unDiseñador){
        this.diseñador = unDiseñador;
    }
    public Diseñador getDiseñador(){
        return this.diseñador;
    }

    public Ficha getFicha2() {
        return this.ficha2;
    }

    public void setFicha2(Ficha ficha2) {
        this.ficha2 = ficha2;
    }
    
    public void setFicha1(Ficha ficha1){
        this.ficha1 = ficha1;
    }
    
    public Ficha getFicha1(){
        return this.ficha1;
    }
    public Ficha getFichaEn(int fila, int columna) {
        return this.mural[fila][columna];
    }
    public void setFichaEn(int fila, int columna, Ficha ficha) {
        this.mural[fila][columna] = ficha;
    }
    
    public void aplicarFormato(Ficha vacia){
        switch (this.formato) {
            case "D":
                boolean posFicha1 = true;
                for(int i =0; i< this.mural.length;i++){
                    for(int j = 0; j< this.mural[0].length;j++){
                        if(posFicha1 == true){
                            setFichaEn(i,j,ficha1);
                            posFicha1 = false;
                        }else{
                            posFicha1 = true;
                            setFichaEn(i,j,ficha2);
                        }           
                    }
                    posFicha1 = !posFicha1; 
                }
                break;
            case "F":
                boolean filaPar = true;
                for(int i =0; i< this.mural.length;i++){
                    for(int j = 0; j< this.mural[0].length;j++){
                        if(filaPar == true){
                            setFichaEn(i,j,ficha1);
                        }else{
                            setFichaEn(i,j,ficha2);
                        }           
                    }
                    filaPar = !filaPar;
                }
                break;
            case "B":
                for(int i =0; i<this.mural.length;i++){
                    for(int j = 0; j<this.mural[0].length;j++){
                        if( (i == 0 || j == 0) || (i == this.mural.length-1 || j == this.mural[0].length-1) ){
                            setFichaEn(i,j,ficha1);
                        }else{
                            setFichaEn(i,j,ficha2);
                        }
                    }
                }
                break;
            case "R":
                for (int i = 0; i < this.mural.length; i++) {
                    for (int j = 0; j < this.mural[0].length; j++) {
                        int sorteo = (int) (Math.random() * 3);
                        if (sorteo == 0) {
                            setFichaEn(i, j, vacia);
                        } else if (sorteo == 1) {
                            setFichaEn(i, j, ficha1);
                        } else {
                            setFichaEn(i, j, ficha2);
                        }
                    }
                }
                break;
            case "M":
                for(int i =0; i<this.mural.length;i++){
                    for(int j = 0; j<this.mural[0].length;j++){
                        setFichaEn(i,j,vacia);
                    }
                }
                break;
        }
    }

    public void guardarOriginal() {
        for (int i = 0; i < this.mural.length; i++) {
            for (int j = 0; j < this.mural[0].length; j++) {
                this.original[i][j] = this.mural[i][j];
            }
        }
    }

    public void restaurar() {
        for (int i = 0; i < this.mural.length; i++) {
            for (int j = 0; j < this.mural[0].length; j++) {
                this.mural[i][j] = this.original[i][j];
            }
        }
    }

    public void reemplazarFicha(Ficha vieja, Ficha nueva) {
        for (int i = 0; i < this.mural.length; i++) {
            for (int j = 0; j < this.mural[0].length; j++) {
                if (this.mural[i][j].getNombreFicha().equals(vieja.getNombreFicha())) {
                    this.mural[i][j] = nueva;
                }
            }
        }
    }

    public ArrayList<Ficha> getFichasDistintas() {
        ArrayList<Ficha> distintas = new ArrayList<Ficha>();
        for (int i = 0; i < this.mural.length; i++) {
            for (int j = 0; j < this.mural[0].length; j++) {
                Ficha ficha = this.mural[i][j];
                boolean yaEsta = false;
                for (int k = 0; k < distintas.size(); k++) {
                    if (distintas.get(k).getNombreFicha().equals(ficha.getNombreFicha())) {
                        yaEsta = true;
                    }
                }
                if (!yaEsta) {
                    distintas.add(ficha);
                }
            }
        }
        return distintas;
    }

    public int[] buscarArea(Mural origen, int filaOrigen, int colOrigen, int alto, int ancho) {
        int[] encontrada = null;
        for (int i = 0; i <= this.mural.length - alto && encontrada == null; i++) {
            for (int j = 0; j <= this.mural[0].length - ancho && encontrada == null; j++) {
                if (areaIgual(origen, filaOrigen, colOrigen, i, j, alto, ancho)) {
                    encontrada = new int[2];
                    encontrada[0] = i;
                    encontrada[1] = j;
                }
            }
        }
        return encontrada;
    }

    private boolean areaIgual(Mural origen, int filaOrigen, int colOrigen, int filaAca, int colAca, int alto, int ancho) {
        boolean igual = true;
        for (int f = 0; f < alto && igual; f++) {
            for (int c = 0; c < ancho && igual; c++) {
                Ficha deOrigen = origen.getFichaEn(filaOrigen + f, colOrigen + c);
                Ficha deAca = this.mural[filaAca + f][colAca + c];
                if (!deOrigen.getNombreFicha().equals(deAca.getNombreFicha())) {
                    igual = false;
                }
            }
        }
        return igual;
    }
}
