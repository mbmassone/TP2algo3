package Vista_api.RecursosClass;

import Modelo.Casillero.Casillero;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;

//Deberia ser una matrix que se auto actualice y muestre sus componentes
public class Representacion_tablero {
    //Seguro se puede modularizar AUN mas
    //
    private Casilla_vista[][] tablero_visual;
    private int filas = 20;
    private int columnas = 20;

    public Representacion_tablero() throws Exception{
        Casilla_vista[][] matrix = new Casilla_vista[this.filas][this.columnas];
        for(int i = 0; i < this.filas; i++)
            for(int j = 0; j < this.columnas; j++)
                this.tablero_visual[i][j].actualizar("vacio");
    }

    // Como actualizo los datos? necesito la referencia al tablero?
    public void actualizar_representacion_tablero(Tablero tablero){

    }
    public void mostrar_representacion_tablero(){
        for(int i = 0; i < this.filas; i++)
            for(int j = 0; j < this.columnas; j++)
                this.tablero_visual[i][j].mostrar();
    }
}

