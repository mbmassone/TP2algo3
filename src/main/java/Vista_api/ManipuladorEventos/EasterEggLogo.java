package Vista_api.ManipuladorEventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class EasterEggLogo implements EventHandler<MouseEvent> {

    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println("U found it Bruh");
    }
}
