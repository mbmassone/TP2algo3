package Modelo.Casillero;

import Modelo.Unidad.Unidad;

public class Libre implements EstadoCasilla {
    public boolean estaVacia() {
        return true;
    }

    public void agregarUnidad(Casillero casillero, Unidad unidad) {
        casillero.unidad = unidad;
        casillero.actualizarEstado(new Ocupado());
    }

    @Override
    public void destruirUnidad(Casillero casillero) {
        throw new CasilleroYaEstaLibreExcepcion();
    }

    @Override
    public String obtenerContenido(Casillero casillero) {
        return "libre";
    }


}
