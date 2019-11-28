package Controlador;

import Modelo.Jugador;
import Modelo.Tablero.Tablero;

public class ControladorInicializadorDeClases {

    Tablero tablero;
    Jugador j1;
    Jugador j2;

    public ControladorInicializadorDeClases(String nombreJugador1, String nombreJugador2){
        this.j1 = new Jugador(nombreJugador1);
        this.j2 = new Jugador(nombreJugador2, j1);
        this.j1.agregarEnemigo(j2);

        this.tablero = new Tablero(j1, j2);
    }

    public Tablero obtenerTablero(){
        return this.tablero;
    }

}
