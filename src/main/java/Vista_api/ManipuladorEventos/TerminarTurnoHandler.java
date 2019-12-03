package Vista_api.ManipuladorEventos;

import Modelo.Turno;
import Vista_api.RecursosClass.PanelDerecho;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class TerminarTurnoHandler implements EventHandler<ActionEvent> {

    private Label jugadorActual;
    private Label puntos;
    private Turno turno;
    private int cantTurnos;
    private PanelDerecho panelDerecho;


    public TerminarTurnoHandler(Label jugadorActual, Label puntos, Turno turno, PanelDerecho panelDerecho){
        this.jugadorActual = jugadorActual;
        this.puntos = puntos;
        this.turno = turno;
        this.cantTurnos = 0;
        this.panelDerecho = panelDerecho;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        turno.cambiarTurno();

        jugadorActual.setText(turno.obtenerJugadorActual().obtenerNombre());
        puntos.setText(Integer.toString(turno.obtenerJugadorActual().obtenerPuntos()));

        cantTurnos++;
        if(cantTurnos == 2){
            panelDerecho.batalla();
        }
    }
}
