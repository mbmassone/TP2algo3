package Controlador.CreadorDeUnidad;

import Modelo.Jinete;
import Modelo.Jugador;
import Modelo.Unidad;

public class CreadorDeJinete implements CreadorDeUnidad{
    @Override
    public Unidad crearUnidad(Jugador duenio) {
        return new Jinete(duenio);
    }
}
