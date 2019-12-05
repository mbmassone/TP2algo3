package Vista_api;

import Vista_api.ManipuladorEventos.EasterEggLogo;
import Vista_api.ManipuladorEventos.EmpezarJuegoHandler;
import Vista_api.ManipuladorEventos.SalirJuegoHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static Vista_api.ConstantesInterfaz.*;

public class PantallaTitulo implements ManipuladorEscenarios {

    public Scene titulo;

    public void inicializar(Stage stage){

        //abro una imagen y se lo asigno a un visor
        ImageView imagenTitulo = (new ImageView(new Image(IMG_TITULO)));


        TextField textfield1 = new TextField();
        textfield1.setPromptText("Jugador1");
        TextField textfield2 = new TextField();
        textfield2.setPromptText("Jugador2");
        Label informacion = new Label();

        VBox contenedorTextFields = new VBox();
        contenedorTextFields.prefWidth(20); //Pixeles de distancia entre las cosas

        contenedorTextFields.getChildren().addAll(textfield1,textfield2, informacion);

        //Creo botones
        Button botonDummy = new Button("Dummy");
        Button botonIniciar = new Button("Iniciar");
        Button botonSalir = new Button("Salir ");

        //Creacion de Handlers y sus iniciaciones
        SalirJuegoHandler salirJuegoHandler = new SalirJuegoHandler(stage);
        EmpezarJuegoHandler jugarHandler = new EmpezarJuegoHandler(stage,textfield1,textfield2,informacion);
        EasterEggLogo eggLogo = new EasterEggLogo();

        //Asignacion de triggers de eventos a los botones
        //Dummy usa un lambda
        botonDummy.setOnAction((event) -> System.out.println("Tocaboton"));
        botonSalir.setOnAction(salirJuegoHandler);
        botonIniciar.setOnAction(jugarHandler);

        //Dispara el evento logo_bonus SOLO al hacer click en el logo del titulo
        imagenTitulo.addEventFilter(MouseEvent.MOUSE_CLICKED, eggLogo);

        //Creo contenedores y
        HBox hbox = new HBox(botonDummy, botonIniciar, botonSalir);
        VBox vbox = new VBox(20,imagenTitulo,contenedorTextFields,hbox);
        vbox.setAlignment(Pos.CENTER);
        hbox.setAlignment(Pos.CENTER);


        //aplico la escena al Stage
        this.titulo = new Scene(vbox);
    }

    @Override
    public void inicializar() {

    }

    @Override
    public void actualizar(){

    }


    @Override
    public void mostrar(Stage stage) {
        stage.setScene(this.titulo);
    }
}
