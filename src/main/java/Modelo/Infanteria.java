package Modelo;
import Modelo.Casillero.Casillero;

public class Infanteria extends Unidad {
    private int danio;

    public Infanteria(Jugador duenio, Casillero casillero){
        super(100,1, casillero, duenio);
        this.danio = 10;
    }

    @Override
    public void accion(Unidad unidad){
        if (duenio == unidad.obtenerDuenio()){
            throw new AtacarAliadoExcepcion();
        }
        unidad.sufrirAtaque(danio);
    }

    @Override
    public void recibirCuracion(int curacion){
        vida += curacion;
    }
}
