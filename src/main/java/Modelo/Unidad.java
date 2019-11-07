package Modelo;

import Modelo.Casillero.Casillero;
import Modelo.Tablero.Direccion;

public abstract class Unidad {
    protected int vida;
    protected int costo;
    protected Casillero casillero;
    protected  Bando bando;

    public Unidad(int vida,int costo,Casillero casillero,Bando bando){
        this.vida = vida;
        this.costo = costo;
        this.casillero = casillero;
        this.bando = bando;
    }

    public int descontarCosto(int puntos){
        return puntos - costo;
    }

    public Bando obtenerBando(){
        return this.bando;
    }

    public void sufrirAtaque(int danio){
        vida -= danio;
        if(this.vida <= 0){
            this.casillero.destruirUnidad();
        }
    }

    public int getVida(){
        return this.vida;
    }


    public abstract void recibirCuracion(int curacion);
    public abstract void accion(Unidad unidad);
    public void mover(Direccion direccion){
        Casillero nuevoCasillero = this.casillero.obtenerAdyacente(direccion);
        nuevoCasillero.agregarUnidad(this);
        this.casillero.destruirUnidad();
        this.casillero = nuevoCasillero;
    }

    public void agregarCasillero(Casillero casillero){
        this.casillero = casillero;
    }
}
