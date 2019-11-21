package Vista_api.ManipuladorEventos;

import Vista_api.PantallaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


//Nose como funciona, pero funciona. ejecuta primero el constructor y despues salta al handle
public class Empezar_juego_Handler implements EventHandler<ActionEvent> {

    private Stage jugando;
    private PantallaJuego pantalla_juego;

    public  Empezar_juego_Handler(Stage stage) {
        this.jugando = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("a jugar BO");
        pantalla_juego = new PantallaJuego();

        //Le encargo a pantalla_juego a que setupee el Scenario y lo setee, en el main, se mostrara con el metodo .show.
        pantalla_juego.inicializar(this.jugando);
    }
}