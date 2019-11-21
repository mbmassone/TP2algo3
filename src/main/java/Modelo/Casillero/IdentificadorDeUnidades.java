package Modelo.Casillero;

public class IdentificadorDeUnidades implements Identificador {
    @Override
    public boolean esDeLosBuscados(Casillero casillero) {
        return !casillero.estaLibre();
    }
}
