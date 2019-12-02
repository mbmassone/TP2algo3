package Vista_api.RecursosClass;

import Controlador.ContenedorDeClases;
import Modelo.Tablero.Coordenada;
import Vista_api.ManipuladorEventos.Salir_Juego_Handler;
import Vista_api.Mapa;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class PanelDerecho extends VBox {

    public PanelDerechoColocarUnidades panelColocarUnidades;
//TODO Deberia recibir el handler que manipula la creacion de unidades, que a si mismo se comuinicara con el tablero para crearlo

    public void ColocarUnidades(ContenedorDeClases contenedor, Coordenada ultimaCoordenadaTocada, Mapa mapa){

        this.panelColocarUnidades = new PanelDerechoColocarUnidades(contenedor, ultimaCoordenadaTocada, mapa);

        this.getChildren().addAll(panelColocarUnidades);
    }

}
