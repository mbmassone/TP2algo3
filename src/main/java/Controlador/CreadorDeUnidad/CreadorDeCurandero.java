package Controlador.CreadorDeUnidad;

import Modelo.Curandero;
import Modelo.Jugador;
import Modelo.Unidad;

public class CreadorDeCurandero implements CreadorDeUnidad {
    @Override
    public Unidad crearUnidad(Jugador duenio) {
        return new Curandero(duenio);
    }
}
