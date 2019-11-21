package Modelo;
import Modelo.Casillero.Casillero;
import Modelo.Casillero.IdentificadorDeEnemigos;
import Modelo.Casillero.IdentificadorDeInfanterias;
import Modelo.Unidad;

public class Jinete extends Atacante {

    public Jinete(Jugador duenio){
        super(100,3, duenio);
        this.danioCercano = 5;
        this.danioMediano = 15;
        this.danioLejano = 0;
    }


    private boolean atacaADistancia(){ //TODO Hacer con un patron de Strategy
        return this.casillero.hayUnidadesADistanciaCercana(new IdentificadorDeInfanterias(this.duenio)) || !this.casillero.hayUnidadesADistanciaCercana(new IdentificadorDeEnemigos(this.duenio));
    }

    @Override
    public void accionCercana(Unidad unidad){
        if(!this.atacaADistancia()) {
            unidad.sufrirAtaque(danioCercano);
        }
    }

    @Override
    public void accionMediana(Unidad unidad){
        if(this.atacaADistancia()) {
            unidad.sufrirAtaque(danioMediano);
        }
    }

    @Override
    public void recibirCuracion(int curacion){
        vida += curacion;
    }
}
