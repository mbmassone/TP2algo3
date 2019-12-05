package Modelo.Casillero;

import Modelo.Jugador.Jugador;
import Modelo.Unidad.Unidad;

public class IdentificadorDeInfanterias implements Identificador {

    private Jugador aliado;

    public IdentificadorDeInfanterias(Jugador aliado){
        this.aliado = aliado;
    }

    @Override
    public boolean esDeLosBuscados(Casillero casillero){
        if(casillero.estaLibre()) return false;
        Unidad unidad = casillero.obtenerUnidad();
        return unidad.esInfanteria() && unidad.obtenerDuenio() == aliado;
    }
}
