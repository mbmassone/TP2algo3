package Modelo;
import Modelo.Casillero.Casillero;

public class Curandero extends Curador{

    public Curandero(Jugador duenio, Casillero casillero){
        super(75,2, casillero, duenio);
        this.curacionCercana = 15;
        this.curacionMediana = 0;
        this.curacionLejana = 0;
    }

    @Override
    public void recibirCuracion(int curacion){
        this.vida += curacion;
    }
}
