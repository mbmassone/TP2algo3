package Vista_api.RecursosClass;

import Modelo.Jugador;
import Vista_api.ManipuladorEventos.SalirJuegoHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static Vista_api.ConstantesInterfaz.*;

public class VentanaEmergenteGanador extends VBox {


    private Stage stage;

    public VentanaEmergenteGanador(Stage stage){
        this.stage = stage;
    }

    public void mostrarGanador(Jugador jugador){

        javafx.scene.image.ImageView imagenTitulo = (new ImageView(new Image(IMG_GANADOR)));
        Button botonSalir = new Button("Salir ");
        SalirJuegoHandler salirJuegoHandler = new SalirJuegoHandler(this.stage);
        botonSalir.setOnAction(salirJuegoHandler);

        Label mensajeFelicitacion = new Label("Felicidades " + jugador.obtenerNombre() + " Usted es el ganador!");
        VBox vbox3 = new VBox(mensajeFelicitacion,botonSalir);
        Scene contenidoEmergente = new Scene(vbox3);

        this.stage.setScene(contenidoEmergente);
        this.stage.show();
    }
}
