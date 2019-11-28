package Controlador;

import Modelo.Jugador;

public class ControladorTurno {
    Jugador jugador1;
    Jugador jugador2;
    Jugador actual;

    public ControladorTurno(Jugador jugador1, Jugador jugador2){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;

        this.actual = jugador1; //Siempre empieza el jugador1.
    }

    public String jugadorActual(){
        return this.actual.obtenerNombre();
    }

    public boolean siguienteTurno(){
        this.actual = actual.obtenerEnemigo();
        return jugador1.esGanador() || jugador2.esGanador();
    }

    public String obtenerGanador(){
        if(jugador1.esGanador()) return jugador1.obtenerNombre();
        else return jugador2.obtenerNombre();
    }
}
