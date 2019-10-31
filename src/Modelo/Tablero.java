package Modelo;

import java.util.Dictionary;
import java.util.Hashtable;

public class Tablero {
    //atributos
    private Unidad[][] tablero;
    private int TAMANIO = 20;


    public Tablero(){
        tablero = new Unidad[TAMANIO][TAMANIO];
    }

    public void agregarUnidad(int fila, int columna, Unidad unidad){
        tablero[fila][columna] = unidad;
    }

    public boolean estaLibre(int fila, int columna){
        return tablero[fila][columna] == null;
    }

    public void accionConUnidad(int fila, int columna, int filaObjetivo, int columnaObjetivo){
        this.tablero[fila][columna].accion(tablero[filaObjetivo][columnaObjetivo]);
    }

    public void moverUnidad(int fila, int columna, int nuevaFila, int nuevaColumna){
        if(tablero[fila][columna].mover(nuevaFila, nuevaColumna)){
            this.tablero[nuevaFila][nuevaColumna] = this.tablero[fila][columna];
            this.tablero[fila][columna] = null;
        }
    }

}
