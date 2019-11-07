package Modelo;
import Modelo.Casillero.Casillero;
import Modelo.Unidad;

public class Jinete extends Unidad {
    private int danioCercano;
    private int danioLejano;

    public Jinete(Bando bando, Casillero casillero){
        super(100,3,casillero,bando);
        this.danioCercano = 5;
        this.danioLejano = 15;
    }

    @Override
    public void recibirCuracion(int curacion){
        vida += curacion;
    }

    @Override
    public void accion(Unidad unidad) {
        if (this.casillero.tieneInfanteriaCerca(this.bando) || !(this.casillero.tieneEnemigosCerca(this.bando))) {
            unidad.sufrirAtaque(danioLejano);
        }
        else {
            unidad.sufrirAtaque(danioCercano);
        }
    }

    @Override
    public boolean mover(int filaNueva, int columnaNueva) {
        return false;
    }
}
