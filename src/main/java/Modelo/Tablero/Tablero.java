package Modelo.Tablero;

import Modelo.Casillero.Casillero;
import Modelo.Direccion;
import Modelo.Unidad;

import java.util.ArrayList;

import static Modelo.Direccion.*;

public class Tablero {

	//Metodos
    private ArrayList<Casillero> tablero; //Lo hago como una lista, cualquier cosa lo cambiamos.
    private int TAMANIO = 20;

    public Tablero(){
        this.tablero = new ArrayList<Casillero>();

        //Inicializo la matriz con casilleros
        for(int i = 0; i < TAMANIO*TAMANIO; i++){
            this.tablero.add(new Casillero());
        }

        //Inicializo los adyacentes
        for (int i = 0; i < this.tablero.size(); i++) {
            inicializarAdyacentes(i, this.tablero.get(i));
        }
    }

    private void inicializarAdyacentes(int indice, Casillero casillero){
        for(Direccion direccion: Direccion.values()){
            int defasaje = obtenerDefasaje(direccion);
            if(indice + defasaje >= 0 && indice + defasaje < TAMANIO){
                this.tablero.get(indice).agregarAdyacente(direccion, this.tablero.get(indice + defasaje));
            }
        }
    }

    private int obtenerDefasaje(Direccion direccion){
        //TODO ESTA RE MAL!!!! CAMBIAR LO ANTES POSIBLE
        switch (direccion){
            case ARRIBA: return (-1) * TAMANIO;
            case ARRIBADERECHA: return (-1) * TAMANIO + 1;
            case DERECHA: return 1;
            case ABAJODERECHA: return TAMANIO + 1;
            case ABAJO: return TAMANIO;
            case ABAJOIZQUIERDA: return TAMANIO - 1;
            case IZQUIERDA: return -1;
            case ARRIBAIZQUIERDA: return (-1) * TAMANIO - 1;
        }
        return 0; //Para que no se queje
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
