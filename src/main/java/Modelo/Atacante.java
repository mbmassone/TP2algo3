package Modelo;

import Modelo.Casillero.Casillero;

public abstract class Atacante extends Unidad {
    protected float danioCercano;
    protected float danioMediano;
    protected float danioLejano;

    public Atacante(float vida, int costo, Jugador duenio){
        super(vida, costo, duenio);
    }

    @Override
    public void accion(Unidad unidad){
        super.atacaAliado(unidad);
        TipoDistancia tipoDistancia = this.casillero.obtenerTipoDistancia(unidad.casillero); //Devuelve un hijo de TipoDistancia.
        tipoDistancia.aplicarAccion(this, unidad); //Usamos polimorfismo y aplicarAccion actua en funcion de la distancia.
    }

    @Override
    public void accionCercana(Unidad unidad){
        unidad.sufrirAtaque(danioCercano);
    }

    @Override
    public void accionMediana(Unidad unidad){
        unidad.sufrirAtaque(danioMediano);
    }

    @Override
    public void accionLejana(Unidad unidad){
        unidad.sufrirAtaque(danioLejano);
    }
}
