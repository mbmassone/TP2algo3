package Modelo;

import Modelo.Casillero.Casillero;

public abstract class Atacante extends Unidad {
    protected int danioCercano;
    protected int danioMediano;
    protected int danioLejano;

    public Atacante(int vida,int costo,Casillero casillero,Jugador duenio){
        super(100,1, casillero, duenio);
    }

    @Override
    public void accion(Unidad unidad){
        super.atacaAliado(unidad);
        TipoDistancia tipoDistancia = this.casillero.getTipoDistancia(unidad.casillero); //Devuelve un hijo de TipoDistancia.
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
