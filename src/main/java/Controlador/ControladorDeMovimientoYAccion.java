package Controlador;

import Modelo.AtacarAliadoExcepcion;
import Modelo.Casillero.CasilleroNoEsAdyacenteExcepcion;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;
import Modelo.Turno;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ControladorDeMovimientoYAccion implements EventHandler<MouseEvent> {

    private Tablero tablero;
    private Turno turno;
    private Coordenada coordenadaOrigen;
    private Coordenada coordenadaDestino;

    public ControladorDeMovimientoYAccion(ContenedorDeClases contenedor, Coordenada coordenadaOrigen, Coordenada coordenadaDestino){

        this.tablero = contenedor.obtenerTablero();
        //this.turno = contenedor.obtenerTurno(); TODO se podria chequear el turno para mover/atacar.
        this.coordenadaOrigen = coordenadaOrigen;
        this.coordenadaDestino = coordenadaDestino;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if(tablero.estaLibre(coordenadaDestino)){
            //Moverse
            try{
                tablero.moverUnidad(coordenadaOrigen, coordenadaDestino);
            } catch (CasilleroNoEsAdyacenteExcepcion excepcion) {
                System.out.println("Solo se puede mover a adyacentes"); //TODO avisar a usuario.
            }
        } else {
            //Atacar
            try{
                tablero.accionConUnidad(coordenadaOrigen, coordenadaDestino);
            } catch (AtacarAliadoExcepcion excepcion) {
                System.out.println("No se puede atacar a aliados"); //TODO avisar a usuario.
            }
        }
    }
}
