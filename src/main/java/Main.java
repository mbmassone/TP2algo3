import Vista_api.Pantalla_titulo;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage DebugStage) throws Exception {
        DebugStage.setTitle("AlgoChessApp Beta0..0.0.1");

        Pantalla_titulo wn = new Pantalla_titulo();
        wn.actualizar();
        wn.mostrar(DebugStage);
        //La muestra
        DebugStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
