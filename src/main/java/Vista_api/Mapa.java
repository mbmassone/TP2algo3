package Vista_api;

import Controlador.ContenedorDeClases;
import Modelo.Jugador;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;
import Vista_api.ManipuladorEventos.EventHandlerCeldaMapa;
import Vista_api.ManipuladorEventos.TocarCasilleroEnBatallaHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import static Vista_api.ConstantesInterfaz.*;


public class Mapa extends VBox {

    private Label labelUnidad;
    private Label labelVida;
    private GridPane matriz;
    private final int filas, columnas;
    private Coordenada ultimaCoordenadaTocada;
    private Coordenada coordenadaOrigen;
    private Coordenada coordenadaDestino;
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private ContenedorDeClases contenedor;
    private ImageView check;
    private ImageView check2;
    //Constructor

    public Mapa(ContenedorDeClases contenedor, Coordenada ultimaCoordenadaTocada, Coordenada coordenadaOrigen, Coordenada coordenadaDestino, Label labelVida, Label labelUnidad){

        this.matriz = new GridPane();
        this.matriz.setHgap(2);
        this.matriz.setVgap(2);
        this.filas = 20;
        this.columnas = 20;
        this.getChildren().add(this.matriz);
        this.tablero = contenedor.obtenerTablero();
        this.ultimaCoordenadaTocada = ultimaCoordenadaTocada;
        this.jugador1 = contenedor.obtenerJugador1();
        this.jugador2 = contenedor.obtenerJugador2();
        this.coordenadaOrigen = coordenadaOrigen;
        this.coordenadaDestino = coordenadaDestino;
        this.labelVida = labelVida;
        this.labelUnidad = labelUnidad;
        //this.actualizarTablero();
        this.check = (new ImageView(new Image("file:check.png")));
        this.check2 = (new ImageView(new Image("file:hitmarker.png")));
    }

    //Actualiza la vista del mapa
    public void actualizarTablero(){
        //Recorro todos los casilleros
        for (int x=0; x<this.columnas; x++) {
            for (int y = 0; y < this.filas; y++) {

                Coordenada coordenada_temp = new Coordenada(x,y);
                String string = tablero.contenidoCasillero(coordenada_temp);

                //Cargo un visor de imagenes abriendo un Stream de archivo con la composicion de ruta de abajo (usa el string que recupera del casillero)
                ImageView visor = (new ImageView(new Image("file:" + string + ".png")));

                EventHandlerCeldaMapa eventHandlerCeldaMapa = new EventHandlerCeldaMapa(this, coordenada_temp, ultimaCoordenadaTocada);

                //Se deberia crear el handler primero y despues asignarlo
                visor.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerCeldaMapa);
                this.matriz.add(visor, y, x);

            }
        }

        System.out.println("Mapa actualizado");
    }

    public void actualizarTableroBatalla(){

        this.getChildren().remove(this.matriz);

        this.matriz = new GridPane();

        this.getChildren().add(this.matriz);

        this.matriz.setHgap(2);
        this.matriz.setVgap(2);

        for (int x=0; x<this.columnas; x++) {
            for (int y = 0; y < this.filas; y++) {

                Coordenada coordenada_temp = new Coordenada(x,y);
                String string = this.tablero.contenidoCasillero(coordenada_temp);

                //Capas
                ImageView visor = (new ImageView(new Image("file:" + string + ".png")));

                ImageView vacio = (new ImageView(new Image("file:libre.png")));

                visor.addEventFilter(MouseEvent.MOUSE_CLICKED, new TocarCasilleroEnBatallaHandler(this, tablero, new Coordenada(x,y), coordenadaOrigen, coordenadaDestino, labelVida, labelUnidad));

                this.matriz.add(vacio, y, x);
                if (this.jugador1 == this.tablero.obtenerDuenioUnidad(coordenada_temp)){
                    ImageView duenio = (new ImageView(new Image("file:azul.png")));
                    this.matriz.add(duenio,y,x);
                }
                if (this.jugador2 == this.tablero.obtenerDuenioUnidad(coordenada_temp)){
                    ImageView duenio = (new ImageView(new Image("file:rojo.png")));
                    this.matriz.add(duenio,y,x);
                }

                this.matriz.add(visor, y, x);

            }
        }
        System.out.println("Mapa de Batalla actualizado");
    }

    public void colocarMarcaEnMapa(Coordenada coordenada){
        this.matriz.add(this.check, coordenada.obtenerColumna(), coordenada.obtenerFila());
    }


    public void sacarMarcaEnMapa(){
        this.matriz.getChildren().remove(this.check);
    }

    public void colocarMarca2EnMapa(Coordenada coordenada){
        this.matriz.add(this.check2, coordenada.obtenerColumna(), coordenada.obtenerFila());
    }


    public void sacarMarca2EnMapa(){
        this.matriz.getChildren().remove(this.check2);
    }

}
