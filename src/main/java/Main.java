import Vista_api.PantallaTitulo;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("AlgoChessApp Beta0.0.3");

        //Fijo las dimensiones de la ventana
        stage.setHeight(720);
        stage.setWidth(1280);

        //Instancio mi clase de Pantalla de titulo que colocara contenido en el Stage
        PantallaTitulo pantalla = new PantallaTitulo();
        pantalla.inicializar(stage);
        pantalla.mostrar(stage);
        //La muestra
        stage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
