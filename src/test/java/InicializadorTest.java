import Modelo.*;

import Modelo.Casillero.CasilleroOcupadoExcepcion;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class InicializadorTest {
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