package Modelo;

public class DistanciaMediana extends TipoDistancia {

    @Override
    public void aplicarAccion(Unidad actual, Unidad objetivo) {
        actual.accionMediana(objetivo);
    }
}
