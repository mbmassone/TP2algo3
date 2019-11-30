import Modelo.*;
import Modelo.Casillero.Casillero;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CuranderoTest {
    @Test
    public void testSeObtieneNombreDelCurandero(){
        Curandero curandero = new Curandero(new Jugador("Lorena") );
        String nombreEsperado = "curandero";
        assertSame(curandero.obtenerNombre(), nombreEsperado);
    }

    @Test
    public void curanderoCuraAliadoCercano(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Curandero curandero = new Curandero(j1);
        Infanteria infanteriaAliada = new Infanteria(j1);
        Infanteria infanteriaEnemiga = new Infanteria(j2);

        Coordenada coordenadaAliadaCurandero = new Coordenada(8,8);
        Coordenada coordenadaAliadaInfanteria = new Coordenada(9,9);
        Coordenada coordenadaEnemigaInfanteria = new Coordenada(11,11);

        tablero.agregarUnidad(coordenadaAliadaCurandero,curandero);
        tablero.agregarUnidad(coordenadaAliadaInfanteria,infanteriaAliada);
        tablero.agregarUnidad(coordenadaEnemigaInfanteria,infanteriaEnemiga);

        infanteriaEnemiga.accion(infanteriaAliada);
        infanteriaEnemiga.accion(infanteriaAliada);

        curandero.accion(infanteriaAliada);

        assertEquals(infanteriaAliada.getVida(), 95);
    }
    @Test
    public void curanderoCuraAliadoLejano(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Curandero curandero = new Curandero(j1);
        Infanteria infanteriaAliada = new Infanteria(j1);

        Coordenada coordenadaAliadaCurandero = new Coordenada(0,0);
        Coordenada coordenadaAliadaInfanteria = new Coordenada(9,9);

        tablero.agregarUnidad(coordenadaAliadaCurandero,curandero);
        tablero.agregarUnidad(coordenadaAliadaInfanteria,infanteriaAliada);


        curandero.accion(infanteriaAliada);
        assertEquals(infanteriaAliada.getVida(), 100);
    }



    @Test
    public void curanderoCuraEnemigo(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Curandero curandero = new Curandero(j1);
        Jinete jineteEnemigo = new Jinete(j2);

        assertThrows(CurarEnemigoExcepcion.class, () ->{
            curandero.accion(jineteEnemigo);
        });
    }

    @Test
    public void curanderoSeCuraAsiMismo(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Curandero curandero = new Curandero(j1);
        Coordenada coordenada = new Coordenada(4,6);

        tablero.agregarUnidad(coordenada,curandero);
        curandero.accion(curandero);

        assertEquals(curandero.getVida(),90);
    }

}
