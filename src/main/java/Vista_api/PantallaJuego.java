package Vista_api;

import Controlador.ContenedorDeClases;
import Modelo.Jugador;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;
import Vista_api.ManipuladorEventos.SalirJuegoHandler;
import Vista_api.RecursosClass.PanelDerecho;
import Vista_api.RecursosClass.VentanaEmergenteGanador;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class PantallaJuego {

    private Mapa mapa;

    public void inicializar(Stage stage, ContenedorDeClases contenedorDeClases) {

        Coordenada ultimaCoordenadaTocada = new Coordenada(-1,-1); //Le pongo una posicion inicial
        Coordenada coordenadaOrigen = new Coordenada(0,0);
        Coordenada coordenadaDestino = new Coordenada(0,0);
        Label labelVida = new Label("");
        Label labelUnidad = new Label("");

        //Seteo el fondo del mapa
        Image image = new Image("file:FondoMapa.png");
        BackgroundImage backgroundMapa = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background background = new Background(backgroundMapa);

        mapa = new Mapa(contenedorDeClases, ultimaCoordenadaTocada, coordenadaOrigen, coordenadaDestino, labelVida, labelUnidad);

        mapa.setBackground(background);

        //contenedor principal es el grupo de nodos mas externo de toda la pantalla
       HBox contenedorPrincipal = new HBox();

       contenedorPrincipal.setSpacing(20);

       //panel Derecho donde estaran los controles o la informacion del tablero
        PanelDerecho panel_derecho = new PanelDerecho(contenedorDeClases, ultimaCoordenadaTocada, mapa, coordenadaOrigen, coordenadaDestino, labelVida, labelUnidad);


        mapa.actualizarTablero();

        //Metemos los contenidos
        contenedorPrincipal.getChildren().addAll(mapa,panel_derecho);
        panel_derecho.colocarUnidades();

        //Creamos la escena
       Scene escenaJuego = new Scene(contenedorPrincipal);

       //Seteando esta escena, ahora los eventos de esta seran manipulado por otros (manipuladores de evento)
       stage.setScene(escenaJuego);

    }



}
