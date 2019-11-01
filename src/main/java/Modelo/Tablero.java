package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

    private List<Casillero> tablero; //Lo hago como una lista, cualquier cosa lo cambiamos.
    private int TAMANIO = 20;

    public Tablero(){
        this.tablero = new ArrayList<Casillero>();
        //TODO Aca creamos todos los casilleros
    }

    public void agregarUnidad(int fila, int columna, Unidad unidad){
        obtenerCasillero(fila, columna).agregarUnidad(unidad);
    }

    private Casillero obtenerCasillero(int fila, int columna) {
        //Como usamos una lista la forma de conseguir un casillero sería esta.
        // Si lo cambiamos a un diccionario solo tenemos que cambiar este método y listo.
        int indice = TAMANIO * fila + columna;
        return this.tablero.get(indice);
    }

    public boolean estaLibre(int fila, int columna){
        return obtenerCasillero(fila, columna).estaLibre();
    }

    public void accionConUnidad(int fila, int columna, int filaObjetivo, int columnaObjetivo){
        Unidad unidadObjetivo = obtenerCasillero(filaObjetivo, columnaObjetivo).obtenerUnidad();
        obtenerCasillero(fila, columna).accionConUnidad(unidadObjetivo);
    }

    public void moverUnidad(int fila, int columna, int nuevaFila, int nuevaColumna){
        Casillero nuevoCasillero = obtenerCasillero(nuevaFila, nuevaColumna);
        obtenerCasillero(fila, columna).moverUnidad(nuevoCasillero);
    }

}
