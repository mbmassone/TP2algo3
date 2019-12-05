package Vista_api.RecursosClass;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class PanelDerechoBatalla extends VBox {

    public PanelDerechoBatalla(){
        Label panelDeControles = new Label("Panel de controles");
        Label textoJugadorActual = new Label("Turno actual:");


        panelDeControles.setAlignment(Pos.CENTER);
        panelDeControles.setTextAlignment(TextAlignment.CENTER);


        textoJugadorActual.setAlignment(Pos.CENTER_LEFT);
        textoJugadorActual.setTextAlignment(TextAlignment.LEFT);


        //Agregar cada elemento a si mismo
        this.getChildren().addAll(panelDeControles,textoJugadorActual);
    }
}
