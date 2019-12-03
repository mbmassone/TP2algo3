package Modelo;


public class Jugador {
    //Atributos
    private String nombre;
    private int puntos = 20;
    private int cantidadUnidades;
    private Jugador enemigo;

    //Constructores
    public Jugador(String nombre){
        this.nombre = nombre;
        this.cantidadUnidades = 0;
    }

    public Jugador(String nombre, Jugador enemigo){
        this.nombre = nombre;
        this.cantidadUnidades = 0;
        this.enemigo = enemigo;
    }

    public void agregarEnemigo(Jugador enemigo){
        this.enemigo = enemigo;
    }

    public Jugador obtenerEnemigo(){
        return this.enemigo;
    }

    //Métodos
    public String obtenerNombre(){
        return nombre;
    }

    public void asignarPuntos(int puntos){
        this.puntos = puntos;
    }

    public void agregarUnidad(Unidad unidad){
        asignarPuntos(unidad.descontarCosto(puntos) );
        (this.cantidadUnidades)++;
    }

    public boolean sePuedeAgregarUnidad(Unidad unidad){
        if(unidad.descontarCosto(puntos) < 0)
            return false;

        return true;
    }

    public int obtenerPuntos() { return puntos; }

    public int obtenerCantidadUnidades(){ return cantidadUnidades; }

    public void aumentarCantidadUnidades(){ (this.cantidadUnidades)++; }

    public boolean esGanador(){
        return cantidadUnidades == 0;
    }

    public void eliminarUnidad(){
        this.cantidadUnidades--;
    }
}
