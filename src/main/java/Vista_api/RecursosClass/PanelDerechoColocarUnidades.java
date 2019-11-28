package Vista_api.RecursosClass;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class PanelDerechoColocarUnidades extends VBox {

    PanelDerechoColocarUnidades(){
        Label texto_superior = new Label("Por favor, Creen su batallon");
        Label texto_jugador_actual = new Label("Turno actual:");
        Label jugador_actual = new Label("JUGADOR_ACTUAL");
        Label texto_puntos_restantes = new Label("Puntos a usar:");
        Label puntos_restantes = new Label("99");

        Label intrucciones = new Label("\n\nBienvenido/a " + jugador_actual.getText() + " para continuar haga click en una unidad y haga click de nuevo\n donde quiera colocarla, repita este porceso hasta que se acaben\n sus puntos o haga click en el boton Terminar\n\n\n\n");

        HBox banner_jugador = new HBox(texto_jugador_actual,jugador_actual);
        HBox banner_puntos = new HBox(texto_puntos_restantes, puntos_restantes);

        TableroUnidadesACrear tableroUnidadesACrear = new TableroUnidadesACrear();

        texto_superior.setAlignment(Pos.CENTER);
        texto_superior.setTextAlignment(TextAlignment.CENTER);


        texto_jugador_actual.setAlignment(Pos.CENTER_LEFT);
        jugador_actual.setAlignment(Pos.TOP_RIGHT);

        //Agregar cada elemento a si mismo
        this.getChildren().addAll(texto_superior,banner_jugador,banner_puntos,intrucciones, tableroUnidadesACrear);
    }

    public void actualizar(){

    }
}
