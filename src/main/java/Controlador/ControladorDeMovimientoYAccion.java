package Controlador;

import Modelo.AtacarAliadoExcepcion;
import Modelo.Casillero.CasilleroNoEsAdyacenteExcepcion;
import Modelo.CatapultaNoSePuedeMoverExcepcion;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;
import Modelo.Turno;
import Vista_api.Mapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControladorDeMovimientoYAccion implements EventHandler<ActionEvent> {

    private Tablero tablero;
    private Turno turno;
    private Coordenada coordenadaOrigen;
    private Coordenada coordenadaDestino;
    private Mapa mapa;

    public ControladorDeMovimientoYAccion(ContenedorDeClases contenedor, Coordenada coordenadaOrigen, Coordenada coordenadaDestino, Mapa mapa){

        this.tablero = contenedor.obtenerTablero();
        //this.turno = contenedor.obtenerTurno(); TODO se podria chequear el turno para mover/atacar.
        this.coordenadaOrigen = coordenadaOrigen;
        this.coordenadaDestino = coordenadaDestino;
        this.mapa = mapa;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(tablero.estaLibre(coordenadaDestino)){
            //Moverse
            try{
                tablero.moverUnidad(coordenadaOrigen, coordenadaDestino);
            } catch (CasilleroNoEsAdyacenteExcepcion excepcion) {
                System.out.println("Solo se puede mover a adyacentes"); //TODO avisar a usuario.
            }
            catch (CatapultaNoSePuedeMoverExcepcion exception) {
                System.out.println("Las cataputas no se mueven"); //TODO avisar a usuario.
            }
        } else {
            //Atacar
            try{
                tablero.accionConUnidad(coordenadaOrigen, coordenadaDestino);
            } catch (AtacarAliadoExcepcion excepcion) {
                System.out.println("No se puede atacar a aliados"); //TODO avisar a usuario.
            }
        }

        mapa.actualizarTableroBatalla();
    }
}
