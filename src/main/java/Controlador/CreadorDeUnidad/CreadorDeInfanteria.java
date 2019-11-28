package Controlador.CreadorDeUnidad;

import Modelo.Infanteria;
import Modelo.Jugador;
import Modelo.Unidad;

public class CreadorDeInfanteria implements CreadorDeUnidad {
    @Override
    public Unidad crearUnidad(Jugador duenio) {
        return new Infanteria(duenio);
    }
}
