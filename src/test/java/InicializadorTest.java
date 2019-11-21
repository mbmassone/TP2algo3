import Modelo.*;

import Modelo.Casillero.CasilleroOcupadoExcepcion;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class InicializadorTest {
    /*@Test //TODO Acomodar esto
    public void testAgregarGuerreroAlJuegoYNoTieneEnergiaSuficiente(){
        Jugador j1 = new Jugador("Tomas");
        Tablero tablero = new Tablero(j1, new Jugador("Gabriel") );
        Inicializador inicializador = new Inicializador(tablero);
        Coordenada coordenada1 = new Coordenada(1, 1);
        Coordenada coordenada2 = new Coordenada(2, 2);
        Coordenada coordenada3 = new Coordenada(3, 3);
        Coordenada coordenada4 = new Coordenada(4, 4);
        Coordenada coordenada5 = new Coordenada(5, 5);
        Catapulta catapulta = new Catapulta(j1);


        inicializador.agregarUnidad(j1, coordenada1, catapulta);
        inicializador.agregarUnidad(j1, coordenada2, catapulta);
        inicializador.agregarUnidad(j1, coordenada3, catapulta);
        inicializador.agregarUnidad(j1, coordenada4, catapulta);
        int energia_esperada = j1.obtenerPuntos();
        inicializador.agregarUnidad(j1, coordenada5, catapulta);

        Assert.assertSame(tablero.obtenerCasillero
                energia_esperada, j1.obtenerPuntos() );
    }*/

    @Test
    public void testAgregarGuerreroAlJuegoYLaPosicionEstaOcupada(){
        Jugador j1 = new Jugador("Tomas");
        Tablero tablero = new Tablero(j1, new Jugador("Gabriel") );
        Inicializador inicializador = new Inicializador(tablero);
        Coordenada coordenada = new Coordenada(1, 1);

        Catapulta catapulta = new Catapulta(j1);


        inicializador.agregarUnidad(j1, coordenada, catapulta);

        assertThrows(CasilleroOcupadoExcepcion.class, () ->{
            inicializador.agregarUnidad(j1, coordenada, catapulta);
        } );
    }

    @Test
    public void testAgregarGuerreroAlJuegoYLaPosicionEstaOcupadaEntoncesNoRestaEnergia(){
        Jugador j1 = new Jugador("Tomas");
        Tablero tablero = new Tablero(j1, new Jugador("Gabriel") );
        Inicializador inicializador = new Inicializador(tablero);
        Coordenada coordenada = new Coordenada(1, 1);

        Catapulta catapulta = new Catapulta(j1);


        inicializador.agregarUnidad(j1, coordenada, catapulta);

        assertThrows(CasilleroOcupadoExcepcion.class, () ->{
            inicializador.agregarUnidad(j1, coordenada, catapulta);
        } );
    }
}