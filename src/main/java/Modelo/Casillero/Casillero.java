package Modelo.Casillero;

import Modelo.Bando;
import Modelo.Direccion;
import Modelo.Tablero.CalculadorDistancias;
import Modelo.Unidad;

import java.util.HashMap;

public class Casillero {
    //Atributos
    private HashMap<Direccion, Casillero> adyacentes;
    private Bando bando;
    Unidad unidad; //Solo la pueden acceder clases en el paquete Casillero.
    private EstadoCasilla estado;
    private CalculadorDistancias calculadorDistancias;

    //Metodos
    public Casillero(Bando bando, CalculadorDistancias calculadorDistancias){
        this.bando = bando;
        this.estado = new Libre();
        this.adyacentes = new HashMap<Direccion, Casillero>();
        this.calculadorDistancias = calculadorDistancias;
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

    public void moverUnidad(Casillero nuevoCasillero) {
        //TODO
    }

    public void agregarAdyacente(Direccion direccion, Casillero casillero){
        this.adyacentes.put(direccion, casillero);
    }

    public void actualizarEstado(EstadoCasilla nuevoEstado){
        this.estado = nuevoEstado;
    }

    public Casillero obtenerAdyacente(Direccion direccion){
        return this.adyacentes.get(direccion);
    }

    public int caluclarDistancia(Casillero casillero){
        return this.calculadorDistancias.calcularDistancia(this, casillero);
    }

    public Bando obtenerBando() {
        return this.bando;
    }
}
