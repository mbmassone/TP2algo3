package Modelo.Casillero;

import Modelo.Jugador.Jugador;

public class IdentificadorDeEnemigos implements Identificador{
    private Jugador aliado;

    public IdentificadorDeEnemigos(Jugador aliado){
        this.aliado = aliado;
    }

    @Override
    public boolean esDeLosBuscados(Casillero casillero) {
        if(casillero.estaLibre()) return false;
        return casillero.obtenerUnidad().obtenerDuenio() != aliado;
    }
}
