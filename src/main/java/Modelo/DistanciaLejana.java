package Modelo;

public class DistanciaLejana extends TipoDistancia {

    @Override
    public void aplicarAccion(Unidad actual, Unidad objetivo) {
        actual.accionLejana(objetivo);
    }
}
