package Modelo;

import Modelo.Unidad;

public class Infanteria extends Unidad {

    //Precondicion: fila, columna esta libre en el tablero.
    public Infanteria(int fila, int columna, Tablero tablero){
        this.tablero = tablero;
        this.filaActual = fila;
        this.columnaActual = columna;
    }



    @Override
    void accion(Unidad unidad) {

    }

    @Override
    boolean mover(int filaNueva, int columnaNueva) {
        return false;
    }

}
