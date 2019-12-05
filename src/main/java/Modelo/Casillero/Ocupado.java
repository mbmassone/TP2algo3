package Modelo.Casillero;

import Modelo.Unidad.Unidad;

public class Ocupado implements EstadoCasilla {
    public boolean estaVacia() {
        return false;
    }

    public void agregarUnidad(Casillero casillero, Unidad unidad) {
        throw new CasilleroOcupadoExcepcion();
    }

    @Override
    public void destruirUnidad(Casillero casillero) {
        casillero.actualizarEstado(new Libre());
    }

    @Override
    public String obtenerContenido(Casillero casillero) {
        return casillero.obtenerUnidad().obtenerNombre();
    }
}
