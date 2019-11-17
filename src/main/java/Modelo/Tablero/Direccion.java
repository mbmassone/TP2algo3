package Modelo.Tablero;

public enum Direccion{
    ARRIBA(-1, 0), ARRIBADERECHA(-1,1), DERECHA(0,1), ABAJODERECHA(1,1), ABAJO(1,0), ABAJOIZQUIERDA(1,-1), IZQUIERDA(0, -1), ARRIBAIZQUIERDA(-1,-1);

    Coordenada defasaje;

    Direccion(int fila, int columna) {
        this.defasaje = new Coordenada(fila, columna);
    }

    Coordenada obtenerDefasaje(){
        return defasaje;
    }
}
