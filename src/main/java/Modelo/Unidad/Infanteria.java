package Modelo.Unidad;

import Modelo.Casillero.IdentificadorDeInfanterias;
import Modelo.Jugador.Jugador;
import Modelo.Tablero.Direccion;
import java.util.List;

public class Infanteria extends Atacante {

    public Infanteria(Jugador duenio){
        super(100,1, duenio);
        this.nombre = "infanteria";
        this.danioCercano = 10;
        this.danioMediano = 0;
        this.danioLejano = 0;
    }


    @Override
    public void recibirCuracion(float curacion) {
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

        if (listaInfanteria.size() >= 3) {
            for (int i = 0; i < 3; i++) {
                Unidad infanteria = listaInfanteria.get(i);
                infanteria.doMover(direccion);
            }
        }
        else{ //No hay batallon,se mueve solo una Infanteria.
            this.doMover(direccion);
        }
    }

}


