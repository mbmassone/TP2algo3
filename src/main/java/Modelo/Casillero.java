package Modelo;

import java.util.HashMap;

public class Casillero {
    //Atributos
    private HashMap<Direccion, Casillero> adyacentes;
    private Unidad unidad;
    private EstadoCasilla estado;//TODO

    //Metodos
    public Casillero(){
        this.adyacentes = new HashMap<Direccion, Casillero>();
    }

    public void agregarUnidad(Unidad unidad) {
        this.unidad = unidad;
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

    public void moverUnidad(Casillero nuevoCasillero) {
        //TODO
    }

    public void agregarAdyacente(Direccion direccion, Casillero casillero){
        this.adyacentes.put(direccion, casillero);
    }

    public Casillero obtenerAdyacente(Direccion direccion){
        return this.adyacentes.get(direccion);
    }
}
