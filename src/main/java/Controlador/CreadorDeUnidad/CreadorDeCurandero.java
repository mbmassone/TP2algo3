package Controlador.CreadorDeUnidad;

import Modelo.Unidad.Curandero;
import Modelo.Jugador.Jugador;
import Modelo.Unidad.Unidad;

public class CreadorDeCurandero implements CreadorDeUnidad {
    @Override
    public Unidad crearUnidad(Jugador duenio) {
        return new Curandero(duenio);
    }
}
