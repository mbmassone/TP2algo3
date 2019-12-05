package Controlador;

import Controlador.CreadorDeUnidad.CreadorDeUnidad;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;
import Modelo.Turno;
import Modelo.Unidad.Unidad;
import Vista_api.Mapa;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControladorDeAgregarUnidad implements EventHandler<MouseEvent> {
    private Tablero tablero;
    private Turno turno;
    private Coordenada ultimaCoordenadaTocada;
    private CreadorDeUnidad creador;
    private Mapa mapa;
    private Label labelPuntos;
    private Label informacion;

    public ControladorDeAgregarUnidad(ContenedorDeClases contenedor, Coordenada ultimaCoordenadaTocada, CreadorDeUnidad creador, Mapa mapa, Label labelPuntos, Label informacion){
        this.tablero = contenedor.obtenerTablero();
        this.turno = contenedor.obtenerTurno();
        this.ultimaCoordenadaTocada = ultimaCoordenadaTocada;
        this.creador = creador;
        this.mapa = mapa;
        this.labelPuntos = labelPuntos;
        this.informacion = informacion;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        try{
            Unidad nuevaUnidad = creador.crearUnidad(turno.obtenerJugadorActual());
            if(turno.obtenerJugadorActual().sePuedeAgregarUnidad(nuevaUnidad) ){

                tablero.agregarUnidad(ultimaCoordenadaTocada, nuevaUnidad);
                turno.obtenerJugadorActual().agregarUnidad(nuevaUnidad);

                labelPuntos.setText(Integer.toString(turno.obtenerJugadorActual().obtenerPuntos()));


            } else {
                System.out.println("No tienes puntos suficientes");
                informacion.setText("No tienes puntos suficientes.");
            }
        } catch (Exception exception){
            System.out.println("No se puede agregar ahí");
            informacion.setText("No se puede agregar ahí.");
        }

        mapa.actualizarTablero();
    }
}
