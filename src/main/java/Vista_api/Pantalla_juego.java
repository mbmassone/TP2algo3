package Vista_api;

import Vista_api.ManipuladorEventos.Salir_Juego_Handler;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Pantalla_juego {

    private Mapa mapa;

    public void inicializar(Stage stage) {

       Label texto = new Label("zona de juego");
       mapa = new Mapa();
       Button salir_del_juego = new Button("Salir");

       Salir_Juego_Handler salir_juego_handler = new Salir_Juego_Handler(stage);
       salir_del_juego.setOnAction(salir_juego_handler);

       HBox contenedor_principal = new HBox();
       VBox vbox = new VBox(texto,salir_del_juego);
       contenedor_principal.getChildren().addAll(mapa,vbox);
       Scene escena_juego = new Scene(contenedor_principal);
       //Seteando esta escena, ahora los eventos de esta seran manipulado por otros (manipuladores de evento)
       stage.setScene(escena_juego);
    }


    public void actualizar() {

    }


    public void mostrar(Stage stage) {

    }
}
