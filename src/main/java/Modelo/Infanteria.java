package Modelo;
import Modelo.Casillero.Casillero;
import Modelo.Unidad;

public class Infanteria extends Unidad {
    private int danio;

    public Infanteria(Bando bando, Casillero casillero){
        super(100,1,casillero,bando);
        this.danio = 15;
    }

    @Override
    public void accion(Unidad unidad){
        unidad.sufrirAtaque(danio);
        unidad.unidadMuere();
    }

    @Override
    public void recibirCuracion(int curacion){
        vida += curacion;
    }
}
