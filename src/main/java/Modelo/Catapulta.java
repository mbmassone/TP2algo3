package Modelo;
import Modelo.Casillero.Casillero;
import Modelo.Tablero.Direccion;
import Modelo.Unidad;

public class Catapulta extends Unidad{
    private int danioCercano;
    private int danioLejano;

    public Catapulta(Jugador duenio, Casillero casillero){
        super(50,5, casillero, duenio);
        danioCercano = 0;
        danioLejano = 20;
    }

    @Override
    public void accion(Unidad unidad) {
        int danio;
        if (this.casillero.caluclarDistancia(unidad.casillero) >= 6){
            danio = danioLejano;
        }
        else{
            danio = danioCercano;
        }
        unidad.sufrirAtaque(danio);
        //hacer danio adyacentes.
    }

    @Override
    public void mover(Direccion direccion) {
        throw new CatapultaNoSePuedeMoverExcepcion();
    }

    @Override
    public void recibirCuracion(int curacion){
        throw new CatapultaCuracionException();
    }
}
