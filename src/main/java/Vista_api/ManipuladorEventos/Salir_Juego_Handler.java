package Vista_api.ManipuladorEventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class Salir_Juego_Handler implements EventHandler<ActionEvent> {

    private Stage stage;
    public Salir_Juego_Handler(Stage stage) {
        this.stage = stage;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        this.stage.close();
    }
}
