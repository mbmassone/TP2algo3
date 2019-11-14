package Modelo.Tablero;

public class Coordenada {
    //Atributos
    int fila;
    int columna;

    public Coordenada(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public int obtenerFila(){ return fila; }

    public int obtenerColumna(){ return columna; }
}