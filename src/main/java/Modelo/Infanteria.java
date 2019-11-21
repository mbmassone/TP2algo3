package Modelo;

import Modelo.Casillero.IdentificadorDeInfanterias;
import Modelo.Casillero.Casillero;
import Modelo.Casillero.IdentificadorDeInfanterias;
import Modelo.Tablero.Direccion;
import java.util.List;

public class Infanteria extends Atacante {

    public Infanteria(Jugador duenio){
        super(100,1, duenio);
        this.danioCercano = 10;
        this.danioMediano = 0;
        this.danioLejano = 0;
    }


    @Override
    public void recibirCuracion(int curacion) {
        this.vida += curacion;
    }

    @Override
    public boolean esInfanteria(){
        return true;
    }

    @Override
    public void mover(Direccion direccion){
        List<Unidad> listaInfanteria;
        listaInfanteria = this.casillero.encontrarUnidadesEnCadena(new IdentificadorDeInfanterias( this.obtenerDuenio() ) );

        if (listaInfanteria.size() >= 3) { //Batallon
            for (int i = 0; i < 3; i++) {
                Infanteria infanteria = (Infanteria)listaInfanteria.get(i);
                infanteria.moverInfanteria(direccion);
            }
        }
        else{ //No hay batallon,se mueve solo una Infanteria.
            this.moverInfanteria(direccion);
        }
    }


    public void moverInfanteria(Direccion direccion){
        super.mover(direccion);
    }

}


