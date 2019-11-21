package Modelo;
import Modelo.Casillero.Casillero;
import Modelo.Unidad;

public class Jinete extends Atacante {

    public Jinete(Jugador duenio){
        super(100,3, duenio);
        this.danioCercano = 5;
        this.danioMediano = 15;
        this.danioLejano = 0;
    }

    @Override
    public void recibirCuracion(int curacion){
        vida += curacion;
    }
}
