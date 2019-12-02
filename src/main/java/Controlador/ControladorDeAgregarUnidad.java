package Controlador;

import Controlador.CreadorDeUnidad.CreadorDeUnidad;
import Modelo.Jugador;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;
import Modelo.Tablero.UnidadAgregadaEnSectorEnemigoExcepcion;
import Modelo.Turno;
import Modelo.Unidad;
import Vista_api.Mapa;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControladorDeAgregarUnidad implements EventHandler<MouseEvent> {
    private Tablero tablero;
    private Turno turno;
    private Coordenada ultimaCoordenadaTocada;
    private CreadorDeUnidad creador;
    private Mapa mapa;
    private Label labelPuntos;

    public ControladorDeAgregarUnidad(ContenedorDeClases contenedor, Coordenada ultimaCoordenadaTocada, CreadorDeUnidad creador, Mapa mapa, Label labelPuntos){
        this.tablero = contenedor.obtenerTablero();
        this.turno = contenedor.obtenerTurno();
        this.ultimaCoordenadaTocada = ultimaCoordenadaTocada;
        this.creador = creador;
        this.mapa = mapa;
        this.labelPuntos = labelPuntos;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        try{
            Unidad nuevaUnidad = creador.crearUnidad(turno.obtenerJugadorActual());
            if(turno.obtenerJugadorActual().agregarUnidad(nuevaUnidad)){
                tablero.agregarUnidad(ultimaCoordenadaTocada, nuevaUnidad); //TODO agregar unidades en posiciones invalidas resta puntos
                labelPuntos.setText(Integer.toString(turno.obtenerJugadorActual().obtenerPuntos()));
            } else {
                System.out.println("No tienes puntos suficientes"); //TODO avisar a usuario.
            }
        } catch (Exception exception){
            System.out.println("No se puede agregar ahí"); //TODO avisar a usuario.
        }

        mapa.actualizarTablero();
    }
}
