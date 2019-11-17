import Modelo.*;
import Modelo.Casillero.Casillero;
import Modelo.Casillero.CasilleroOcupadoExcepcion;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Direccion;
import Modelo.Tablero.Tablero;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InfanteriaTest{

    @Test
    public void testInfanteriaAtacaEnemigoCercano(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Infanteria infanteriaAliada = new Infanteria(j1 , new Casillero() );
        Infanteria infanteriaEnemiga = new Infanteria(j2 , new Casillero() );

        Coordenada coordenadaAliada = new Coordenada(9,9);
        Coordenada coordenadaEnemiga = new Coordenada(11,11);
        tablero.agregarUnidad(coordenadaAliada,infanteriaAliada);
        tablero.agregarUnidad(coordenadaEnemiga,infanteriaEnemiga);

        infanteriaAliada.accion(infanteriaEnemiga);
        Assert.assertSame(infanteriaEnemiga.getVida(),90);
    }

    @Test
    public void testInfanteriaAtacaEnemigoLejano(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Infanteria infanteriaAliada = new Infanteria(j1 , new Casillero() );
        Infanteria infanteriaEnemiga = new Infanteria(j2 , new Casillero() );

        Coordenada coordenadaAliada = new Coordenada(9,9);
        Coordenada coordenadaEnemiga = new Coordenada(16,16);
        tablero.agregarUnidad(coordenadaAliada,infanteriaAliada);
        tablero.agregarUnidad(coordenadaEnemiga,infanteriaEnemiga);

        infanteriaAliada.accion(infanteriaEnemiga);
        Assert.assertSame(infanteriaEnemiga.getVida(),100);
    }

    @Test
    public void testInfanteriaMataAEnemigo() {
        Casillero casilleroEnemigo = new Casillero();
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Infanteria infanteriaAliada = new Infanteria(j1 , new Casillero() );
        Jinete jineteEnemigo = new Jinete(j2 , casilleroEnemigo );

        Coordenada coordenadaAliada = new Coordenada(9,9);
        Coordenada coordenadaEnemiga = new Coordenada(11,11);
        tablero.agregarUnidad(coordenadaAliada,infanteriaAliada);
        tablero.agregarUnidad(coordenadaEnemiga,jineteEnemigo);

        casilleroEnemigo.agregarUnidad(jineteEnemigo);

        Assert.assertFalse(casilleroEnemigo.estaLibre());
        for (int i = 0; i < 10; i++) {
            infanteriaAliada.accion(jineteEnemigo);
        }
        Assert.assertEquals(jineteEnemigo.getVida(),0); //TODO idem que con jinete test,casillero no esta actualizando el estado.
        Assert.assertTrue(casilleroEnemigo.estaLibre()); // TODO IDEM que con jinete test.
    }

    @Test
    public void testInfanteriaAtacaAliado(){
        Jugador jugador1 = new Jugador("Guido");
        Jugador jugador2 = new Jugador("Franco");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Infanteria infanteria = new Infanteria(jugador1, new Casillero());
        Curandero curanderoAliado = new Curandero(jugador1, new Casillero());

        Coordenada coordenada = new Coordenada(2,2);
        Coordenada coordenadaAliada = new Coordenada(3,3);
        tablero.agregarUnidad(coordenada,infanteria);
        tablero.agregarUnidad(coordenadaAliada,curanderoAliado);

        assertThrows(AtacarAliadoExcepcion.class, () ->{
            infanteria.accion(curanderoAliado);
        });
    }

    @Test
    public void testInfanteriaPuedeRecibirCuracion(){
        Jugador jugador1 = new Jugador("Guido");
        Jugador jugador2 = new Jugador("Franco");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Infanteria infanteria = new Infanteria(jugador1, new Casillero());
        Curandero curanderoAliado = new Curandero(jugador1, new Casillero());

        Coordenada coordenada = new Coordenada(2,2);
        Coordenada coordenadaAliada = new Coordenada(3,3);
        tablero.agregarUnidad(coordenada,infanteria);
        tablero.agregarUnidad(coordenadaAliada,curanderoAliado);

        curanderoAliado.accion(infanteria);

        assertSame(infanteria.getVida(),115);
    }

    @Test
    public void testInfanteriaSePuedeMoverACasillaLibre(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);

        Infanteria infanteria = new Infanteria(j1, new Casillero());

        Coordenada coordenada = new Coordenada(0, 0);
        tablero.agregarUnidad(coordenada, infanteria);

        infanteria.mover(Direccion.ABAJO);

        Coordenada coordenadaSiguiente = new Coordenada(1, 0);
        Assert.assertFalse(tablero.estaLibre(coordenadaSiguiente) );
    }

    @Test
    public void testInfanteriaNoSePuedeMoverACasillaOcupada(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);

        Jugador jugador = new Jugador("Camila");
        Infanteria infanteria1 = new Infanteria(j1, new Casillero());
        Infanteria infanteria2 = new Infanteria(j1, new Casillero());

        Coordenada coordenada1 = new Coordenada(0, 0);
        Coordenada coordenada2 = new Coordenada(1 ,0);

        tablero.agregarUnidad(coordenada1, infanteria1);
        tablero.agregarUnidad(coordenada2, infanteria2);

        assertThrows(CasilleroOcupadoExcepcion.class, () ->{
            infanteria1.mover(Direccion.ABAJO);
        });
    }

}
