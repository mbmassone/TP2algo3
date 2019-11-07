package Modelo;
import Modelo.Casillero.Casillero;


public class Curandero extends Unidad{
    private int curacion;

    public Curandero(Bando bando, Casillero casillero){
        super(75,2,casillero,bando);
        this.curacion = 15;
    }

    @Override
    public void accion(Unidad unidad){
        if (this.bando != unidad.obtenerBando()){
            throw new CurarEnemigoExcepcion();
        }
        unidad.recibirCuracion(curacion);
    }

    @Override
    public void recibirCuracion(int curacion){
        this.vida += curacion;
    }

}
