package Modelo;


public class Jugador {
    //Atributos
    private String nombre;
    private int puntos = 20;
    private int cantidadUnidades;
    private Bando bando;

    //Constructor
    public Jugador(String nombre, Bando bando){
        this.nombre = nombre;
        this.cantidadUnidades = 0;
        this.bando = bando;
    }

    //Métodos
    public String obtenerNombre(){
        return nombre;
    }

    public void asignarPuntos(int puntos){
        this.puntos = puntos;
    }

    public void agregarUnidad(Unidad unidad){
        if(unidad.descontarCosto(puntos) >= 0) {
            asignarPuntos(unidad.descontarCosto(puntos) );
            (this.cantidadUnidades)++;
        }
    }

    public int obtenerPuntos() { return puntos; }

    public int obtenerCantidadUnidades(){ return cantidadUnidades; }

    public void eliminarGuerrero(){
        this.cantidadUnidades--;
    }
}
