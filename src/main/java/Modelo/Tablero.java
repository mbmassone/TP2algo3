package Modelo;

import java.util.ArrayList;

import static Modelo.Direccion.*;

public class Tablero {

	//Metodos
    private ArrayList<Casillero> tablero; //Lo hago como una lista, cualquier cosa lo cambiamos.
    private int TAMANIO = 20;

    public Tablero(){
        this.tablero = new ArrayList<Casillero>();

        //Inicializo la matriz con casilleros
        for(int i = 0; i < this.tablero.size(); i++){
            this.tablero.add(new Casillero());
        }

        //Inicializo los adyacentes
        for (int i = 0; i < this.tablero.size(); i++) {
            inicializarAdyacentes(i, this.tablero.get(i));
        }
    }

    private void inicializarAdyacentes(int indice, Casillero casillero){
        //Por ahora lo hago manualmente para probar. TODO refactorizar funcion.
        Casillero casilleroActual = this.tablero.get(indice);

        casilleroActual.agregarAdyacente(ARRIBA, this.tablero.get(indice - TAMANIO));
        casilleroActual.agregarAdyacente(ARRIBADERECHA, this.tablero.get(indice - TAMANIO + 1));
        casilleroActual.agregarAdyacente(DERECHA, this.tablero.get(indice + 1));
        casilleroActual.agregarAdyacente(ABAJODERECHA, this.tablero.get(indice + TAMANIO + 1));
        casilleroActual.agregarAdyacente(ABAJO, this.tablero.get(indice + TAMANIO));
        casilleroActual.agregarAdyacente(ABAJOIZQUIERDA, this.tablero.get(indice + TAMANIO - 1));
        casilleroActual.agregarAdyacente(IZQUIERDA, this.tablero.get(indice - 1));
        casilleroActual.agregarAdyacente(ARRIBAIZQUIERDA, this.tablero.get(indice - TAMANIO - 1));
    }

    public void agregarUnidad(int fila, int columna, Unidad unidad){
        obtenerCasillero(fila, columna).agregarUnidad(unidad);
    }

    private Casillero obtenerCasillero(int fila, int columna) {
        //Como usamos una lista la forma de conseguir un casillero sería esta.
        // Si lo cambiamos a un diccionario solo tenemos que cambiar este método y la inicializacion.
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
