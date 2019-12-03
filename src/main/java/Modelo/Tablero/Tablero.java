package Modelo.Tablero;

import Modelo.Casillero.Casillero;
import Modelo.Jugador;
import Modelo.Unidad;

import java.util.HashMap;

public class Tablero {
    //Atributos
    private HashMap<Coordenada, Casillero> tablero; //Lo hago como una lista, cualquier cosa lo cambiamos.
    private int TAMANIO = 20;
    Jugador j1;
    Jugador j2;

    //Constructor
    public Tablero(Jugador j1, Jugador j2){
        this.j1 = j1;
        this.j2 = j2;
        Jugador aux;

        this.tablero = new HashMap<Coordenada, Casillero>();

        //Inicializo la lista con casilleros
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                Coordenada coordenada = new Coordenada(i, j);
                if(i < (TAMANIO/2) ) tablero.put(coordenada, new Casillero(j1, coordenada));
                else tablero.put(coordenada, new Casillero(j2, coordenada));

            }
        }

        //Inicializo los adyacentes
        for (int i = 0; i < TAMANIO; i++) {
            for(int j = 0; j < TAMANIO; j++){
                inicializarAdyacentes(tablero.get(new Coordenada(i,j)));
            }
        }
    }

    //Metodos
    private void inicializarAdyacentes(Casillero casillero){
        for(Direccion direccion: Direccion.values()){
            Casillero adyacente = tablero.get(casillero.obtenerCoordenada().suma(direccion.obtenerDefasaje()));
            casillero.agregarAdyacente(direccion, adyacente);
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
        Casillero casillero = this.tablero.get(coordenada);
        if(casillero == null) throw new CoordenadaInvalidaExcepcion();
        else return casillero;
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

    public String contenidoCasillero(Coordenada coordenada){
        return obtenerCasillero(coordenada).obtenerContenido();
    }

    public Jugador obtenerDuenioUnidad(Coordenada coordenada){
        if(obtenerCasillero(coordenada).estaLibre()){
            return null;
        }
        return obtenerCasillero(coordenada).obtenerUnidad().obtenerDuenio();
    }

    public Jugador obtenerDuenioCasillero(Coordenada coordenada){
        return obtenerCasillero(coordenada).obtenerDuenio();
    }
}
