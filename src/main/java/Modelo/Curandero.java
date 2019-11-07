package Modelo;
import Modelo.Casillero.Casillero;
import Modelo.Unidad;

public class Curandero extends Unidad{
    private int curacion;

    public Curandero(Bando bando, Casillero casillero){
        super(75,2,casillero,bando);
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

}
