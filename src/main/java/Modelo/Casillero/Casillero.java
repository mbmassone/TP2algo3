package Modelo.Casillero;

import Modelo.*;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Direccion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Casillero {
    //Atributos
    private HashMap<Direccion, Casillero> adyacentes;
    private Jugador duenio;
    Unidad unidad; //Solo la pueden acceder clases en el paquete Casillero.
    private EstadoCasilla estado;
    private Coordenada coordenada;

    //Metodos
    public Casillero(){
        this.estado = new Libre();
        this.adyacentes = new HashMap<Direccion, Casillero>();
        //TODO hacer con mocks.
    }

    public Casillero(Jugador duenio, Coordenada coordenada){
        this.duenio = duenio;
        this.estado = new Libre();
        this.adyacentes = new HashMap<Direccion, Casillero>();
        this.coordenada = coordenada;
    }

    public void agregarUnidad(Unidad unidad) {
        this.estado.agregarUnidad(this, unidad);
    }

    public Unidad obtenerUnidad() {
        return this.unidad;
    }

    public boolean estaLibre() {
        return this.estado.estaVacia();
    }

    public void accionConUnidad(Unidad unidad) {
        this.unidad.accion(unidad);
    }

    public void moverUnidad(Direccion direccion) {
        this.unidad.mover(direccion);
    }

    public void agregarAdyacente(Direccion direccion, Casillero casillero){
        this.adyacentes.put(direccion, casillero);
    }

    public void actualizarEstado(EstadoCasilla nuevoEstado){
        this.estado = nuevoEstado;
    }

    public Casillero obtenerAdyacente(Direccion direccion){
        Casillero adyacente =  this.adyacentes.get(direccion);

        if(adyacente == null){
            throw new CasilleroFueraDeRangoExcepcion();
        }
        return adyacente;

    }

    public Coordenada obtenerCoordenada() {
        return this.coordenada;
    }

    public Jugador obtenerDuenio() {
        return this.duenio;
    }

    public void destruirUnidad(){
        this.estado.destruirUnidad(this);
    }

    public Direccion obtenerDireccionDeAdyacente(Casillero casillero){
        for(Map.Entry<Direccion, Casillero> adyacente: this.adyacentes.entrySet()){
            if(adyacente.getValue() == casillero){
                return adyacente.getKey();
            }
        }
        throw new CasilleroNoEsAdyacenteExcepcion();
    }

    public boolean hayAdyacenteEnDireccion(Direccion direccion){
        return adyacentes.get(direccion) != null;
    }

    public List<Unidad> encontrarUnidadesEnCadena(Identificador identificador){
        //TODO Cambiar a su propia clase.
        List<Unidad> listaUnidades = new ArrayList<>();
        this.encontrarUnidadesEnCadenaRec(listaUnidades, identificador);

        return listaUnidades;
    }

    private void encontrarUnidadesEnCadenaRec(List<Unidad> listaUnidades, Identificador identificador) {
        if(this.estaLibre()){
            return;
        } else {
            if(listaUnidades.contains(this.obtenerUnidad())){
                return;
            } else if(identificador.esDeLosBuscados(this)){
                listaUnidades.add(this.obtenerUnidad());
                for(Direccion direccion: Direccion.values()){
                    if(this.hayAdyacenteEnDireccion(direccion)){
                        this.obtenerAdyacente(direccion).encontrarUnidadesEnCadenaRec(listaUnidades, identificador);
                    }
                }
            } else {
                return;
            }
        }
    }

    public boolean hayUnidadesADistanciaCercana(Identificador identificador){
        List<Casillero> visitados = new ArrayList<>();
        return this.hayUnidadesADistanciaCercanaRec(visitados, identificador, this);
    }

    private boolean hayUnidadesADistanciaCercanaRec(List<Casillero> visitados, Identificador identificador, Casillero inicial) {
        if(!this.obtenerTipoDistancia(inicial).equals(new DistanciaCercana())) return false;
        if(visitados.contains(this)) return false;
        if(this != inicial && identificador.esDeLosBuscados(this)) return true;

        visitados.add(this);
        Boolean hayCercanos = false;
        for (Direccion direccion: Direccion.values()) {
            if(this.hayAdyacenteEnDireccion(direccion)){
                hayCercanos = hayCercanos || this.obtenerAdyacente(direccion).hayUnidadesADistanciaCercanaRec(visitados, identificador, inicial);
            }
        }

        return hayCercanos;
    }

    public TipoDistancia obtenerTipoDistancia(Casillero casillero) {
        //TODO refactorizar y hacer con polimorfismo
        int distancia = this.coordenada.calcularDistancia(casillero.obtenerCoordenada());
        if(distancia < 3) return new DistanciaCercana();
        else if (distancia < 6) return new DistanciaMediana();
        else return new DistanciaLejana();
    }

    public String obtenerContenido() {
        return estado.obtenerContenido(this);
    }
}
