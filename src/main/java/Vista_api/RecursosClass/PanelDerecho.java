package Vista_api.RecursosClass;

import Controlador.ContenedorDeClases;
import Modelo.Tablero.Coordenada;
import Vista_api.ManipuladorEventos.Salir_Juego_Handler;
import Vista_api.Mapa;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class PanelDerecho extends VBox {

    public PanelDerechoColocarUnidades panelColocarUnidades;

    private ContenedorDeClases contenedor;
    private Coordenada ultimaCoordenadaTocada;
    private Mapa mapa;

    public PanelDerecho(ContenedorDeClases contenedor, Coordenada ultimaCoordenadaTocada, Mapa mapa){
        this.contenedor = contenedor;
        this.ultimaCoordenadaTocada = ultimaCoordenadaTocada;
        this.mapa = mapa;
    }
//TODO Deberia recibir el handler que manipula la creacion de unidades, que a si mismo se comuinicara con el tablero para crearlo

    public void colocarUnidades(){

        this.panelColocarUnidades = new PanelDerechoColocarUnidades(contenedor, ultimaCoordenadaTocada, mapa, this); //TODO sacar clase PanelDerechoColocarUnidades.

        this.getChildren().addAll(panelColocarUnidades);
    }

    public void batalla(){

        Label texto_superior = new Label("Panel de Batalla");
        Label texto_jugador_actual = new Label("Turno actual:");
        Label jugador_actual = new Label(this.contenedor.obtenerTurno().obtenerJugadorActual().obtenerNombre());
        Label intrucciones = new Label("\n\nBienvenido/a " + jugador_actual.getText() + " INSTRUCCIONES\n De como jugar AQUI\n y nada mas\n\n\n\n");
        Button boton_terminar = new Button("Terminar turno");

        HBox banner_jugador = new HBox(texto_jugador_actual,jugador_actual);


        this.getChildren().remove(panelColocarUnidades);
        //Agregar cada elemento a si mismo

        this.getChildren().addAll(texto_superior,banner_jugador,intrucciones,boton_terminar);

        this.mapa.actualizarTableroBatalla();
    }
}
