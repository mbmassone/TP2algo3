package Vista_api;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Pantalla_titulo implements Manipulador_escenarios {

    public Scene titulo;


    void Pantalla_titulo(){
        //TODO
    }
    @Override
    public void inicializar() {

    }

    @Override
    public void actualizar()  throws Exception{
        //Titulo de la ventana
        //this.titulo.setTitle("Java FX tTittle");

        //Tamaño de la ventana del stage


        //Setup de elementos a usar
        //Se abre un archivo
        FileInputStream PantallaTitulo = new FileInputStream("PantallaTitulo.png");
        //Creo un objeto imagen a mostrar
        Image image = new Image(PantallaTitulo);
        //coloco un visor y lo referencio
        ImageView imageView = new ImageView(image);
        Label texto = new Label("Debug Info");
        texto.setTextAlignment(TextAlignment.LEFT);
        Button boton_dummy = new Button("Dummy");
        Button boton_iniciar = new Button("Iniciar");
        HBox hbox = new HBox(boton_dummy,boton_iniciar);
        VBox vbox = new VBox(20,imageView,texto,hbox);
        vbox.setAlignment(Pos.CENTER);
        hbox.setAlignment(Pos.CENTER);
        ///Creacion de una Escena

        //Boton handle con funcion lambda
        boton_dummy.setOnAction((event) -> System.out.println("Tocaboton"));

        this.titulo = new Scene(vbox,image.getWidth()*2,image.getHeight()*3);
        //Coloco la escena en el Stage

        //Lo muestro
    }

    @Override
    public void mostrar() {

    }

    @Override
    public void mostrar(Stage stage) {
        stage.setScene(this.titulo);
    }
}
