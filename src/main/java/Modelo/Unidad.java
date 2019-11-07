package Modelo;

import Modelo.Casillero.Casillero;

public abstract class Unidad {
    protected int vida;
    protected int costo;
    protected Casillero casillero;
    protected  Bando bando;
    //Saco fila, columna y tablero porque ahora la unidad tiene el casillero.


    public Unidad(){

    }

    public int descontarCosto(int puntos){
        return puntos - costo;
    }
    public Bando obtenerBando() {
        return this.bando;
    }

    public void sufrirAtaque(int danio){
        vida -= danio;
    }

    public abstract void recibirCuracion(int curacion);
    public abstract void accion(Unidad unidad);
    public abstract boolean mover(int filaNueva, int columnaNueva);

}
