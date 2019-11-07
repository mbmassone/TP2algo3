package Modelo.Jugador;

import Modelo.Unidad;

public class Jugador {
    //Atributos
    private String nombre;
    private int puntos = 20;
    private EstadoJugador estado;
    private int cantidadUnidades;

    //Constructor
    public Jugador(String nombre){
        this.nombre = nombre;
        this.cantidadUnidades = 0;
        this.estado = new EnJuego();
    }

    //Métodos
    public String obtenerNombre(){
        return nombre;
    }

    public void asignarPuntos(int puntos){
        this.puntos = puntos;
    }

    public void agregarUnidad(Unidad unidad) throws JugadorConPuntosInsuficientesExcepcion {
        if(unidad.descontarCosto(puntos) < 0) {
            throw new JugadorConPuntosInsuficientesExcepcion();
        }
        asignarPuntos(unidad.descontarCosto(puntos) );
        (this.cantidadUnidades)++;
    }

    public int obtenerPuntos() { return puntos; }

    public int obtenerCantidadUnidades(){ return cantidadUnidades; }

    public void chequearEstado(){
        this.estado = this.estado.actualizarEstado(this.estado, this.cantidadUnidades);
        this.estado.consultarEstado();
    }

    public void eliminarGuerrero(){
        this.cantidadUnidades--;
    }
}
