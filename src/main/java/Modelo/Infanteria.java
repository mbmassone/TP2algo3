package Modelo;
import Modelo.Casillero.Casillero;

public class Infanteria extends Unidad {
    private int danio;

    public Infanteria(Bando bando, Casillero casillero){
        super(100,1,casillero,bando);
        this.danio = 10;
    }

    @Override
    public void accion(Unidad unidad){
        if (this.bando == unidad.obtenerBando()){
            throw new AtacarAliadoExcepcion();
        }
        unidad.sufrirAtaque(danio);
    }

    @Override
    public void recibirCuracion(int curacion){
        vida += curacion;
    }
}
