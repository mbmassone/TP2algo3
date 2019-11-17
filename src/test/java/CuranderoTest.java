import Modelo.*;
import Modelo.Casillero.Casillero;
import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Tablero;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class CuranderoTest {
    @Test
    public void curanderoCuraAliadoCercano(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Curandero curandero = new Curandero(j1, new Casillero());
        Infanteria infanteriaAliada = new Infanteria(j1, new Casillero());
        Infanteria infanteriaEnemiga = new Infanteria(j2, new Casillero());

        Coordenada coordenadaAliadaCurandero = new Coordenada(8,8);
        Coordenada coordenadaAliadaInfanteria = new Coordenada(9,9);
        Coordenada coordenadaEnemigaInfanteria = new Coordenada(11,11);

        tablero.agregarUnidad(coordenadaAliadaCurandero,curandero);
        tablero.agregarUnidad(coordenadaAliadaInfanteria,infanteriaAliada);
        tablero.agregarUnidad(coordenadaEnemigaInfanteria,infanteriaEnemiga);

        infanteriaEnemiga.accion(infanteriaAliada);
        infanteriaEnemiga.accion(infanteriaAliada);

        curandero.accion(infanteriaAliada);

        Assert.assertSame(infanteriaAliada.getVida(), 95);
    }
    @Test
    public void curanderoCuraAliadoLejano(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Curandero curandero = new Curandero(j1, new Casillero());
        Infanteria infanteriaAliada = new Infanteria(j1, new Casillero());

        Coordenada coordenadaAliadaCurandero = new Coordenada(0,0);
        Coordenada coordenadaAliadaInfanteria = new Coordenada(9,9);

        tablero.agregarUnidad(coordenadaAliadaCurandero,curandero);
        tablero.agregarUnidad(coordenadaAliadaInfanteria,infanteriaAliada);


        curandero.accion(infanteriaAliada);
        Assert.assertSame(infanteriaAliada.getVida(), 100);
    }



    @Test
    public void curanderoCuraEnemigo(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Curandero curandero = new Curandero(j1, new Casillero());
        Jinete jineteEnemigo = new Jinete(j2,new Casillero());

        assertThrows(CurarEnemigoExcepcion.class, () ->{
            curandero.accion(jineteEnemigo);
        });
    }

    @Test
    public void curanderoSeCuraAsiMismo(){
        Jugador j1 = new Jugador("Camila");
        Jugador j2 = new Jugador("Josefina");
        Tablero tablero = new Tablero(j1, j2);
        Curandero curandero = new Curandero(j1, new Casillero());
        Coordenada coordenada = new Coordenada(4,6);

        tablero.agregarUnidad(coordenada,curandero);
        curandero.accion(curandero);

        Assert.assertSame(curandero.getVida(),90);
    }

}
