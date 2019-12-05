package Modelo.Unidad.Distancia;

import Modelo.Unidad.Unidad;

public class DistanciaLejana extends TipoDistancia {

    @Override
    public void aplicarAccion(Unidad actual, Unidad objetivo) {
        actual.accionLejana(objetivo);
    }
}
