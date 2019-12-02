package Vista_api.ManipuladorEventos;

import Modelo.Tablero.Coordenada;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class EventHandlerCeldaMapa implements EventHandler<MouseEvent> {

    private Coordenada posicionEnTablero;
    private Coordenada ultimaCoordenadaTocada;

    public EventHandlerCeldaMapa(Coordenada posicionEnTablero, Coordenada ultimaCoordenadaTocada) {
        this.posicionEnTablero = posicionEnTablero;
        this.ultimaCoordenadaTocada = ultimaCoordenadaTocada;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        ultimaCoordenadaTocada.cambiarCoordenada(posicionEnTablero);
        System.out.println(posicionEnTablero.obtenerColumna() + "," + posicionEnTablero.obtenerFila());
    }
}
