package Modelo.Casillero;

import Modelo.Unidad;

public class Ocupado implements EstadoCasilla {
    public boolean estaVacia() {
        return false;
    }

    public void agregarUnidad(Casillero casillero, Unidad unidad) {
        throw new CasilleroOcupadoExeption();
    }
}
