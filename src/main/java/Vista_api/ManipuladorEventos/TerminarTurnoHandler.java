package Vista_api.ManipuladorEventos;

import Modelo.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class TerminarTurnoHandler implements EventHandler<ActionEvent> {

    private Label jugadorActual;
    private Label puntos;
    private Turno turno;


    public TerminarTurnoHandler(Label jugadorActual, Label puntos, Turno turno){
        this.jugadorActual = jugadorActual;
        this.puntos = puntos;
        this.turno = turno;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        turno.cambiarTurno();

        jugadorActual.setText(turno.obtenerJugadorActual().obtenerNombre());
        puntos.setText(Integer.toString(turno.obtenerJugadorActual().obtenerPuntos()));
    }
}
