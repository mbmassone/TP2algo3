import Modelo.*;
import Modelo.Casillero.Casillero;
import Modelo.Tablero.Coordenada;
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

        Infanteria infanteria = new Infanteria(j1);
        Catapulta catapulta = new Catapulta(j2);

        Coordenada coordenadaInfanteria = new Coordenada(0, 0);
        Coordenada coordenadaCatapulta = new Coordenada(18, 18);

        tablero.agregarUnidad(coordenadaInfanteria, infanteria);
        tablero.agregarUnidad(coordenadaCatapulta, catapulta);

        catapulta.accion(infanteria);
        assertSame(infanteria.getVida(),80);
    }

    @Test
    public void catapultaAtacaEnemigoCercano(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Catapulta catapulta = new Catapulta(j1);
        Catapulta catapultaEnemiga = new Catapulta(j2);

        Coordenada coordenadaCatapulta = new Coordenada(9, 9);
        Coordenada coordenadaCatapultaEnemiga = new Coordenada(16, 16);

        tablero.agregarUnidad(coordenadaCatapulta, catapulta);
        tablero.agregarUnidad(coordenadaCatapultaEnemiga, catapultaEnemiga);

        catapulta.accion(catapultaEnemiga);
        assertSame(catapulta.getVida(),50);
    }

    @Test
    public void catapultaNoPuedeSerCurada(){
        Catapulta catapulta = new Catapulta(new Jugador("Tomas") );

        assertThrows(CatapultaCuracionException.class, () ->{
            catapulta.recibirCuracion(321);
        });
    }

    @Test
    public void catapultaNoPuedeMoverse(){
        Catapulta catapulta = new Catapulta(new Jugador("Bernardo") );

        assertThrows(CatapultaNoSePuedeMoverExcepcion.class, () ->{
            catapulta.mover(Direccion.ABAJO);
        });

    }
}
