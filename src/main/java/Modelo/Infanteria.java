package Modelo;
import Modelo.Casillero.Casillero;
import Modelo.Unidad;

public class Infanteria extends Unidad {

    private int danio;
    //Precondicion: fila, columna esta libre en el tablero.
    public Infanteria(Bando bando, Casillero casillero){
        super(100,1,casillero,bando);
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
