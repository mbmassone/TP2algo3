package Modelo;

public class Inicializador {

    private Tablero tablero;

    public Inicializador(){

    }

    public void agregarUnidad(int fila, int columna, Identificador identificador){
        Unidad nuevaUnidad = identificador.crearUnidad(fila, columna, tablero);
    }

}
