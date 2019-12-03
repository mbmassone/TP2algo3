package Modelo;

import Modelo.Casillero.Casillero;
import Modelo.Casillero.EnTerritorioAliado;
import Modelo.Casillero.EstadoTerritorio;
import Modelo.Tablero.Direccion;

public abstract class Unidad{
    protected float vida;
    protected int costo;
    protected Casillero casillero;
    protected Jugador duenio;
    protected String nombre;
    protected EstadoTerritorio territorio;

    public Unidad(float vida, int costo, Jugador duenio){
        this.vida = vida;
        this.costo = costo;
        this.duenio = duenio;
        this.territorio = new EnTerritorioAliado();
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

    public void sufrirAtaque(float danio){
        territorio.analizarDanio(this, danio);
    }

    public void descontarVida(float danio){
        this.vida -= danio;
        if(this.vida <= 0){
            this.casillero.destruirUnidad();
            this.duenio.eliminarUnidad();
        }
    }

    public boolean puedeMover(Direccion direccion){
        return this.casillero.obtenerAdyacente(direccion).estaLibre();
    }

    public float getVida(){
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
        territorio.actualizarEstado(this, this.casillero);
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

    public void actualizarEstadoTerritorio(EstadoTerritorio nuevoEstado){
        this.territorio = nuevoEstado;
    }

    public abstract void recibirCuracion(float curacion);
    public abstract void accion(Unidad unidad);
    public abstract void accionCercana(Unidad unidad);
    public abstract void accionMediana(Unidad unidad);
    public abstract void accionLejana(Unidad unidad);
}
