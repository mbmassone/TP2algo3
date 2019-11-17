package Vista_api;

import Vista_api.ManipuladorEventos.Salir_Juego_Handler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Pantalla_juego {

    private Label texto;
    private Button salir_del_juego;
    private Stage jugando;
    private Salir_Juego_Handler salir_juego_handler;
    private Scene board;

    public void inicializar(Stage stage) {

       this.texto = new Label("zona de juego");
       this.salir_del_juego = new Button("Salir");
       this.jugando = stage;
       salir_juego_handler = new Salir_Juego_Handler(this.jugando);
       this.salir_del_juego.setOnAction(salir_juego_handler);
       VBox vbox = new VBox(texto,salir_del_juego);
       board = new Scene(vbox);
       jugando.setScene(board);
    }


    public void inicializar() {

    }


    public void actualizar() {

    }


    public void mostrar(Stage stage) {

    }
}
