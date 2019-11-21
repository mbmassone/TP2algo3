package Modelo;
import Modelo.Casillero.Casillero;

public class Infanteria extends Atacante {

    public Infanteria(Jugador duenio, Casillero casillero){
        super(100,1, casillero, duenio);
        this.danioCercano = 10;
        this.danioMediano = 0;
        this.danioLejano = 0;
    }

    @Override
    public void recibirCuracion(int curacion) {
        this.vida += curacion;
    }

    @Override
    public boolean esInfanteria(){
        return true;
    }
}
