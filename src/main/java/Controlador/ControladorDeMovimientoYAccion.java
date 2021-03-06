package Controlador;

import Modelo.*;
import Modelo.Casillero.CasilleroFueraDeRangoExcepcion;
import Modelo.Casillero.CasilleroNoEsAdyacenteExcepcion;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;
import Modelo.Unidad.AtacarAliadoExcepcion;
import Modelo.Unidad.CatapultaCuracionException;
import Modelo.Unidad.CatapultaNoSePuedeMoverExcepcion;
import Modelo.Unidad.CurarEnemigoExcepcion;
import Vista_api.Mapa;
import Vista_api.RecursosClass.VentanaEmergenteGanador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControladorDeMovimientoYAccion implements EventHandler<ActionEvent> {

    private Tablero tablero;
    private Turno turno;
    private Coordenada coordenadaOrigen;
    private Coordenada coordenadaDestino;
    private Mapa mapa;
    private Label info;
    private Label jugadorActual;
    private Stage stage;

    public ControladorDeMovimientoYAccion(Stage stage, ContenedorDeClases contenedor, Coordenada coordenadaOrigen, Coordenada coordenadaDestino, Mapa mapa, Label informacion, Label jugadorActual){

        this.tablero = contenedor.obtenerTablero();
        this.coordenadaOrigen = coordenadaOrigen;
        this.coordenadaDestino = coordenadaDestino;
        this.mapa = mapa;
        this.info = informacion;
        this.turno = contenedor.obtenerTurno();
        this.jugadorActual = jugadorActual;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.info.setText("");
        if(tablero.obtenerDuenioUnidad(coordenadaOrigen) == null){
            this.info.setText("\nINFORMACION: No hay unidad ahí.\n");
            return;
        } else if(tablero.obtenerDuenioUnidad(coordenadaOrigen) != turno.obtenerJugadorActual()) {
            this.info.setText("\nINFORMACION: Solo puedes utilizar a tus unidades.\n");
            return;
        }
        if(tablero.estaLibre(coordenadaDestino)){
            try{
                tablero.moverUnidad(coordenadaOrigen, coordenadaDestino);
            } catch (CasilleroNoEsAdyacenteExcepcion excepcion) {
                this.info.setText("\nINFORMACION: Solo se puede mover a adyacentes\n");
            }
            catch (CatapultaNoSePuedeMoverExcepcion exception) {
                this.info.setText("\nINFORMACION: Las cataputas no se mueven\n");
            }
            catch (CasilleroFueraDeRangoExcepcion excepcion) {
                
            }
        } else {
            //Atacar
            try{
                tablero.accionConUnidad(coordenadaOrigen, coordenadaDestino);
            } catch (AtacarAliadoExcepcion excepcion) {
                this.info.setText("\nNo se puede atacar a aliados\n");
            }
            catch (CurarEnemigoExcepcion exception){
                this.info.setText("\nNo puedes curar a una unidad enemiga\n");
            }
            catch (CatapultaCuracionException excepcion){
                this.info.setText("\nNo puedes curar una catapulta\n");
            }

        }

        if(turno.obtenerGanador() != null){
            VentanaEmergenteGanador ventana = new VentanaEmergenteGanador(stage);
            ventana.mostrarGanador(turno.obtenerJugadorActual());
            return;
        }

        turno.cambiarTurno();
        jugadorActual.setText(turno.obtenerJugadorActual().obtenerNombre());
        mapa.actualizarTableroBatalla();

    }
}
