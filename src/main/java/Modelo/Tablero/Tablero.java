package Modelo.Tablero;

import Modelo.Bando;
import Modelo.Casillero.Casillero;
import Modelo.Casillero.CasilleroNoEsAdyacenteExcepcion;
import Modelo.Unidad;

import java.util.ArrayList;

public class Tablero {

	//Metodos
    private ArrayList<Casillero> tablero; //Lo hago como una lista, cualquier cosa lo cambiamos.
    private int TAMANIO = 20;

    public Tablero(){
        this.tablero = new ArrayList<Casillero>();
        Bando bando;
        CalculadorDistancias calculadorDistancias = new CalculadorDistancias(this);
        //Inicializo la lista con casilleros
        for(int i = 0; i < TAMANIO*TAMANIO; i++){
            if (i < (TAMANIO * TAMANIO) / 2) {
                bando = Bando.BANDO1;
            } else {
                bando = Bando.BANDO2;
            }
            this.tablero.add(new Casillero(bando, calculadorDistancias));
        }

        //Inicializo los adyacentes
        for (int i = 0; i < this.tablero.size(); i++) {
            inicializarAdyacentes(i, this.tablero.get(i));
        }
    }

    private void inicializarAdyacentes(int indice, Casillero casillero){
        for(Direccion direccion: Direccion.values()){
            int defasaje = direccion.obtenerDefasaje(TAMANIO);
            if(indice + defasaje >= 0 && indice + defasaje < TAMANIO*TAMANIO){
                this.tablero.get(indice).agregarAdyacente(direccion, this.tablero.get(indice + defasaje));
            }
        }
    }

    public void agregarUnidad(int fila, int columna, Unidad unidad){
        Casillero casillero = obtenerCasillero(fila, columna);
        if(casillero.obtenerBando() != unidad.obtenerBando()){
            throw new UnidadAgregadaEnSectorEnemigoExcepcion();
        }
        unidad.agregarCasillero(casillero);
        casillero.agregarUnidad(unidad);
    }

    private Casillero obtenerCasillero(int fila, int columna) {
        //Como usamos una lista la forma de conseguir un casillero sería esta.
        // Si lo cambiamos a un diccionario solo tenemos que cambiar este método y la inicializacion.
        int indice = TAMANIO * fila + columna;
        try{
            return this.tablero.get(indice);
        }catch (IndexOutOfBoundsException error){
            throw new CoordenadaInvalidaExcepcion();
        }
    }

    int[] obtenerCoordenadasCasillero(Casillero casillero){
        int indice = tablero.indexOf(casillero);
        int[] coordenada = new int[2];
        coordenada[0] = indice % TAMANIO;
        coordenada[1] = indice - coordenada[0] * TAMANIO;

        return coordenada;
    }

    public boolean estaLibre(int fila, int columna){
        return obtenerCasillero(fila, columna).estaLibre();
    }

    public void accionConUnidad(int fila, int columna, int filaObjetivo, int columnaObjetivo){
        Unidad unidadObjetivo = obtenerCasillero(filaObjetivo, columnaObjetivo).obtenerUnidad();
        obtenerCasillero(fila, columna).accionConUnidad(unidadObjetivo);
    }

    public void moverUnidad(int fila, int columna, int nuevaFila, int nuevaColumna){
        Casillero actualCasillero = obtenerCasillero(fila, columna);
        Casillero nuevoCasillero = obtenerCasillero(nuevaFila, nuevaColumna);

        Direccion direccion = actualCasillero.obtenerDireccionDeAdyacente(nuevoCasillero);
        actualCasillero.moverUnidad(direccion);
    }
}
