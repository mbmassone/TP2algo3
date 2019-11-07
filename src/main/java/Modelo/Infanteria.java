package Modelo;
import Modelo.Unidad;

public class Infanteria extends Unidad {

    private int danio;
    //Precondicion: fila, columna esta libre en el tablero.
    public Infanteria(Bando bando){
        this.vida = 100;
        this.costo = 1;
        this.bando = bando;
        this.danio = 15;
    }

    @Override
    public void accion(Unidad unidad) {
        unidad.sufrirAtaque(danio);
    }

    @Override
    public boolean mover(int filaNueva, int columnaNueva) {
        return false;
    }

    @Override
    public void recibirCuracion(int curacion){
        vida += curacion;
    }
}
