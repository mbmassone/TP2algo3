import Modelo.Bando;
import Modelo.Casillero.Casillero;
import Modelo.Casillero.CasilleroOcupadoExcepcion;
import Modelo.Infanteria;
import Modelo.Tablero.Tablero;
import Modelo.Tablero.UnidadAgregadaEnSectorEnemigoExcepcion;
import Modelo.Unidad;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TableroTest {
/*
    [x]Se coloca una pieza aliada en un casillero del sector aliado vacío con éxito.
    [x]Se verifica que no se puede colocar una pieza aliada en un casillero del sector aliado ocupado.
    [x]Se verifica que no se puede colocar una pieza aliada en un casillero del sector enemigo.
    [ ]Correcta creación e inicialización del tablero.


 */
    @Test
    public void tableroSeInicializaCorrectamente(){
        Tablero tablero = new Tablero();

        Assert.assertTrue(tablero != null);

        //TODO agregar mas cosas.
    }

    @Test
    public void colocarUnidadNuevaEnCasilleroAliadoVacio(){
        Tablero tablero = new Tablero();
        Unidad infanteria = new Infanteria(Bando.BANDO1,new Casillero());

        Assert.assertTrue(tablero.estaLibre(0,0));

        tablero.agregarUnidad(0, 0, infanteria);

        Assert.assertFalse(tablero.estaLibre(0,0));
    }

    @Test
    public void colocarUnidadNuevaEnCasilleroEnemigoDevuelveExcepcion(){
        Tablero tablero = new Tablero();
        Unidad infanteria = new Infanteria(Bando.BANDO2,new Casillero());

        assertThrows(UnidadAgregadaEnSectorEnemigoExcepcion.class, () ->{
            tablero.agregarUnidad(0,0, infanteria);
        } );
    }

    @Test
    public void colocarUnidadNuevaEnCasilleroOcupadoDevuelveExcepcion(){
        Tablero tablero = new Tablero();
        Unidad infanteria1 = new Infanteria(Bando.BANDO1,new Casillero());
        Unidad infanteria2 = new Infanteria(Bando.BANDO1,new Casillero());

        tablero.agregarUnidad(0,0,infanteria1);

        assertThrows(CasilleroOcupadoExcepcion.class, () ->{
            tablero.agregarUnidad(0,0, infanteria2);
        } );
    }
}
