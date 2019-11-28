package Vista_api.RecursosClass;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class PanelDerechoColocarUnidades extends VBox {

    PanelDerechoColocarUnidades(){
        Label texto_superior = new Label("Por favor, Creen su batallon");
        Label texto_jugador_actual = new Label("Turno actual:");


        texto_superior.setAlignment(Pos.CENTER);
        texto_superior.setTextAlignment(TextAlignment.CENTER);


        texto_jugador_actual.setAlignment(Pos.CENTER_LEFT);
        texto_jugador_actual.setTextAlignment(TextAlignment.LEFT);


        //Agregar cada elemento a si mismo
        this.getChildren().addAll(texto_superior,texto_jugador_actual);

    }
}
