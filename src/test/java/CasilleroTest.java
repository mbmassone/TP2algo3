import Modelo.*;
import Modelo.Casillero.*;

import Modelo.Tablero.Coordenada;
import Modelo.Tablero.Direccion;
import Modelo.Tablero.Tablero;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CasilleroTest {
    @Test
    public void obtenerAdyacenteDevuelveExcepcionSiNoHayAdyacenteEnEsaDireccion(){
        Casillero casillero = new Casillero();

        assertThrows(CasilleroFueraDeRangoExcepcion.class, () ->{
            casillero.obtenerAdyacente(Direccion.ARRIBA);
        } );
    }

    @Test
    public void destruirUnidadDeCasilleroLibreDevuelveExcepcion(){
        Casillero casillero = new Casillero();

        assertThrows(CasilleroYaEstaLibreExcepcion.class, () ->{
            casillero.destruirUnidad();
        } );
    }

    @Test
    public void obtenerDireccionAdyacenteDevuelveExcepcionSiNoExisteElAdyacente(){
        Casillero casillero = new Casillero();

        casillero.agregarAdyacente(Direccion.ARRIBA, new Casillero());
        casillero.agregarAdyacente(Direccion.ABAJO, new Casillero());
        casillero.agregarAdyacente(Direccion.DERECHA, new Casillero());

        Casillero casillero1 = new Casillero();

        assertThrows(CasilleroNoEsAdyacenteExcepcion.class, () ->{
            casillero.obtenerDireccionDeAdyacente(casillero1);
        } );
    }

    @Test
    public void obtenerDireccionAdyacenteDevuelveDireccionCorrectamente(){
        Casillero casillero = new Casillero();

        casillero.agregarAdyacente(Direccion.ARRIBA, new Casillero());
        casillero.agregarAdyacente(Direccion.ABAJO, new Casillero());
        casillero.agregarAdyacente(Direccion.DERECHA, new Casillero());

        Casillero casillero1 = new Casillero();

        casillero.agregarAdyacente(Direccion.IZQUIERDA, casillero1);

        assertEquals(casillero.obtenerDireccionDeAdyacente(casillero1), Direccion.IZQUIERDA);
    }

    @Test
    public void obtenerTipoDistanciaDevuelveDistanciaCercanaParaDistanciasMenoresA3(){
        Jugador dummy = new Jugador("Berni");
        Coordenada coordenada1 = new Coordenada(0,0);
        Coordenada coordenada2 = new Coordenada(0,2);
        Casillero casillero1 = new Casillero(dummy, coordenada1);
        Casillero casillero2 = new Casillero(dummy, coordenada2);

        assertEquals(casillero1.obtenerTipoDistancia(casillero2), new DistanciaCercana());
    }

    @Test
    public void obtenerTipoDistanciaDevuelveDistanciaMedianaParaDistanciasMayoresA2YMenoresA6(){
        Jugador dummy = new Jugador("Berni");
        Coordenada coordenada1 = new Coordenada(0,0);
        Coordenada coordenada2 = new Coordenada(0,2);
        Coordenada coordenada3 = new Coordenada(0, 5);
        Casillero casillero1 = new Casillero(dummy, coordenada1);
        Casillero casillero2 = new Casillero(dummy, coordenada2);
        Casillero casillero3 = new Casillero(dummy, coordenada3);

        assertNotEquals(casillero1.obtenerTipoDistancia(casillero2), new DistanciaMediana());
        assertEquals(casillero1.obtenerTipoDistancia(casillero3), new DistanciaMediana());
    }

    @Test
    public void obtenerTipoDistanciaDevuelveDistanciaLejanaParaDistanciasMayoresA5(){
        Jugador dummy = new Jugador("Berni");
        Coordenada coordenada1 = new Coordenada(0,0);
        Coordenada coordenada2 = new Coordenada(0,5);
        Coordenada coordenada3 = new Coordenada(0, 10);
        Casillero casillero1 = new Casillero(dummy, coordenada1);
        Casillero casillero2 = new Casillero(dummy, coordenada2);
        Casillero casillero3 = new Casillero(dummy, coordenada3);

        assertNotEquals(casillero1.obtenerTipoDistancia(casillero2), new DistanciaLejana());
        assertEquals(casillero1.obtenerTipoDistancia(casillero3), new DistanciaLejana());
    }

    @Test
    public void encontrarEnemigosEnCadenaDevuelveUnaListaConEnemigosEnCadena(){
        Jugador dummy1 = new Jugador("Berni");
        Jugador dummy2 = new Jugador("Tomi");

        Tablero tablero = new Tablero(dummy1, dummy2);

        Coordenada coordenada1 = new Coordenada(9,9);
        Infanteria infanteria1 = new Infanteria(dummy1);
        tablero.agregarUnidad(coordenada1, infanteria1);

        Coordenada coordenada2 = new Coordenada(10,10);
        Infanteria infanteria2 = new Infanteria(dummy2);
        tablero.agregarUnidad(coordenada2, infanteria2);

        Coordenada coordenada3 = new Coordenada(9,11);
        Infanteria infanteria3 = new Infanteria(dummy1);
        tablero.agregarUnidad(coordenada3, infanteria3);

        Coordenada coordenada4 = new Coordenada(12 , 10);
        Infanteria infanteria4 = new Infanteria(dummy2);
        tablero.agregarUnidad(coordenada4, infanteria4);

        //Solo las infanterias 1,2 y 3 estan en cadena.

        Identificador identificador = new IdentificadorDeUnidades();

        List<Unidad> cadena = infanteria1.obtenerCasillero().encontrarUnidadesEnCadena(identificador);

        assertEquals(3, cadena.size());

        assertTrue(cadena.contains(infanteria1));
        assertTrue(cadena.contains(infanteria2));
        assertTrue(cadena.contains(infanteria3));

        assertFalse(cadena.contains(infanteria4));

    }

    @Test
    public void encontrarUnidadesEnCadenaDevuelveUnaListaConInfanteriasEnCadena(){
        Jugador dummy1 = new Jugador("Berni");
        Jugador dummy2 = new Jugador("Tomi");

        Tablero tablero = new Tablero(dummy1, dummy2);

        Coordenada coordenada1 = new Coordenada(8,0);
        Infanteria infanteria1 = new Infanteria(dummy1);
        tablero.agregarUnidad(coordenada1, infanteria1);

        Coordenada coordenada2 = new Coordenada(8,1);
        Infanteria infanteria2 = new Infanteria(dummy1);
        tablero.agregarUnidad(coordenada2, infanteria2);

        Coordenada coordenada3 = new Coordenada(7,2);
        Infanteria infanteria3 = new Infanteria(dummy1);
        tablero.agregarUnidad(coordenada3, infanteria3);

        Coordenada coordenada4 = new Coordenada(9 , 4);
        Infanteria infanteria4 = new Infanteria(dummy1);
        tablero.agregarUnidad(coordenada4, infanteria4);

        Coordenada coordenada5 = new Coordenada(9 , 6);
        Infanteria infanteria5 = new Infanteria(dummy1);
        tablero.agregarUnidad(coordenada5, infanteria5);

        Coordenada coordenadaCat = new Coordenada(8 , 3);
        Catapulta catapulta = new Catapulta(dummy1);
        tablero.agregarUnidad(coordenadaCat, catapulta);

        Coordenada coordenadaEnem = new Coordenada(10 , 5);
        Infanteria infanteriaEnem = new Infanteria(dummy2);
        tablero.agregarUnidad(coordenadaEnem, infanteriaEnem);

        //La primer busqueda encuentra 1, 2 y 3.
        Identificador identificador = new IdentificadorDeInfanterias(dummy1);

        List<Unidad> cadena = infanteria1.obtenerCasillero().encontrarUnidadesEnCadena(identificador);

        assertEquals(3, cadena.size());

        assertTrue(cadena.contains(infanteria1));
        assertTrue(cadena.contains(infanteria2));
        assertTrue(cadena.contains(infanteria3));

        assertFalse(cadena.contains(infanteria4));
        assertFalse(cadena.contains(infanteria5));
        assertFalse(cadena.contains(catapulta));
        assertFalse(cadena.contains(infanteriaEnem));

        //La segunda busqueda solo encuentra el 4.

        cadena = infanteria4.obtenerCasillero().encontrarUnidadesEnCadena(identificador);

        assertEquals(1, cadena.size());

        assertTrue(cadena.contains(infanteria4));

        assertFalse(cadena.contains(infanteria1));
        assertFalse(cadena.contains(infanteria2));
        assertFalse(cadena.contains(infanteria3));
        assertFalse(cadena.contains(infanteria5));
        assertFalse(cadena.contains(catapulta));
        assertFalse(cadena.contains(infanteriaEnem));

    }

    @Test
    public void hayInfanteriasAliadasADistanciaCercanaDevuelveTrueSiHayUnaInfanteriaAliadaCerca(){
        Jugador dummy1 = new Jugador("Berni");
        Jugador dummy2 = new Jugador("Tomi");

        Tablero tablero = new Tablero(dummy1, dummy2);

        Coordenada coordenadaInf = new Coordenada(0,2);
        Infanteria infanteria = new Infanteria(dummy1);
        tablero.agregarUnidad(coordenadaInf, infanteria);

        Coordenada coordenadaJin1 = new Coordenada(0,0);
        Jinete jinete1 = new Jinete(dummy1);
        tablero.agregarUnidad(coordenadaJin1, jinete1);

        Coordenada coordenadaJin2 = new Coordenada(0,19);
        Jinete jinete2 = new Jinete(dummy1);
        tablero.agregarUnidad(coordenadaJin2, jinete2);

        assertTrue(jinete1.obtenerCasillero().hayUnidadesADistanciaCercana(new IdentificadorDeInfanterias(jinete1.obtenerDuenio())));
        assertFalse(jinete2.obtenerCasillero().hayUnidadesADistanciaCercana(new IdentificadorDeInfanterias(jinete2.obtenerDuenio())));
    }

    @Test
    public void hayEnemigosADistanciaCercanaDevuelveTrueSiHayEnemigosCerca(){
        Jugador dummy1 = new Jugador("Berni");
        Jugador dummy2 = new Jugador("Tomi");

        Tablero tablero = new Tablero(dummy1, dummy2);

        Coordenada coordenadaInf = new Coordenada(10,2);
        Infanteria infanteria = new Infanteria(dummy2);
        tablero.agregarUnidad(coordenadaInf, infanteria);

        Coordenada coordenadaJin1 = new Coordenada(9,0);
        Jinete jinete1 = new Jinete(dummy1);
        tablero.agregarUnidad(coordenadaJin1, jinete1);

        Coordenada coordenadaJin2 = new Coordenada(9,19);
        Jinete jinete2 = new Jinete(dummy1);
        tablero.agregarUnidad(coordenadaJin2, jinete2);

        assertTrue(jinete1.obtenerCasillero().hayUnidadesADistanciaCercana(new IdentificadorDeEnemigos(jinete1.obtenerDuenio())));
        assertFalse(jinete2.obtenerCasillero().hayUnidadesADistanciaCercana(new IdentificadorDeEnemigos(jinete2.obtenerDuenio())));
    }

}
