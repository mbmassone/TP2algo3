package Vista_api.ManipuladorEventos;

import Vista_api.Pantalla_juego;
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
    private Pantalla_juego pantalla_juego;
    public  Empezar_juego_Handler(Stage stage) {
        this.jugando = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("a jugar BO");
        pantalla_juego = new Pantalla_juego();
        pantalla_juego.inicializar(this.jugando);
    }
}