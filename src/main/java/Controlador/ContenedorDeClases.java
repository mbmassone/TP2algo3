package Controlador;

import Modelo.Jugador.Jugador;
import Modelo.Tablero.Tablero;
import Modelo.Turno;

public class ContenedorDeClases {

    Tablero tablero;
    Jugador j1;
    Jugador j2;
    Turno turno;

    public ContenedorDeClases(String nombreJugador1, String nombreJugador2){
        this.j1 = new Jugador(nombreJugador1);
        this.j2 = new Jugador(nombreJugador2, j1);
        this.j1.agregarEnemigo(j2);

        this.turno = new Turno(j1, j2);

        this.tablero = new Tablero(j1, j2);
    }

    public Tablero obtenerTablero(){
        return this.tablero;
    }

    public Jugador obtenerJugador1(){
        return j1;
    }

    public Jugador obtenerJugador2(){
        return j2;
    }

    public Turno obtenerTurno() {
        return this.turno;
    }
}
