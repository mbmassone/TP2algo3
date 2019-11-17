package Modelo;

public abstract class TipoDistancia {
    public abstract void aplicarAccion(Unidad actual,Unidad objetivo);

    @Override
    public boolean equals(Object o){
        return this.getClass().equals(o.getClass());
    }
}
