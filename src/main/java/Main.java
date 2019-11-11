import Modelo.Tablero.Tablero;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;


public class Main extends Application {

    @Override
    public void start(Stage DebugStage) throws Exception {

        //Variables a usar
        int filas, columnas;

        //Inicio el modelo
        Tablero tablero = new Tablero();
        /*TODO
        Como le informo a la interfaz la matriz de casilleros(la lista de casilleros es privada y no hay getter)?
         */

        //Obtengo sus variables para mostrar

        //Titulo de la ventana
        DebugStage.setTitle("Java FX tTittle");

        //Tamaño de la ventana del stage
        DebugStage.setWidth(640);
        DebugStage.setHeight(480);

        //Setup de elementos a usar
        //Se abre un archivo
        FileInputStream neko_miku_reimu = new FileInputStream("nmr.gif");
        //Creo un objeto imagen a mostrar
        Image image = new Image(neko_miku_reimu);
        //coloco un visor y lo referencio
        ImageView imageView = new ImageView(image);
        //adicionalmente coloco un texto que lo acompañara
        Label label = new Label("Neko Miku Reimu", imageView);

        ///Creacion de una Escena
        Scene scene = new Scene(label,0,0);
        //Coloco la escena en el Stage
        DebugStage.setScene(scene);

        //Lo muestro
        DebugStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
