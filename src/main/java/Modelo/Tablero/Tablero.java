package Modelo.Tablero;

import Modelo.Casillero.Casillero;
import Modelo.Jugador;
import Modelo.Unidad;

import java.util.ArrayList;

public class Tablero {
    //Atributos
    private ArrayList<Casillero> tablero; //Lo hago como una lista, cualquier cosa lo cambiamos.
    private int TAMANIO = 20;
    Jugador j1;
    Jugador j2;

    //Constructor
    public Tablero(Jugador j1, Jugador j2){
        this.j1 = j1;
        this.j2 = j2;
        Jugador aux;

        this.tablero = new ArrayList<Casillero>();

        CalculadorDistancias calculadorDistancias = new CalculadorDistancias(this);
        //Inicializo la lista con casilleros
        for(int i = 0; i < TAMANIO*TAMANIO; i++){
            if (i < (TAMANIO * TAMANIO) / 2) {
                aux = this.j1;
            } else {
                aux = this.j2;
            }
            this.tablero.add(new Casillero(aux, calculadorDistancias));
        }

        //Inicializo los adyacentes
        for (int i = 0; i < this.tablero.size(); i++) {
            inicializarAdyacentes(i, this.tablero.get(i));
        }
    }

    //Metodos
    private void inicializarAdyacentes(int indice, Casillero casillero){
        for(Direccion direccion: Direccion.values()){
            int defasaje = direccion.obtenerDefasaje(TAMANIO);
            if(indice + defasaje >= 0 && indice + defasaje < TAMANIO*TAMANIO){
                this.tablero.get(indice).agregarAdyacente(direccion, this.tablero.get(indice + defasaje));
            }
        }
    }

    public void agregarUnidad(Coordenada coordenada, Unidad unidad){
        Casillero casillero = obtenerCasillero(coordenada);
        if(casillero.obtenerDuenio() != unidad.obtenerDuenio() ){
            throw new UnidadAgregadaEnSectorEnemigoExcepcion();
        }
        unidad.agregarCasillero(casillero);
        casillero.agregarUnidad(unidad);
    }

    private Casillero obtenerCasillero(Coordenada coordenada) {
        //Como usamos una lista la forma de conseguir un casillero sería esta.
        // Si lo cambiamos a un diccionario solo tenemos que cambiar este método y la inicializacion.
        int indice = TAMANIO * coordenada.obtenerFila() + coordenada.obtenerColumna();
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

    public boolean estaLibre(Coordenada coordenada){
        return obtenerCasillero(coordenada).estaLibre();
    }

    public void accionConUnidad(Coordenada coordenada, Coordenada coordenadaObjetivo){
        Unidad unidadObjetivo = obtenerCasillero(coordenadaObjetivo).obtenerUnidad();
        obtenerCasillero(coordenada).accionConUnidad(unidadObjetivo);
    }

    public void moverUnidad(Coordenada coordenada, Coordenada nuevaCoordenada){
        Casillero actualCasillero = obtenerCasillero(coordenada);
        Casillero nuevoCasillero = obtenerCasillero(nuevaCoordenada);

        Direccion direccion = actualCasillero.obtenerDireccionDeAdyacente(nuevoCasillero);
        actualCasillero.moverUnidad(direccion);
    }
}
