package Vista_api;

import Vista_api.ManipuladorEventos.Empezar_juego_Handler;

import Vista_api.ManipuladorEventos.Salir_Juego_Handler;
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

    private Scene titulo;

   private Image image;
    private ImageView imageView;
    private Label texto;
    private Button boton_dummy;
    private Button boton_iniciar;
    private Button boton_salir;
    private Empezar_juego_Handler jugarHandler;
    private Salir_Juego_Handler salir_juego_handler;

    public void inicializar(Stage stage) throws Exception{

        //Se abre un archivo
        FileInputStream PantallaTitulo = new FileInputStream(RUTA_IMG_TITULO);
        //Creo un objeto imagen a mostrar
        this.image = new Image(PantallaTitulo);

        //coloco un visor y lo referencio
        this.imageView = new ImageView(this.image);

        this.texto = new Label("Debug Info");

        this.boton_dummy = new Button("Dummy");
        this.boton_iniciar = new Button("Iniciar");
        this.boton_salir = new Button("Salir ");

        HBox hbox = new HBox(this.boton_dummy,this.boton_iniciar, this.boton_salir);
        VBox vbox = new VBox(20,imageView,texto,hbox);
        vbox.setAlignment(Pos.CENTER);
        hbox.setAlignment(Pos.CENTER);
        ///Creacion de una Escena

        //Boton handle con funcion lambda
        boton_dummy.setOnAction((event) -> System.out.println("Tocaboton"));
        this.jugarHandler = new Empezar_juego_Handler(stage);
        this.boton_iniciar.setOnAction(this.jugarHandler);
        this.salir_juego_handler = new Salir_Juego_Handler(stage);
        this.boton_salir.setOnAction(this.salir_juego_handler);
        this.titulo = new Scene(vbox);
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
