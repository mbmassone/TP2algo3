package Modelo;
import Modelo.Casillero.Casillero;
import Modelo.Tablero.Direccion;
import Modelo.Unidad;

public class Catapulta extends Atacante{

    public Catapulta(Jugador duenio){
        super(50,5, duenio);
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
}
