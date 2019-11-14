package Modelo;
import Modelo.Casillero.Casillero;
import Modelo.Unidad;

public class Jinete extends Unidad {
    private int danioCercano;
    private int danioLejano;

    public Jinete(Jugador duenio, Casillero casillero){
        super(100,3, casillero, duenio);
        this.danioCercano = 5;
        this.danioLejano = 15;
    }

    @Override
    public void recibirCuracion(int curacion){
        vida += curacion;
    }

    @Override
    public void accion(Unidad unidad) {
        if (duenio == unidad.obtenerDuenio() ) {
            throw new AtacarAliadoExcepcion();
        }
        unidad.sufrirAtaque(danioCercano);
    }
}
