package Controlador.CreadorDeUnidad;

import Modelo.Unidad.Jinete;
import Modelo.Jugador.Jugador;
import Modelo.Unidad.Unidad;

public class CreadorDeJinete implements CreadorDeUnidad{
    @Override
    public Unidad crearUnidad(Jugador duenio) {
        return new Jinete(duenio);
    }
}
