package Vista_api.ManipuladorEventos;

import Modelo.Tablero.Coordenada;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class EventHandlerCeldaMapa implements EventHandler<MouseEvent> {

    private Coordenada coordenada;

    public EventHandlerCeldaMapa(Coordenada coordenada) {
        this.coordenada = coordenada;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {

        System.out.println(coordenada.obtenerColumna() + "," + coordenada.obtenerFila());
    }
}
