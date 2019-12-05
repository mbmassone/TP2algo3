package Modelo.Unidad.Distancia;

import Modelo.Unidad.Unidad;

public class DistanciaCercana extends TipoDistancia {

    @Override
    public void aplicarAccion(Unidad actual, Unidad objetivo) {
        actual.accionCercana(objetivo);
    }
}
