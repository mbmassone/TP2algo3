package Controlador.CreadorDeUnidad;

import Modelo.Unidad.Infanteria;
import Modelo.Jugador.Jugador;
import Modelo.Unidad.Unidad;

public class CreadorDeInfanteria implements CreadorDeUnidad {
    @Override
    public Unidad crearUnidad(Jugador duenio) {
        return new Infanteria(duenio);
    }
}
