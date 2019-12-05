package Modelo.Casillero;

import Modelo.Unidad.Unidad;

public interface EstadoCasilla {
    boolean estaVacia();

    void agregarUnidad(Casillero casillero, Unidad unidad);

    void destruirUnidad(Casillero casillero);

    String obtenerContenido(Casillero casillero);
}
