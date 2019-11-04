package Modelo;

public abstract class Unidad {
    protected int vida;
    protected int costo;
    protected Casillero casillero;
    //Saco fila, columna y tablero porque ahora la unidad tiene el casillero.


    public Unidad(){

    }

    abstract void accion(Unidad unidad);
    abstract boolean mover(int filaNueva, int columnaNueva);


}
