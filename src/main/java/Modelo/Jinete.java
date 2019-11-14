package Modelo;
import Modelo.Casillero.Casillero;
import Modelo.Unidad;

public class Jinete extends Unidad {
    private int danioCercano;
    private int danioMediano;
    private int danioLejano;

    public Jinete(Jugador duenio, Casillero casillero){
        super(100,3, casillero, duenio);
        this.danioCercano = 5;
        this.danioMediano = 15;
        this.danioLejano = 0;
    }

    @Override
    public void accion(Unidad unidad){
        super.atacaAliado(unidad);
        TipoDistancia tipoDistancia = this.casillero.getTipoDistancia(unidad.casillero); //Devuelve un hijo de TipoDistancia.
        tipoDistancia.aplicarAccion(this,unidad);
    }

    @Override
    public void accionCercana(Unidad unidad){
        unidad.sufrirAtaque(danioCercano);
    }

    @Override
    public void accionMediana(Unidad unidad){
        unidad.sufrirAtaque(danioMediano);
    }

    @Override
    public void accionLejana(Unidad unidad){
        unidad.sufrirAtaque(danioLejano);
    }


    @Override
    public void recibirCuracion(int curacion){
        vida += curacion;
    }
}
