package Modelo.Tablero;

public enum Direccion{
    ARRIBA(-1, 0), ARRIBADERECHA(-1,1), DERECHA(0,1), ABAJODERECHA(1,1), ABAJO(1,0), ABAJOIZQUIERDA(1,-1), IZQUIERDA(0, -1), ARRIBAIZQUIERDA(-1,-1);

    private int defasajeConstante;
    private int multiplicador;

    Direccion(int multiplicador, int defasajeConstante) {
        this.multiplicador = multiplicador;
        this.defasajeConstante = defasajeConstante;
    }

    int obtenerDefasaje(int tamanio){
        return multiplicador * tamanio + defasajeConstante;
    }
}
