package Modelo.Casillero;

import Modelo.Jugador;
import Modelo.Tablero.Direccion;
import Modelo.Tablero.CalculadorDistancias;
import Modelo.Unidad;

import java.util.HashMap;
import java.util.Map;

public class Casillero {
    //Atributos
    private HashMap<Direccion, Casillero> adyacentes;
    private Jugador duenio;
    Unidad unidad; //Solo la pueden acceder clases en el paquete Casillero.
    private EstadoCasilla estado;
    private CalculadorDistancias calculadorDistancias;

    //Metodos
    public Casillero(){
        this.estado = new Libre();
        //TODO hacer con mocks.
    }

    public Casillero(Jugador duenio, CalculadorDistancias calculadorDistancias){
        this.duenio = duenio;
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

    public int caluclarDistancia(Casillero casillero){
        return this.calculadorDistancias.calcularDistancia(this, casillero);
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
}
