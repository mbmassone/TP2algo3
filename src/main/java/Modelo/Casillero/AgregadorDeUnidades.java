package Modelo.Casillero;

public class AgregadorDeUnidades implements Agregador {
    @Override
    public boolean debeAgregarALista(Casillero casillero) {
        return !casillero.estaLibre();
    }
}
