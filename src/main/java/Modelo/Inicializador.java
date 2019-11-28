package Modelo;

import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;

public class Inicializador {
    //Atributos
    private Tablero tablero;

    //Constructor
    public Inicializador(Tablero tablero){
        this.tablero = tablero;
    }

    //Metodos
    public void agregarUnidad(Jugador jugador, Coordenada coordenada, Unidad unidad){
        if(unidad.descontarCosto(jugador.obtenerPuntos() ) >= 0){
            tablero.agregarUnidad(coordenada, unidad);
            jugador.agregarUnidad(unidad);
        }
    }
}