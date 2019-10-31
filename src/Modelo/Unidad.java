package Modelo;

public abstract class Unidad {
    protected int vida;
    protected int costo;
    protected Tablero tablero;
    protected int filaActual;
    protected int columnaActual;

    public Unidad(){

    }

    abstract void accion(Unidad unidad);
    abstract boolean mover(int filaNueva, int columnaNueva);


}
