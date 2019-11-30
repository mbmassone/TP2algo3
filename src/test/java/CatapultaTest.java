import Modelo.*;
import Modelo.Casillero.Casillero;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Direccion;
import Modelo.Tablero.Tablero;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CatapultaTest {
    @Test
    public void testSeObtieneNombreDeLaCatapulta(){
        Catapulta catapulta = new Catapulta(new Jugador("Laureano") );
        String nombreEsperado = "catapulta";
        assertSame(catapulta.obtenerNombre(), nombreEsperado);
    }

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
        assertEquals(infanteria.getVida(),80);
    }

    @Test
    public void catapultaAtacaEnemigoLejanoEnTerritorioEnemigo(){ //El enemigo se encuentra en el territorio de la catapulta
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);

        Infanteria infanteria = new Infanteria(j1);
        Catapulta catapulta = new Catapulta(j2);

        Coordenada coordenadaInfanteria = new Coordenada(9, 0);
        Coordenada coordenadaCatapulta = new Coordenada(19, 0);

        tablero.agregarUnidad(coordenadaInfanteria, infanteria);
        tablero.agregarUnidad(coordenadaCatapulta, catapulta);

        infanteria.mover(Direccion.ABAJO);

        catapulta.accion(infanteria);
        assertEquals(infanteria.getVida(),79);
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
        assertEquals(catapulta.getVida(),50);
    }

    @Test
    public void catapultaAtacaDeLejosACualquierAdyacente(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);

        Catapulta catapultaAliada = new Catapulta(j1);
        Curandero curanderoAliado = new Curandero(j1);
        Infanteria infanteriaEnemiga = new Infanteria(j2);
        Catapulta catapultaEnemiga = new Catapulta(j2);

        Coordenada coordenadaCatapultaAliada = new Coordenada(1,1);
        Coordenada coordenadaCuranderoAliado = new Coordenada(9,9);
        Coordenada coordenadaInfanteriaEnemiga = new Coordenada(10,10);
        Coordenada coordenadaCatapultaEnemiga = new Coordenada(11,11);

        tablero.agregarUnidad(coordenadaCatapultaAliada,catapultaAliada);
        tablero.agregarUnidad(coordenadaCuranderoAliado,curanderoAliado);
        tablero.agregarUnidad(coordenadaInfanteriaEnemiga,infanteriaEnemiga);
        tablero.agregarUnidad(coordenadaCatapultaEnemiga, catapultaEnemiga);


        catapultaAliada.accion(infanteriaEnemiga);

        assertEquals(catapultaAliada.getVida(),50);
        assertEquals(curanderoAliado.getVida(),55);
        assertEquals(infanteriaEnemiga.getVida(),80);
        assertEquals(catapultaEnemiga.getVida(),30);
    }

    @Test
    public void catapultaNoAtacaDeLejosALosNoAdyacentes(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);

        Catapulta catapultaAliada = new Catapulta(j1);
        Infanteria infanteriaEnemiga = new Infanteria(j2);
        Jinete jineteEnemigo = new Jinete(j2);

        Coordenada coordenadaCatapultaAliada = new Coordenada(1,1);
        Coordenada coordenadaInfanteriaEnemiga = new Coordenada(16,16);
        Coordenada coordenadaJineteEnemigo = new Coordenada(16,18);

        tablero.agregarUnidad(coordenadaCatapultaAliada,catapultaAliada);
        tablero.agregarUnidad(coordenadaInfanteriaEnemiga,infanteriaEnemiga);
        tablero.agregarUnidad(coordenadaJineteEnemigo,jineteEnemigo);

        catapultaAliada.accion(infanteriaEnemiga);

        assertEquals(infanteriaEnemiga.getVida(),80);
        assertEquals(jineteEnemigo.getVida(),100);
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
