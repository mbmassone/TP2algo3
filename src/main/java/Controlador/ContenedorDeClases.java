package Controlador;

import Modelo.Jugador;
import Modelo.Tablero.Tablero;
import Modelo.Unidad;

public class ContenedorDeClases {

    Tablero tablero;
    Jugador j1;
    Jugador j2;

    public ContenedorDeClases(String nombreJugador1, String nombreJugador2){
        this.j1 = new Jugador(nombreJugador1);
        this.j2 = new Jugador(nombreJugador2, j1);
        this.j1.agregarEnemigo(j2);

        this.tablero = new Tablero(j1, j2);
    }

    public Tablero obtenerTablero(){
        return this.tablero;
    }



    public Jugador obtenerJugador(String nombreJugador) {
        if (j1.obtenerNombre().equals(nombreJugador)) return j1;
        else if (j2.obtenerNombre().equals(nombreJugador)) return j2;
        else return null;
    }

    public int obtenerPuntos(String nombreJugador){
        return obtenerJugador(nombreJugador).obtenerPuntos();
    }

    public Jugador obtenerJugador1(){
        return j1;
    }

    public Jugador obtenerJugador2(){
        return j2;
    }
}
