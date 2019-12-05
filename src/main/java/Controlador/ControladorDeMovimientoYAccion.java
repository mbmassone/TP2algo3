package Controlador;

import Modelo.*;
import Modelo.Casillero.CasilleroNoEsAdyacenteExcepcion;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;
import Vista_api.Mapa;
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

    public ControladorDeMovimientoYAccion(ContenedorDeClases contenedor, Coordenada coordenadaOrigen, Coordenada coordenadaDestino, Mapa mapa, Label informacion){

        this.tablero = contenedor.obtenerTablero();
        //this.turno = contenedor.obtenerTurno(); TODO se podria chequear el turno para mover/atacar.
        this.coordenadaOrigen = coordenadaOrigen;
        this.coordenadaDestino = coordenadaDestino;
        this.mapa = mapa;
        this.info = informacion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //Limpiar el panel de informacion
        this.info.setText("");
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

        mapa.actualizarTableroBatalla();
    }
}
