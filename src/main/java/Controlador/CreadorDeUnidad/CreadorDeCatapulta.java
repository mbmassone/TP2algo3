package Controlador.CreadorDeUnidad;

import Modelo.Catapulta;
import Modelo.Jugador;
import Modelo.Unidad;

public class CreadorDeCatapulta implements CreadorDeUnidad {
    @Override
    public Unidad crearUnidad(Jugador duenio) {
        return new Catapulta(duenio);
    }
}
