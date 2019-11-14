package Modelo;
import Modelo.Casillero.Casillero;


public class Curandero extends Unidad{
    private int curacionCercana;
    private int curacionMediana;
    private int curacionLejana;

    public Curandero(Jugador duenio, Casillero casillero){
        super(75,2, casillero, duenio);
        this.curacionCercana = 15;
        this.curacionMediana = 0;
        this.curacionLejana = 0;
    }

    @Override
    public void accion(Unidad unidad){
        super.curaEnemigo(unidad);
        TipoDistancia tipoDistancia = this.casillero.getTipoDistancia(unidad.casillero); //Devuelve un hijo de TipoDistancia.
        tipoDistancia.aplicarAccion(this,unidad);
    }

    @Override
    public void accionCercana(Unidad unidad){
        unidad.recibirCuracion(curacionCercana);
    }

    @Override
    public void accionMediana(Unidad unidad){
        unidad.recibirCuracion(curacionMediana);
    }

    @Override
    public void accionLejana(Unidad unidad){
        unidad.recibirCuracion(curacionLejana);
    }

    @Override
    public void recibirCuracion(int curacion){
        this.vida += curacion;
    }
}
