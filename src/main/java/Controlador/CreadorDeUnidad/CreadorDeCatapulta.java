package Controlador.CreadorDeUnidad;

import Modelo.Unidad.Catapulta;
import Modelo.Jugador.Jugador;
import Modelo.Unidad.Unidad;

public class CreadorDeCatapulta implements CreadorDeUnidad {
    @Override
    public Unidad crearUnidad(Jugador duenio) {
        return new Catapulta(duenio);
    }
}
