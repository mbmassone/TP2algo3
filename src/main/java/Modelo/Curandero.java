package Modelo;
import Modelo.Unidad;

public class Curandero extends Unidad{
    private int curacion;

    public Curandero(Bando bando){
        this.vida = 75;
        this.costo = 2;
        this.bando = bando;
        this.curacion = 15;
    }

    @Override
    public void accion(Unidad unidad){
        unidad.recibirCuracion(curacion);
    }

    @Override
    public void recibirCuracion(int curacion){
        this.vida += curacion;
    }

    @Override
    public boolean mover(int filaNueva, int columnaNueva) {
        return false;
    }
}
