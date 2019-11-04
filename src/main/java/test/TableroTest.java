package test;

import Modelo.Infanteria;
import Modelo.Tablero.Tablero;
import Modelo.Unidad;
import org.junit.Assert;
import org.junit.Test;

public class TableroTest {



    @Test
    public void colocarPiezaNuevaEnCasilleroVacio(){
        Tablero tablero = new Tablero();
        Unidad infanteria = new Infanteria();

        Assert.assertTrue(tablero.estaLibre(0,0));

        tablero.agregarUnidad(0, 0, infanteria);

        Assert.assertFalse(tablero.estaLibre(0,0));
    }


}
