package Modelo;
import Modelo.Casillero.IdentificadorDeUnidades;
import Modelo.Casillero.Casillero;
import Modelo.Tablero.Direccion;

import java.util.List;

public class Catapulta extends Atacante{

    public Catapulta(Jugador duenio){
        super(50,5, duenio);
        this.nombre = "catapulta";
        danioCercano = 0;
        danioMediano = 0;
        danioLejano = 20;
    }

    @Override
    public void recibirCuracion(int curacion){
        throw new CatapultaCuracionException();
    }

    @Override
    public void mover(Direccion direccion){
        throw new CatapultaNoSePuedeMoverExcepcion();
    }

    @Override
    public void accionLejana(Unidad unidad) {
        List<Unidad> listaUnidad;
        listaUnidad = unidad.casillero.encontrarUnidadesEnCadena(new IdentificadorDeUnidades());

        for (Unidad unidadEnLista: listaUnidad) {
            unidadEnLista.sufrirAtaque(danioLejano);
        }
    }

}
