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
    private Diseñador diseñador;
    private Ficha ficha1;
    private Ficha ficha2;
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
}
