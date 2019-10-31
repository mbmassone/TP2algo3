package Modelo;

public class Celda {
    private int fila;
    private int columna;
    private Unidad unidad;

    public Celda(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }

    public boolean estaLibre(){
        return unidad == null;
    }

    public int getFila(){
        return fila;
    }

    public int getColumna(){
        return columna;
    }

    public void agregarUnidad(Unidad unidad) {
        this.unidad = unidad;
    }
}
