package Modelo.Casillero;

import Modelo.Unidad;

public interface EstadoCasilla {
    boolean estaVacia();

    void agregarUnidad(Casillero casillero, Unidad unidad);

    void destruirUnidad(Casillero casillero);
}
