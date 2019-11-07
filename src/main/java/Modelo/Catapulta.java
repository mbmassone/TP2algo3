package Modelo;
import Modelo.Casillero.Casillero;
import Modelo.Unidad;

public class Catapulta extends Unidad{
    private int danioCercano;
    private int danioLejano;

    public Catapulta(Bando bando, Casillero casillero){
        super(50,5,casillero,bando);
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
    public boolean mover(int filaNueva, int columnaNueva) {
        return false;
    }

    @Override
    public void recibirCuracion(int curacion){
        throw new CatapultaCuracionException();
    }
}
