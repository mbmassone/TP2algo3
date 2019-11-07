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
        Tablero tablero = new Tablero();
        Infanteria infanteria = new Infanteria(Bando.BANDO1,new Casillero());
        Catapulta catapulta = new Catapulta(Bando.BANDO2,new Casillero());

        tablero.agregarUnidad(0,0,infanteria);
        tablero.agregarUnidad(18,18,catapulta);

        catapulta.accion(infanteria);
        assertSame(infanteria.getVida(),80);
    }

    @Test
    public void catapultaAtacaEnemigoCercano(){
        Tablero tablero = new Tablero();
        Catapulta catapulta = new Catapulta(Bando.BANDO1,new Casillero());
        Catapulta catapultaEnemiga = new Catapulta(Bando.BANDO2,new Casillero());

        tablero.agregarUnidad(9,9,catapulta);
        tablero.agregarUnidad(16,16,catapultaEnemiga);

        catapulta.accion(catapultaEnemiga);
        assertSame(catapulta.getVida(),50);

    }

    @Test
    public void catapultaNoPuedeSerCurada(){
        Catapulta catapulta = new Catapulta(Bando.BANDO2,new Casillero());

        assertThrows(CatapultaCuracionException.class, () ->{
            catapulta.recibirCuracion(321);
        });
    }

    @Test
    public void catapultaNoPuedeMoverse(){
        Catapulta catapulta = new Catapulta(Bando.BANDO1, new Casillero());

        assertThrows(CatapultaNoSePuedeMoverExcepcion.class, () ->{
            catapulta.mover(Direccion.ABAJO);
        });

    }
}
