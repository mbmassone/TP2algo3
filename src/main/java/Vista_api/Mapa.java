package Vista_api;

import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;
import Vista_api.ManipuladorEventos.EventHandlerCeldaMapa;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import static Vista_api.ConstantesInterfaz.*;


public class Mapa extends VBox {

    private GridPane matriz;
    private final int filas, columnas;
    private Coordenada ultimaCoordenadaTocada;
    private Tablero tablero;
    //Constructor

    public Mapa(Tablero tablero, Coordenada ultimaCoordenadaTocada){

        this.matriz = new GridPane();
        this.matriz.setHgap(2);
        this.matriz.setVgap(2);
        //TODO cambiar harcoding de aqui, el tablero o loqeusea deberia decirme de cuanto es la matriz
        this.filas = 20;
        this.columnas = 20;
        this.getChildren().add(this.matriz);
        this.tablero = tablero;
        this.ultimaCoordenadaTocada = ultimaCoordenadaTocada;
        this.actualizarTablero();
    }

    //Actualiza la vista del mapa
    public void actualizarTablero(){
        //Recorro todos los casilleros
        for (int x=0; x<this.columnas; x++) {
            for (int y = 0; y < this.filas; y++) {
                //TODO obtener el estado de una casilla e iterar a la siguiente.

                Coordenada coordenada_temp = new Coordenada(x,y);
                String string = tablero.contenidoCasillero(coordenada_temp);
                //System.out.println(string);

                //Cargo un visor de imagenes abriendo un Stream de archivo con la composicion de ruta de abajo (usa el string que recupera del casillero)
                ImageView visor = (new ImageView(new Image("file:" + string + ".png")));

                EventHandlerCeldaMapa eventHandlerCeldaMapa = new EventHandlerCeldaMapa(coordenada_temp, ultimaCoordenadaTocada);

                //Se deberia crear el handler primero y despues asignarlo
                visor.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandlerCeldaMapa);
                this.matriz.add(visor, y, x);
            }
        }
        //ImageView vacio = (new ImageView(new Image(IMG_CURANDERO)));
        //vacio.setFitHeight(25);
        //vacio.setFitWidth(25);
        //this.matriz.add(vacio, 20, 20);
        System.out.println("Mapa actualizado");
    }
}
