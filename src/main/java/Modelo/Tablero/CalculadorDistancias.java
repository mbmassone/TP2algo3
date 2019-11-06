package Modelo.Tablero;

import Modelo.Casillero.Casillero;
import Modelo.Tablero.Tablero;

public class CalculadorDistancias {

    private Tablero tablero;

    public CalculadorDistancias(Tablero tablero){
        this.tablero = tablero;
    }

    public int calcularDistancia(Casillero casillero1, Casillero casillero2){
        int[] coordenadas1 = tablero.obtenerCoordenadasCasillero(casillero1);
        int[] coordenadas2 = tablero.obtenerCoordenadasCasillero(casillero2);

        return Math.max(Math.abs(coordenadas2[0] - coordenadas1[0]), Math.abs((coordenadas2[1] - coordenadas1[1])));
    }
}
