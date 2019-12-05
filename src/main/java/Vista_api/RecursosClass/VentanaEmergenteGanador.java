package Vista_api.RecursosClass;

import Modelo.Jugador;
import Vista_api.ManipuladorEventos.SalirJuegoHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaEmergenteGanador extends VBox {

    VentanaEmergenteGanador (Jugador ganador){
        Stage ventanaEmergente = new Stage();

        Button botonSalir = new Button("Salir ");
        SalirJuegoHandler salirJuegoHandler = new SalirJuegoHandler(ventanaEmergente);
        botonSalir.setOnAction(salirJuegoHandler);

        Label mensajeFelicitacion = new Label("Felicidades " + ganador.obtenerNombre() + " Usted es el ganador!");
        VBox vbox3 = new VBox(mensajeFelicitacion,botonSalir);
        Scene contenidoEmergente = new Scene(vbox3);

        ventanaEmergente.setScene(contenidoEmergente);
        ventanaEmergente.show();
    }
}
