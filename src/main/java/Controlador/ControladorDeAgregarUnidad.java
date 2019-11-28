package Controlador;

import Controlador.CreadorDeUnidad.CreadorDeUnidad;
import Modelo.Jugador;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.UnidadAgregadaEnSectorEnemigoExcepcion;

public class ControladorDeAgregarUnidad {
    private ContenedorDeClases contenedor;

    public ControladorDeAgregarUnidad(ContenedorDeClases contenedor){
        this.contenedor = contenedor;
    }

    public boolean agregarUnidad(int fila, int columna, CreadorDeUnidad creador, String nombreDuenio){
        try{
            contenedor.obtenerTablero().agregarUnidad(new Coordenada(fila, columna), creador.crearUnidad(contenedor.obtenerJugador(nombreDuenio)));
        } catch (Exception excepcion){
            return false;
        }
        return true;
    }
}
