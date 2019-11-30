import Modelo.*;
import Modelo.Casillero.Casillero;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class JineteTest {
    @Test
    public void testSeObtieneNombreDeJinete(){
        Jinete jinete = new Jinete(new Jugador("Laureano") );
        String nombreEsperado = "jinete";
        assertSame(jinete.obtenerNombre(), nombreEsperado);
    }

    @Test
    public void testJineteAtacaEnemigoCercano(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Jinete jineteAliado = new Jinete(j1);
        Infanteria infanteriaEnemiga = new Infanteria(j2);

        Coordenada coordenadaAliada = new Coordenada(9,9);
        Coordenada coordenadaEnemiga = new Coordenada(11,11);
        tablero.agregarUnidad(coordenadaAliada,jineteAliado);
        tablero.agregarUnidad(coordenadaEnemiga,infanteriaEnemiga);

        jineteAliado.accion(infanteriaEnemiga);
        assertEquals(infanteriaEnemiga.getVida(),95);
    }

    @Test
    public void testJineteMataEnemigoCercano(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");

        Tablero tablero = new Tablero(j1, j2);
        Jinete jineteAliado = new Jinete(j1);
        Catapulta catapultaEnemiga = new Catapulta(j2);

        Coordenada coordenadaAliada = new Coordenada(9,9);
        Coordenada coordenadaEnemiga = new Coordenada(11,11);
        tablero.agregarUnidad(coordenadaAliada,jineteAliado);
        tablero.agregarUnidad(coordenadaEnemiga,catapultaEnemiga);


        Assert.assertFalse(tablero.estaLibre(coordenadaEnemiga));
        for (int i = 0 ; i < 10 ; i++){
            jineteAliado.accion(catapultaEnemiga);
        }
        Assert.assertTrue(tablero.estaLibre(coordenadaEnemiga));
    }

    @Test
    public void testJineteAtacaEnemigoMediano(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Jinete jineteAliado = new Jinete(j1);
        Infanteria infanteriaEnemiga = new Infanteria(j2);

        Coordenada coordenadaAliada = new Coordenada(9,9);
        Coordenada coordenadaEnemiga = new Coordenada(14,14);
        tablero.agregarUnidad(coordenadaAliada,jineteAliado);
        tablero.agregarUnidad(coordenadaEnemiga,infanteriaEnemiga);

        jineteAliado.accion(infanteriaEnemiga);
        assertEquals(infanteriaEnemiga.getVida(),85);
    }

    @Test
    public void testJineteNoAtacaEnemigoMedianoSiTieneEnemigoCercano(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Jinete jineteAliado = new Jinete(j1);
        Infanteria infanteriaEnemiga = new Infanteria(j2);
        Infanteria infanteriaEnemiga2 = new Infanteria(j2);

        Coordenada coordenadaAliada = new Coordenada(9,9);
        Coordenada coordenadaEnemiga = new Coordenada(14,14);
        Coordenada coordenadaEnemiga2 = new Coordenada(10,10);
        tablero.agregarUnidad(coordenadaAliada,jineteAliado);
        tablero.agregarUnidad(coordenadaEnemiga,infanteriaEnemiga);
        tablero.agregarUnidad(coordenadaEnemiga2, infanteriaEnemiga2);

        jineteAliado.accion(infanteriaEnemiga);
        assertEquals(infanteriaEnemiga.getVida(),100);
    }

    @Test
    public void testJineteAtacaEnemigoMedianoSiTieneEnemigoCercanoEInfanteriaCercana(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Jinete jineteAliado = new Jinete(j1);
        Infanteria infanteriaAliada = new Infanteria(j1);
        Infanteria infanteriaEnemiga = new Infanteria(j2);
        Infanteria infanteriaEnemiga2 = new Infanteria(j2);

        Coordenada coordenadaAliada = new Coordenada(9,9);
        Coordenada coordenadaAliada2 = new Coordenada(9,10);
        Coordenada coordenadaEnemiga = new Coordenada(14,14);
        Coordenada coordenadaEnemiga2 = new Coordenada(10,10);
        tablero.agregarUnidad(coordenadaAliada,jineteAliado);
        tablero.agregarUnidad(coordenadaAliada2, infanteriaAliada);
        tablero.agregarUnidad(coordenadaEnemiga,infanteriaEnemiga);
        tablero.agregarUnidad(coordenadaEnemiga2, infanteriaEnemiga2);

        jineteAliado.accion(infanteriaEnemiga);
        assertEquals(infanteriaEnemiga.getVida(),85);
    }

    @Test
    public void testJineteNoAtacaEnemigoMedianoSiTieneEnemigoCercanoYCatapultaCercana(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Jinete jineteAliado = new Jinete(j1);
        Catapulta catapulta = new Catapulta(j1);
        Infanteria infanteriaEnemiga = new Infanteria(j2);
        Infanteria infanteriaEnemiga2 = new Infanteria(j2);

        Coordenada coordenadaAliada = new Coordenada(9,9);
        Coordenada coordenadaAliada2 = new Coordenada(9,10);
        Coordenada coordenadaEnemiga = new Coordenada(14,14);
        Coordenada coordenadaEnemiga2 = new Coordenada(10,10);
        tablero.agregarUnidad(coordenadaAliada,jineteAliado);
        tablero.agregarUnidad(coordenadaAliada2, catapulta);
        tablero.agregarUnidad(coordenadaEnemiga,infanteriaEnemiga);
        tablero.agregarUnidad(coordenadaEnemiga2, infanteriaEnemiga2);

        jineteAliado.accion(infanteriaEnemiga);
        assertEquals(infanteriaEnemiga.getVida(),100);
    }

    @Test
    public  void testJinetePuedeRecibirCuracion(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Casillero casilleroCatapulta = new Casillero();
        Tablero tablero = new Tablero(j1, j2);
        Jinete jineteAliado = new Jinete(j1);
        Curandero curanderoAliado = new Curandero(j1);
        curanderoAliado.asignarCasillero(casilleroCatapulta);

        Coordenada coordenadaJinete = new Coordenada(3,3);
        Coordenada coordenadaCurandero = new Coordenada(5,2);
        tablero.agregarUnidad(coordenadaCurandero,curanderoAliado);
        tablero.agregarUnidad(coordenadaJinete,jineteAliado);

        curanderoAliado.accion(jineteAliado);

        assertEquals(jineteAliado.getVida(),115);

    }

    @Test
    public void testJineteAtacaAliado(){
        Jugador jugador = new Jugador("Juan");
        Jinete jinete = new Jinete(jugador);
        Curandero curanderoAliado = new Curandero(jugador);

        assertThrows(AtacarAliadoExcepcion.class, () ->{
            jinete.accion(curanderoAliado);
        });
    }
}
