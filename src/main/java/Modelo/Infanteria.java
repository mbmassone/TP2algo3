package Modelo;

import Modelo.Unidad;

public class Infanteria extends Unidad {

    //Precondicion: fila, columna esta libre en el tablero.
    public Infanteria(){

    }

    @Override
    public void accion(Unidad unidad) {

    }

    @Override
    public boolean mover(int filaNueva, int columnaNueva) {
        return false;
    }

}
