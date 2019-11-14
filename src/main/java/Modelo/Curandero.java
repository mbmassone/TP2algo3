package Modelo;
import Modelo.Casillero.Casillero;


public class Curandero extends Unidad{
    private int curacion;

    public Curandero(Jugador duenio, Casillero casillero){
        super(75,2, casillero, duenio);
        this.curacion = 15;
    }

    @Override
    public void accion(Unidad unidad){
        if (duenio != unidad.obtenerDuenio()){
            throw new CurarEnemigoExcepcion();
        }
        unidad.recibirCuracion(curacion);
    }

    @Override
    public void recibirCuracion(int curacion){
        this.vida += curacion;
    }

}
