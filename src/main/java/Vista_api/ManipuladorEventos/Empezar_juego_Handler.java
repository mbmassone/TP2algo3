package Vista_api.ManipuladorEventos;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.File;


//Nose como funciona, pero funciona. ejecuta primero el constructor y despues salta al handle
public class Empezar_juego_Handler implements EventHandler<ActionEvent> {

    private Scene board;
    private Stage jugando;
    public  Empezar_juego_Handler(Stage stage) {
        this.jugando = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("a jugar BO");
        Label texto = new Label("zona de juego");
        Button salir_del_juego = new Button("Salir");
        Salir_Juego_Handler salir_juego_handler= new Salir_Juego_Handler(this.jugando);
        salir_del_juego.setOnAction(salir_juego_handler);
        VBox vbox = new VBox(texto,salir_del_juego);
        board = new Scene(vbox);
        jugando.setScene(board);
    }
}