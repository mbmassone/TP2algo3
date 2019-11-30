import Modelo.*;
import Modelo.Casillero.Casillero;
import Modelo.Casillero.CasilleroOcupadoExcepcion;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Direccion;
import Modelo.Tablero.Tablero;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InfanteriaTest{
    @Test
    public void TestseObtieneNombreDeInfanteria(){
        Infanteria infanteria = new Infanteria(new Jugador("Claudia") );
        String nombreEsperado = "infanteria";
        assertSame(infanteria.obtenerNombre(), nombreEsperado);
    }

    @Test
    public void testInfanteriaAtacaEnemigoCercano(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Infanteria infanteriaAliada = new Infanteria(j1);
        Infanteria infanteriaEnemiga = new Infanteria(j2);

        Coordenada coordenadaAliada = new Coordenada(9,9);
        Coordenada coordenadaEnemiga = new Coordenada(11,11);
        tablero.agregarUnidad(coordenadaAliada,infanteriaAliada);
        tablero.agregarUnidad(coordenadaEnemiga,infanteriaEnemiga);

        infanteriaAliada.accion(infanteriaEnemiga);
        assertEquals(infanteriaEnemiga.getVida(),90);
    }

    @Test
    public void testInfanteriaAtacaEnemigoLejano(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Infanteria infanteriaAliada = new Infanteria(j1);
        Infanteria infanteriaEnemiga = new Infanteria(j2);

        Coordenada coordenadaAliada = new Coordenada(9,9);
        Coordenada coordenadaEnemiga = new Coordenada(16,16);
        tablero.agregarUnidad(coordenadaAliada,infanteriaAliada);
        tablero.agregarUnidad(coordenadaEnemiga,infanteriaEnemiga);

        infanteriaAliada.accion(infanteriaEnemiga);
        assertEquals(infanteriaEnemiga.getVida(),100);
    }

    @Test
    public void testInfanteriaMataAEnemigo() {
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Infanteria infanteriaAliada = new Infanteria(j1);
        Jinete jineteEnemigo = new Jinete(j2);

        Coordenada coordenadaAliada = new Coordenada(9,9);
        Coordenada coordenadaEnemiga = new Coordenada(11,11);
        tablero.agregarUnidad(coordenadaAliada,infanteriaAliada);
        tablero.agregarUnidad(coordenadaEnemiga,jineteEnemigo);


        Assert.assertFalse(tablero.estaLibre(coordenadaEnemiga));
        for (int i = 0; i < 10; i++) {
            infanteriaAliada.accion(jineteEnemigo);
        }
        assertEquals(jineteEnemigo.getVida(),0);
        Assert.assertTrue(tablero.estaLibre(coordenadaEnemiga));
    }

    @Test
    public void testInfanteriaAtacaAliado(){
        Jugador jugador1 = new Jugador("Guido");
        Jugador jugador2 = new Jugador("Franco");
        Tablero tablero = new Tablero(jugador1,jugador2);
        Infanteria infanteria = new Infanteria(jugador1);
        Curandero curanderoAliado = new Curandero(jugador1);

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
        Infanteria infanteria = new Infanteria(jugador1);
        Curandero curanderoAliado = new Curandero(jugador1);

        Coordenada coordenada = new Coordenada(2,2);
        Coordenada coordenadaAliada = new Coordenada(3,3);
        tablero.agregarUnidad(coordenada,infanteria);
        tablero.agregarUnidad(coordenadaAliada,curanderoAliado);

        curanderoAliado.accion(infanteria);

        assertEquals(infanteria.getVida(),115);
    }

    @Test
    public void testInfanteriaSePuedeMoverACasillaLibre(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);

        Infanteria infanteria = new Infanteria(j1);

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
        Infanteria infanteria1 = new Infanteria(j1);
        Infanteria infanteria2 = new Infanteria(j1);

        Coordenada coordenada1 = new Coordenada(0, 0);
        Coordenada coordenada2 = new Coordenada(1 ,0);

        tablero.agregarUnidad(coordenada1, infanteria1);
        tablero.agregarUnidad(coordenada2, infanteria2);

        infanteria1.mover(Direccion.ABAJO);
        Assert.assertFalse(tablero.estaLibre(coordenada1)); //La infanteria1 no vario su posicion.
        Assert.assertFalse(tablero.estaLibre(coordenada2)); //La infanteria2 mantiene su posicion.

    }

    @Test
    public void testInfanteriaSeComportaComoBatallonAlMover(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);

        Jugador jugador = new Jugador("Camila");
        Infanteria infanteria1 = new Infanteria(j1);
        Infanteria infanteria2 = new Infanteria(j1);
        Infanteria infanteria3 = new Infanteria(j1);

        Coordenada coordenada1 = new Coordenada(0, 0);
        Coordenada coordenada2 = new Coordenada(1 ,0);
        Coordenada coordenada3 = new Coordenada(2,0);

        tablero.agregarUnidad(coordenada1, infanteria1);
        tablero.agregarUnidad(coordenada2, infanteria2);
        tablero.agregarUnidad(coordenada3, infanteria3);
        infanteria1.mover(Direccion.DERECHA);

        Coordenada coordenada1Actualizada = new Coordenada(0,1);
        Coordenada coordenada2Actualizada = new Coordenada(1,1);
        Coordenada coordenada3Actualizada = new Coordenada(2,1);

        Assert.assertFalse(tablero.estaLibre(coordenada1Actualizada));
        Assert.assertFalse(tablero.estaLibre(coordenada2Actualizada));
        Assert.assertFalse(tablero.estaLibre(coordenada3Actualizada));

        Assert.assertTrue(tablero.estaLibre(coordenada1));
        Assert.assertTrue(tablero.estaLibre(coordenada2));
        Assert.assertTrue(tablero.estaLibre(coordenada3));
    }

    @Test
    public void testInfanteriaDejaDeComportarseComoBatallonAlColisionar(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);

        Jugador jugador = new Jugador("Camila");
        Infanteria infanteria1 = new Infanteria(j1);
        Infanteria infanteria2 = new Infanteria(j1);
        Infanteria infanteria3 = new Infanteria(j1);
        Curandero curandero = new Curandero(j1);


        Coordenada coordenada1 = new Coordenada(0, 0);
        Coordenada coordenada2 = new Coordenada(1 ,0);
        Coordenada coordenada3 = new Coordenada(2,0);
        Coordenada coordenadaCurandero = new Coordenada(1,1); // Posicion de colision.
        tablero.agregarUnidad(coordenada1, infanteria1);
        tablero.agregarUnidad(coordenada2, infanteria2);
        tablero.agregarUnidad(coordenada3, infanteria3);
        tablero.agregarUnidad(coordenadaCurandero,curandero);
        infanteria1.mover(Direccion.DERECHA);

        Coordenada coordenada1Actualizada = new Coordenada(0,1);
        Coordenada coordenada3Actualizada = new Coordenada(2,1);

        Assert.assertFalse(tablero.estaLibre(coordenada1Actualizada));
        Assert.assertFalse(tablero.estaLibre(coordenada2)); // infanteria2 no se movio.
        Assert.assertFalse(tablero.estaLibre(coordenadaCurandero));
        Assert.assertFalse(tablero.estaLibre(coordenada3Actualizada));

        Assert.assertTrue(tablero.estaLibre(coordenada1));
        Assert.assertFalse(tablero.estaLibre(coordenada2));
        Assert.assertTrue(tablero.estaLibre(coordenada3));
    }

    @Test
    public void testInfanteriaDejaDeSerComoBatallonAlColisionar(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);

        Jugador jugador = new Jugador("Camila");
        Infanteria infanteria1 = new Infanteria(j1);
        Infanteria infanteria2 = new Infanteria(j1);
        Infanteria infanteria3 = new Infanteria(j1);
        Curandero curandero = new Curandero(j1);


        Coordenada coordenada1 = new Coordenada(0, 0);
        Coordenada coordenada2 = new Coordenada(1 ,0);
        Coordenada coordenada3 = new Coordenada(2,0);
        Coordenada coordenadaCurandero = new Coordenada(1,1); // Posicion de colision.

        tablero.agregarUnidad(coordenada1,infanteria1);
        tablero.agregarUnidad(coordenada2,infanteria2);
        tablero.agregarUnidad(coordenada3,infanteria3);
        tablero.agregarUnidad(coordenadaCurandero,curandero);
        infanteria1.mover(Direccion.DERECHA);

        Coordenada coordenada1Actualizada = new Coordenada(0,1);
        Coordenada coordenada3Actualizada = new Coordenada(2,1);
        Assert.assertFalse(tablero.estaLibre(coordenada1Actualizada));
        Assert.assertFalse(tablero.estaLibre(coordenada3Actualizada));

        infanteria1.mover(Direccion.DERECHA);
        infanteria1.mover(Direccion.DERECHA);

        Coordenada coordenada1Final = new Coordenada(0,3);
        Coordenada coordenada3Final = new Coordenada(2,2);
        Assert.assertFalse(tablero.estaLibre(coordenada1Final));
        Assert.assertFalse(tablero.estaLibre(coordenada3Final)); // infanteria3 solo se mueve 2 veces y no 3 pues deja de ser batallon.

    }
}
