package Modelo.Casillero;

import Modelo.Unidad;

public class Libre implements EstadoCasilla {
    public boolean estaVacia() {
        return true;
    }

    public void agregarUnidad(Casillero casillero, Unidad unidad) {
        casillero.unidad = unidad;
        casillero.actualizarEstado(new Ocupado());
    }


}
