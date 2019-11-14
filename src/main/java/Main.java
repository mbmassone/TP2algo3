import Modelo.Tablero.Tablero;
import Vista_api.Pantalla_titulo;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



import java.io.FileInputStream;


public class Main extends Application {

    @Override
    public void start(Stage DebugStage) throws Exception {
        DebugStage.setTitle("AlgoChessApp Beta0..0.0.1");

        Pantalla_titulo wn = new Pantalla_titulo();
        wn.actualizar();
        wn.mostrar(DebugStage);
        DebugStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
