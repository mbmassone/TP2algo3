package Controlador;

import Modelo.*;
import Modelo.Casillero.CasilleroNoEsAdyacenteExcepcion;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;
import Vista_api.Mapa;
import Vista_api.RecursosClass.VentanaEmergenteGanador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ControladorDeMovimientoYAccion implements EventHandler<ActionEvent> {

    private Tablero tablero;
    private Turno turno;
    private Coordenada coordenadaOrigen;
    private Coordenada coordenadaDestino;
    private Mapa mapa;
    private Label info;
    private Label jugadorActual;

    public ControladorDeMovimientoYAccion(ContenedorDeClases contenedor, Coordenada coordenadaOrigen, Coordenada coordenadaDestino, Mapa mapa, Label informacion, Label jugadorActual){

        this.tablero = contenedor.obtenerTablero();
        this.coordenadaOrigen = coordenadaOrigen;
        this.coordenadaDestino = coordenadaDestino;
        this.mapa = mapa;
        this.info = informacion;
        this.turno = contenedor.obtenerTurno();
        this.jugadorActual = jugadorActual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //Limpiar el panel de informacion
        if(turno.obtenerGanador() != null){
            VentanaEmergenteGanador ventana = new VentanaEmergenteGanador();
            ventana.mostrarGanador(turno.obtenerJugadorActual());
            return;
        }
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

        turno.cambiarTurno();
        jugadorActual.setText(turno.obtenerJugadorActual().obtenerNombre());
        mapa.actualizarTableroBatalla();

    }
}
