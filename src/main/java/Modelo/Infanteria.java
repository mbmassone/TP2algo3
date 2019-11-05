package Modelo;

import Modelo.Unidad;

public class Infanteria extends Unidad {

    //Precondicion: fila, columna esta libre en el tablero.
    public Infanteria(Bando bando){
        this.bando = bando;
    }

    @Override
    public void accion(Unidad unidad) {

    }

    @Override
    public boolean mover(int filaNueva, int columnaNueva) {
        return false;
    }

}
