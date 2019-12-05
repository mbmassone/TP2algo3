package Vista_api.ManipuladorEventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class SalirJuegoHandler implements EventHandler<ActionEvent> {

    private Stage stage;

    public SalirJuegoHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.stage.close();
    }
}
