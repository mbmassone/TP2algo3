package Vista_api.RecursosClass;

import Controlador.ContenedorDeClases;
import Controlador.ControladorDeMovimientoYAccion;
import Modelo.Tablero.Coordenada;
import Vista_api.Mapa;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PanelDerecho extends VBox {

    public PanelDerechoColocarUnidades panelColocarUnidades;

    private Label labelUnidad;
    private Label labelVida;
    private ContenedorDeClases contenedor;
    private Coordenada ultimaCoordenadaTocada;
    private Coordenada coordenadaOrigen;
    private Coordenada coordenadaDestino;
    private Mapa mapa;


    public PanelDerecho(ContenedorDeClases contenedor, Coordenada ultimaCoordenadaTocada, Mapa mapa, Coordenada coordenadaOrigen, Coordenada coordenadaDestino, Label labelVida, Label labelUnidad){
        this.contenedor = contenedor;
        this.ultimaCoordenadaTocada = ultimaCoordenadaTocada;
        this.mapa = mapa;
        this.coordenadaOrigen = coordenadaOrigen;
        this.coordenadaDestino = coordenadaDestino;
        this.labelVida = labelVida;
        this.labelUnidad = labelUnidad;
    }
//TODO Deberia recibir el handler que manipula la creacion de unidades, que a si mismo se comuinicara con el tablero para crearlo

    public void colocarUnidades(){

        this.panelColocarUnidades = new PanelDerechoColocarUnidades(contenedor, ultimaCoordenadaTocada, mapa, this); //TODO sacar clase PanelDerechoColocarUnidades.

        this.getChildren().addAll(panelColocarUnidades);
    }
    //Panel derecho con infromacion de batalla
    public void batalla(){

        Label panelDeBatalla = new Label("Panel de Batalla");
        Label textoJugadorActual = new Label("Turno actual:");
        Label jugadorActual = new Label(this.contenedor.obtenerTurno().obtenerJugadorActual().obtenerNombre());
        Label intrucciones = new Label("\n\nBienvenido/a " + jugadorActual.getText() + " INSTRUCCIONES:\nClick Primario: Selecciona la unidad a usar\nClick Secundario: Elije el objetivo de la unidad\n\nSi es un espacio vacio se mueve, Si es una unidad enemiga la ataca.\n\n");
        Label informacionUnidad = new Label ("Informacion de la unidad seleccionada");
        Label textoUnidad = new Label("Unidad:");
        Label textoVidaRestante = new Label("Vida restante:");
        Button botonTerminar = new Button("Ejecutar y Pasar Turno");
        Label informacion = new Label("");

        botonTerminar.setOnAction(new ControladorDeMovimientoYAccion(contenedor, coordenadaOrigen, coordenadaDestino, mapa, informacion));

        HBox banner_jugador = new HBox(textoJugadorActual,jugadorActual);

        this.getChildren().remove(panelColocarUnidades);
        //Agregar cada elemento a si mismo

        HBox hbox = new HBox(textoUnidad, labelUnidad);
        HBox hbox2 = new HBox(textoVidaRestante,labelVida);
        VBox vbox = new VBox(informacionUnidad,hbox,hbox2, informacion);

        this.getChildren().addAll(panelDeBatalla,banner_jugador,intrucciones, botonTerminar,vbox);


        this.mapa.actualizarTableroBatalla();
    }
    //Panel derecho con informacion de
    public void ganador(){

    }
}
