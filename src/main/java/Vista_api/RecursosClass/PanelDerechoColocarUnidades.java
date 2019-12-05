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
        Label textoSuperior = new Label("Por favor, Creen su batallon");
        Label textoJugadorActual = new Label("Turno actual: ");
        Label jugadorActual = new Label(contenedor.obtenerTurno().obtenerJugadorActual().obtenerNombre());
        Label textoPuntosRestantes = new Label("Puntos a usar:");
        Label puntosRestantes = new Label(Integer.toString(contenedor.obtenerTurno().obtenerJugadorActual().obtenerPuntos()));
        Label intrucciones = new Label("\n\nBienvenido/a " + jugadorActual.getText() + "Para continuar haga click en una celda y haga click en la unidad que desea colocar\nRepita este porceso hasta que se acaben sus puntos\nAl terminar, hacer click en Terminar Turno\n\n\n\n");
        Button terminarTurno = new Button("Terminar Turno");
        Label informacion = new Label("");
        terminarTurno.setOnAction(new TerminarTurnoHandler(jugadorActual, puntosRestantes, contenedor.obtenerTurno(), panelDerecho, informacion));

        //Arego los contenedores
        HBox bannerJugador = new HBox(textoJugadorActual,jugadorActual);
        HBox bannerPuntos = new HBox(textoPuntosRestantes, puntosRestantes);

        //Creo la clase que contiene el tablero de unidades que el jugador puede seleccionar
        TableroUnidadesACrear tableroUnidadesACrear = new TableroUnidadesACrear(contenedor, ultimaCoordenadaTocada, mapa, puntosRestantes, informacion);
        tableroUnidadesACrear.setAlignment(Pos.CENTER);
        textoSuperior.setAlignment(Pos.CENTER);
        textoSuperior.setTextAlignment(TextAlignment.CENTER);

        //Alineamientos de textos que no funcionan
        textoJugadorActual.setAlignment(Pos.CENTER_LEFT);
        jugadorActual.setAlignment(Pos.TOP_RIGHT);

        //Agregar cada contenedor al subpanel derecho (esta mismna clase)
        this.getChildren().addAll(textoSuperior,bannerJugador,bannerPuntos,intrucciones, tableroUnidadesACrear, terminarTurno, informacion);
        terminarTurno.setAlignment(Pos.CENTER);
    }

}
