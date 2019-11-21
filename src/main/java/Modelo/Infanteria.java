package Modelo;
import Modelo.Casillero.Casillero;

public class Infanteria extends Atacante {

    public Infanteria(Jugador duenio){
        super(100,1, duenio);
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
