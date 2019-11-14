package Modelo;

public class DistanciaCercana extends TipoDistancia {

    @Override
    public void aplicarAccion(Unidad actual, Unidad objetivo) {
        actual.accionCercana(objetivo);
    }
}
