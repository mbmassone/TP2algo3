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
    public void testInfanteriaAtacaEnemigo(){
        Infanteria infanteriaAliada = new Infanteria(new Jugador("Manuel") , new Casillero() );
        Infanteria infanteriaEnemiga = new Infanteria(new Jugador("Andoni") , new Casillero() );

        infanteriaAliada.accion(infanteriaEnemiga);
        Assert.assertSame(infanteriaEnemiga.getVida(),90);
    }

    @Test
    public void testInfanteriaMataAEnemigo() {
        Casillero casilleroJinete = new Casillero();
        Infanteria infanteria = new Infanteria(new Jugador("Andy"), new Casillero());
        Jinete jinete = new Jinete(new Jugador("Jorge"), casilleroJinete);

        casilleroJinete.agregarUnidad(jinete);

        Assert.assertFalse(casilleroJinete.estaLibre());
        for (int i = 0; i < 10; i++) {
            infanteria.accion(jinete);
        }
        Assert.assertTrue(casilleroJinete.estaLibre());
    }

    @Test
    public void testInfanteriaAtacaAliado(){
        Jugador jugador = new Jugador("Guido");
        Infanteria infanteria = new Infanteria(jugador, new Casillero());
        Infanteria infanteriaAliada = new Infanteria(jugador, new Casillero());

        assertThrows(AtacarAliadoExcepcion.class, () ->{
            infanteria.accion(infanteriaAliada);
        });
    }

    @Test
    public void testInfanteriaPuedeRecibirCuracion(){
        Jugador jugador = new Jugador("Luis");
        Infanteria infanteria = new Infanteria(jugador, new Casillero());
        Curandero curandero = new Curandero(jugador, new Casillero());

        curandero.accion(infanteria);

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
