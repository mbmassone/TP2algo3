package Modelo.Unidad.Distancia;

import Modelo.Unidad.Unidad;

public abstract class TipoDistancia {
    public abstract void aplicarAccion(Unidad actual, Unidad objetivo);

    @Override
    public boolean equals(Object o){
        return this.getClass().equals(o.getClass());
    }
}
