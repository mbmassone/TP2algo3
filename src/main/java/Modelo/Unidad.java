package Modelo;

import Modelo.Casillero.Casillero;
import Modelo.Tablero.Direccion;

public abstract class Unidad{
    protected int vida;
    protected int costo;
    protected Casillero casillero;
    protected Jugador duenio;
    protected String nombre;

    public Unidad(int vida, int costo, Jugador duenio){
        this.vida = vida;
        this.costo = costo;
        this.duenio = duenio;
    }

    public String obtenerNombre(){ return nombre; }

    public void asignarCasillero(Casillero casillero){
        this.casillero = casillero;
    }

    public int descontarCosto(int puntos){
        return puntos - costo;
    }

    public Jugador obtenerDuenio(){
        return this.duenio;
    }

    public Casillero obtenerCasillero(){
        return this.casillero;
    }

    public void sufrirAtaque(int danio){
        this.vida -= danio;
        if(this.vida <= 0){
            this.casillero.destruirUnidad();
        }
    }

    public boolean puedeMover(Direccion direccion){
        //TODO usar esta funcion para eliminar excepciones
        return this.casillero.obtenerAdyacente(direccion).estaLibre();
    }

    public int getVida(){
        return this.vida;
    }

    protected void doMover(Direccion direccion) {
        if (!puedeMover(direccion)){
            return;
        }
        Casillero nuevoCasillero = this.casillero.obtenerAdyacente(direccion);
        nuevoCasillero.agregarUnidad(this);
        this.casillero.destruirUnidad();
        this.casillero = nuevoCasillero;
    }

    public void mover(Direccion direccion){
        this.doMover(direccion);
    }

    public void agregarCasillero(Casillero casillero){
        this.casillero = casillero;
    }

    public void atacaAliado(Unidad unidad){
        if (this.obtenerDuenio() == unidad.obtenerDuenio()){
            throw new AtacarAliadoExcepcion();
        }
    }

    public boolean esInfanteria(){
        return false;
    }

    public void curaEnemigo(Unidad unidad){
        if (this.obtenerDuenio() != unidad.obtenerDuenio()){
            throw new CurarEnemigoExcepcion();
        }
    }

    public abstract void recibirCuracion(int curacion);
    public abstract void accion(Unidad unidad);
    public abstract void accionCercana(Unidad unidad);
    public abstract void accionMediana(Unidad unidad);
    public abstract void accionLejana(Unidad unidad);
}
