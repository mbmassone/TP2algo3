package Vista_api.ManipuladorEventos;

import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;
import Vista_api.Mapa;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class TocarCasilleroEnBatallaHandler implements EventHandler<MouseEvent> {
    private Tablero tablero;
    private Coordenada posicionEnTablero;
    private Coordenada coordenadaOrigen;
    private Coordenada coordenadaDestino;
    private Label labelVida;
    private Label labelUnidad;

    public TocarCasilleroEnBatallaHandler(Tablero tablero, Coordenada posicionEnTablero, Coordenada coordenadaOrigen, Coordenada coordenadaDestino, Label labelVida, Label labelUnidad) {
        this.posicionEnTablero = posicionEnTablero;
        this.coordenadaOrigen = coordenadaOrigen;
        this.coordenadaDestino = coordenadaDestino;
        this.labelUnidad = labelUnidad;
        this.labelVida = labelVida;
        this.tablero = tablero;
    }


    @Override
    public void handle(MouseEvent mouseEvent) {
        if(mouseEvent.getButton() == MouseButton.PRIMARY){
            System.out.print("Coordenada Origen");
            labelUnidad.setText(tablero.contenidoCasillero(posicionEnTablero));
            labelVida.setText(tablero.obtenerStringVida(posicionEnTablero));
            coordenadaOrigen.cambiarCoordenada(posicionEnTablero);
        } else {
            System.out.println("Coordenada Destino");
            coordenadaDestino.cambiarCoordenada(posicionEnTablero);
        }
        System.out.println(posicionEnTablero.obtenerColumna() + "," + posicionEnTablero.obtenerFila());


    }
}
