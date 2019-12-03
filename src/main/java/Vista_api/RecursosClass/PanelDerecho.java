package Vista_api.RecursosClass;

import Controlador.ContenedorDeClases;
import Controlador.ControladorDeMovimientoYAccion;
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
    private Coordenada coordenadaOrigen;
    private Coordenada coordenadaDestino;
    private Mapa mapa;

    public PanelDerecho(ContenedorDeClases contenedor, Coordenada ultimaCoordenadaTocada, Mapa mapa, Coordenada coordenadaOrigen, Coordenada coordenadaDestino){
        this.contenedor = contenedor;
        this.ultimaCoordenadaTocada = ultimaCoordenadaTocada;
        this.mapa = mapa;
        this.coordenadaOrigen = coordenadaOrigen;
        this.coordenadaDestino = coordenadaDestino;
    }
//TODO Deberia recibir el handler que manipula la creacion de unidades, que a si mismo se comuinicara con el tablero para crearlo

    public void colocarUnidades(){

        this.panelColocarUnidades = new PanelDerechoColocarUnidades(contenedor, ultimaCoordenadaTocada, mapa, this); //TODO sacar clase PanelDerechoColocarUnidades.

        this.getChildren().addAll(panelColocarUnidades);
    }
    //Panel derecho con infromacion de batalla
    public void batalla(){

        Label texto_superior = new Label("Panel de Batalla");
        Label texto_jugador_actual = new Label("Turno actual:");
        Label jugador_actual = new Label(this.contenedor.obtenerTurno().obtenerJugadorActual().obtenerNombre());
        Label intrucciones = new Label("\n\nBienvenido/a " + jugador_actual.getText() + " INSTRUCCIONES:\nClick Primario: Selecciona la unidad a usar\nClick Secundario: Elije el objetivo de la unidad\n\nSi es un espacio vacio se mueve, Si es una unidad enemiga la ataca.\n\n");
        Label informacion_unidad = new Label ("Informacion de la unidad seleccionada");
        Label texto_unidad = new Label("Unidad:");
        Label texto_vida_restante = new Label("Vida restante:");
        Label vida = new Label("");
        Label unidad = new Label("");
        Button boton_terminar = new Button("Pasar Turno");
        Label informacion = new Label("");

        boton_terminar.setOnAction(new ControladorDeMovimientoYAccion(contenedor, coordenadaOrigen, coordenadaDestino, mapa));

        HBox banner_jugador = new HBox(texto_jugador_actual,jugador_actual);

        this.getChildren().remove(panelColocarUnidades);
        //Agregar cada elemento a si mismo

        HBox hbox = new HBox(texto_unidad, unidad);
        HBox hbox2 = new HBox(texto_vida_restante,vida);
        VBox vbox = new VBox(informacion_unidad,hbox,hbox2, informacion);

        this.getChildren().addAll(texto_superior,banner_jugador,intrucciones,vbox, boton_terminar);


        this.mapa.actualizarTableroBatalla();
    }
    //Panel derecho con informacion de
    public void ganador(){
        
    }
}
