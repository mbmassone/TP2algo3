package Vista_api.ManipuladorEventos;

import Modelo.Tablero.Coordenada;
import Vista_api.Mapa;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class EventHandlerCeldaMapa implements EventHandler<MouseEvent> {

    private Coordenada posicionEnTablero;
    private Coordenada ultimaCoordenadaTocada;
    private Mapa mapa;

    public EventHandlerCeldaMapa(Mapa mapa, Coordenada posicionEnTablero, Coordenada ultimaCoordenadaTocada) {
        this.posicionEnTablero = posicionEnTablero;
        this.ultimaCoordenadaTocada = ultimaCoordenadaTocada;
        this.mapa = mapa;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        mapa.sacarMarcaEnMapa();
        mapa.colocarMarcaEnMapa(posicionEnTablero);

        ultimaCoordenadaTocada.cambiarCoordenada(posicionEnTablero);
        System.out.println(posicionEnTablero.obtenerColumna() + "," + posicionEnTablero.obtenerFila());
    }
}
