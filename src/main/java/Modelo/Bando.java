package Modelo;

public enum Bando{
    BANDO1, BANDO2;

    private Bando opuesto;

    static {
        BANDO1.opuesto = BANDO2;
        BANDO2.opuesto = BANDO1;
    }

    public Bando obtenerBandoContrario(){
        return this.opuesto;
    }
}

