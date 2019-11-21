package Modelo.Casillero;

import Modelo.Jugador;
import Modelo.Unidad;

public class AgregadorDeInfanterias implements Agregador{

    private Jugador aliado;

    public AgregadorDeInfanterias(Jugador aliado){
        this.aliado = aliado;
    }

    @Override
    public boolean debeAgregarALista(Casillero casillero){
        Unidad unidad = casillero.obtenerUnidad();
        return unidad.esInfanteria() && unidad.obtenerDuenio() == aliado;
    }
}
