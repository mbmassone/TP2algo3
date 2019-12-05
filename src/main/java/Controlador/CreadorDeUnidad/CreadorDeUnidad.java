package Controlador.CreadorDeUnidad;

import Modelo.Jugador.Jugador;
import Modelo.Unidad.Unidad;

public interface CreadorDeUnidad {
    public Unidad crearUnidad(Jugador duenio);
}
