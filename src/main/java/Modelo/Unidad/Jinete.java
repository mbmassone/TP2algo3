package Modelo.Unidad;
import Modelo.Casillero.IdentificadorDeEnemigos;
import Modelo.Casillero.IdentificadorDeInfanterias;
import Modelo.Jugador.Jugador;

public class Jinete extends Atacante {

    public Jinete(Jugador duenio){
        super(100,3, duenio);
        this.nombre = "jinete";
        this.danioCercano = 5;
        this.danioMediano = 15;
        this.danioLejano = 0;
    }


    private boolean atacaADistancia(){
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
    public void recibirCuracion(float curacion){
        vida += curacion;
    }
}
