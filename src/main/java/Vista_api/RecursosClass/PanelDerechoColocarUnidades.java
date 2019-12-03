package Vista_api.RecursosClass;

import Controlador.ContenedorDeClases;
import Modelo.Tablero.Coordenada;
import Vista_api.ManipuladorEventos.TerminarTurnoHandler;
import Vista_api.Mapa;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;


public class PanelDerechoColocarUnidades extends VBox {

    public PanelDerechoColocarUnidades(ContenedorDeClases contenedor, Coordenada ultimaCoordenadaTocada, Mapa mapa, PanelDerecho panelDerecho){
        //Coloco todos los nodos a usar
        Label texto_superior = new Label("Por favor, Creen su batallon");
        Label texto_jugador_actual = new Label("Turno actual: ");
        Label jugador_actual = new Label(contenedor.obtenerTurno().obtenerJugadorActual().obtenerNombre());
        Label texto_puntos_restantes = new Label("Puntos a usar:");
        Label puntos_restantes = new Label(Integer.toString(contenedor.obtenerTurno().obtenerJugadorActual().obtenerPuntos()));
        Label intrucciones = new Label("\n\nBienvenido/a " + jugador_actual.getText() + " para continuar haga click en una unidad y haga click de nuevo\n donde quiera colocarla, repita este porceso hasta que se acaben\n sus puntos o haga click en el boton Terminar\n\n\n\n");
        Button boton_terminar = new Button("Terminar turno");
        boton_terminar.setOnAction(new TerminarTurnoHandler(jugador_actual, puntos_restantes, contenedor.obtenerTurno(), panelDerecho));

        //Arego los contenedores
        HBox banner_jugador = new HBox(texto_jugador_actual,jugador_actual);
        HBox banner_puntos = new HBox(texto_puntos_restantes, puntos_restantes);

        //Creo la clase que contiene el tablero de unidades que el jugador puede seleccionar
        TableroUnidadesACrear tableroUnidadesACrear = new TableroUnidadesACrear(contenedor, ultimaCoordenadaTocada, mapa, puntos_restantes);
        tableroUnidadesACrear.setAlignment(Pos.CENTER);
        texto_superior.setAlignment(Pos.CENTER);
        texto_superior.setTextAlignment(TextAlignment.CENTER);

        //Alineamientos de textos que no funcionan
        texto_jugador_actual.setAlignment(Pos.CENTER_LEFT);
        jugador_actual.setAlignment(Pos.TOP_RIGHT);

        //Agregar cada contenedor al subpanel derecho (esta mismna clase)
        this.getChildren().addAll(texto_superior,banner_jugador,banner_puntos,intrucciones, tableroUnidadesACrear, boton_terminar);
        boton_terminar.setAlignment(Pos.CENTER);
    }

    public void actualizar(){

    }
}
