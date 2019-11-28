package Vista_api.RecursosClass;

import Vista_api.ManipuladorEventos.Salir_Juego_Handler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class PanelDerecho extends VBox {

    public PanelDerechoColocarUnidades panelColocarUnidades;

    public void ColocarUnidades(){
        this.panelColocarUnidades = new PanelDerechoColocarUnidades();

        this.getChildren().addAll(panelColocarUnidades);
    }

}
