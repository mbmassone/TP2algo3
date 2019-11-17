package Modelo;

import Modelo.Casillero.Casillero;

public abstract class Curador extends Unidad {
    protected int curacionCercana;
    protected int curacionMediana;
    protected int curacionLejana;

    public Curador(int vida, int costo, Casillero casillero, Jugador duenio){
        super(100,1, casillero, duenio);
    }

    @Override
    public void accion(Unidad unidad){
        super.curaEnemigo(unidad);
        TipoDistancia tipoDistancia = this.casillero.obtenerTipoDistancia(unidad.casillero); //Devuelve un hijo de TipoDistancia.
        tipoDistancia.aplicarAccion(this, unidad); //Usamos polimorfismo y aplicarAccion actua en funcion de la distancia.
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
}
