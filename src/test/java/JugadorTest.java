package test;

import Modelo.Bando;
import Modelo.Infanteria;
import Modelo.Jugador.Jugador;
import Modelo.Jugador.JugadorConPuntosInsuficientesException;
import Modelo.Jugador.JugadorSinUnidadesEnJuego;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JugadorTest {
    /*
    [ ]Se verifica que no puede tomar más entidades de lo que sus puntos le permiten.
    [x]Se verifica que el jugador que se queda sin entidades, es el perdedor.

     */
    @Test
    public void testCrearJugadorConNombre(){
        String nuevoNombre = "Tomas";
        Jugador nuevoJugador = new Jugador(nuevoNombre);
        Assert.assertSame(nuevoJugador.obtenerNombre(), nuevoNombre);
    }

    @Test
    public void testVerificarReduccionDePuntos() {
        Jugador nuevoJugador = new Jugador("Andoni");
        nuevoJugador.agregarUnidad(new Infanteria(Bando.BANDO1) );

        Assert.assertSame(nuevoJugador.obtenerPuntos(), 19);
    }

    @Test
    public void testVerificarQueNoPuedaTomarMasEntidadesQueLasPermitidas() {
        Jugador nuevoJugador = new Jugador("Bernardo");

        for(int i = 0; i < 20; i++)
            nuevoJugador.agregarUnidad(new Infanteria(Bando.BANDO1) );

        assertThrows(JugadorConPuntosInsuficientesException.class, () ->{
            nuevoJugador.agregarUnidad(new Infanteria(Bando.BANDO1) );
        });
    }

    @Test
    public void testVerificarQueNoPuedaTomarMasEntidadesQueLasPermitidasEntoncesNoRestaPuntos() {
        Jugador nuevoJugador = new Jugador("Juan");

        for(int i = 0; i < 21; i++) {
            try {
                nuevoJugador.agregarUnidad(new Infanteria(Bando.BANDO1));
            } catch (JugadorConPuntosInsuficientesException ex) {
                Assert.assertSame(nuevoJugador.obtenerPuntos(), 0);
            }
        }
    }

    @Test
    public void testMatanGuerreroAUnJugador(){
        Jugador nuevoJugador = new Jugador("Tomas");
        nuevoJugador.agregarUnidad(new Infanteria(Bando.BANDO1));
        nuevoJugador.agregarUnidad(new Infanteria(Bando.BANDO1));
        nuevoJugador.eliminarGuerrero();

        Assert.assertSame(nuevoJugador.obtenerCantidadUnidades(), 1);
    }

    @Test
    public void testMatanGuerreroAJugadorUnYEstePierde(){
        Jugador nuevoJugador = new Jugador("Eugenio");
        nuevoJugador.agregarUnidad(new Infanteria(Bando.BANDO1));
        nuevoJugador.eliminarGuerrero();

        assertThrows(JugadorSinUnidadesEnJuego.class, () ->{
            nuevoJugador.chequearEstado();
        });
    }
}
