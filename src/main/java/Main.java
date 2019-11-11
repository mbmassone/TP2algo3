import Modelo.Tablero.Tablero;
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


        //Setup de elementos a usar
        //Se abre un archivo
        FileInputStream PantallaTitulo = new FileInputStream("PantallaTitulo.png");
        //Creo un objeto imagen a mostrar
        Image image = new Image(PantallaTitulo);
        //coloco un visor y lo referencio
        ImageView imageView = new ImageView(image);
        Label texto = new Label("Debug Info");
        VBox vbox = new VBox(20,imageView,texto);
        ///Creacion de una Escena
        Scene scene = new Scene(vbox,image.getWidth(),image.getHeight()*2);
        //Coloco la escena en el Stage
        DebugStage.setScene(scene);

        //Lo muestro
        DebugStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
