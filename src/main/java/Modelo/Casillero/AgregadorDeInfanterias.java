package Modelo.Casillero;

public class AgregadorDeInfanterias implements Agregador{

    @Override
    public boolean debeAgregarALista(Casillero casillero) {
        return casillero.obtenerUnidad().esInfanteria();
    }
}
