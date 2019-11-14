import Modelo.*;
import Modelo.Casillero.Casillero;
import Modelo.Tablero.Direccion;
import Modelo.Tablero.Tablero;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CatapultaTest {

    @Test
    public void catapultaAtacaEnemigoLejano(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);

        Infanteria infanteria = new Infanteria(j1, new Casillero() );
        Catapulta catapulta = new Catapulta(j2, new Casillero() );

        tablero.agregarUnidad(0,0,infanteria);
        tablero.agregarUnidad(18,18,catapulta);

        catapulta.accion(infanteria);
        assertSame(infanteria.getVida(),80);
    }

    @Test
    public void catapultaAtacaEnemigoCercano(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Catapulta catapulta = new Catapulta(j1, new Casillero() );
        Catapulta catapultaEnemiga = new Catapulta(j2, new Casillero() );

        tablero.agregarUnidad(9,9,catapulta);
        tablero.agregarUnidad(16,16,catapultaEnemiga);

        catapulta.accion(catapultaEnemiga);
        assertSame(catapulta.getVida(),50);

    }

    @Test
    public void catapultaNoPuedeSerCurada(){
        Catapulta catapulta = new Catapulta(new Jugador("Tomas"), new Casillero() );

        assertThrows(CatapultaCuracionException.class, () ->{
            catapulta.recibirCuracion(321);
        });
    }

    @Test
    public void catapultaNoPuedeMoverse(){
        Catapulta catapulta = new Catapulta(new Jugador("Bernardo"), new Casillero() );

        assertThrows(CatapultaNoSePuedeMoverExcepcion.class, () ->{
            catapulta.mover(Direccion.ABAJO);
        });

    }
}
