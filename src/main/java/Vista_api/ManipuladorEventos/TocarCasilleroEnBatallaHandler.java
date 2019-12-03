package Vista_api.ManipuladorEventos;

import Modelo.Tablero.Coordenada;
import Vista_api.Mapa;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class TocarCasilleroEnBatallaHandler implements EventHandler<MouseEvent> {
    private Coordenada posicionEnTablero;
    private Coordenada coordenadaOrigen;
    private Coordenada coordenadaDestino;

    public TocarCasilleroEnBatallaHandler(Coordenada posicionEnTablero, Coordenada coordenadaOrigen, Coordenada coordenadaDestino) {
        this.posicionEnTablero = posicionEnTablero;
        this.coordenadaOrigen = coordenadaOrigen;
        this.coordenadaDestino = coordenadaDestino;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseButton.PRIMARY){
            System.out.print("Coordenada Origen");
            coordenadaOrigen.cambiarCoordenada(posicionEnTablero);
        } else {
            System.out.println("Coordenada Destino");
            coordenadaDestino.cambiarCoordenada(posicionEnTablero);
        }
        System.out.println(posicionEnTablero.obtenerColumna() + "," + posicionEnTablero.obtenerFila());


    }
}
