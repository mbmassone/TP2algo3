package Controlador;

import Controlador.CreadorDeUnidad.CreadorDeUnidad;
import Modelo.Jugador;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;
import Modelo.Tablero.UnidadAgregadaEnSectorEnemigoExcepcion;
import Modelo.Turno;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class ControladorDeAgregarUnidad implements EventHandler<ActionEvent> {
    private Tablero tablero;
    private Turno turno;
    private Coordenada coordenada;
    private CreadorDeUnidad creador;

    public ControladorDeAgregarUnidad(ContenedorDeClases contenedor, Coordenada coordenada, CreadorDeUnidad creador){
        this.tablero = contenedor.obtenerTablero();
        this.turno = contenedor.obtenerTurno();
        this.coordenada = coordenada;
        this.creador = creador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try{
            tablero.agregarUnidad(coordenada, creador.crearUnidad(turno.obtenerJugadorActual()));
        } catch (Exception exception){
            System.out.println("No se puede agregar ahí"); //TODO avisar a usuario.
        }
    }
}
