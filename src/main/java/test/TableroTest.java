package test;

import Modelo.Bando;
import Modelo.Casillero.CasilleroOcupadoExeption;
import Modelo.Infanteria;
import Modelo.Tablero.Tablero;
import Modelo.Tablero.UnidadAgregadaEnSectorEnemigoExeption;
import Modelo.Unidad;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TableroTest {



    @Test
    public void colocarUnidadNuevaEnCasilleroAliadoVacio(){
        Tablero tablero = new Tablero();
        Unidad infanteria = new Infanteria(Bando.BANDO1);

        Assert.assertTrue(tablero.estaLibre(0,0));

        tablero.agregarUnidad(0, 0, infanteria);

        Assert.assertFalse(tablero.estaLibre(0,0));
    }

    @Test
    public void colocarUnidadNuevaEnCasilleroEnemigoDevuelveExcepcion(){
        Tablero tablero = new Tablero();
        Unidad infanteria = new Infanteria(Bando.BANDO2);

        assertThrows(UnidadAgregadaEnSectorEnemigoExeption.class, () ->{
            tablero.agregarUnidad(0,0, infanteria);
        } );
    }

    @Test
    public void colocarUnidadNuevaEnCasilleroOcupadoDevuelveExcepcion(){
        Tablero tablero = new Tablero();
        Unidad infanteria1 = new Infanteria(Bando.BANDO1);
        Unidad infanteria2 = new Infanteria(Bando.BANDO1);

        tablero.agregarUnidad(0,0,infanteria1);

        assertThrows(CasilleroOcupadoExeption.class, () ->{
            tablero.agregarUnidad(0,0, infanteria2);
        } );
    }
}
