package Modelo;

import java.util.List;

public class Casillero {
	//Atributos
    private int fila;
    private int columna;
    private List<Casillero> adyacentes;
    private Unidad unidad;
    private EstadoCasilla estado;

    //Metodos
    public Casillero(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
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
}
