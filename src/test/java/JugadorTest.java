import Modelo.Bando;
import Modelo.Casillero.Casillero;
import Modelo.Infanteria;
import Modelo.Jugador;
import org.junit.Assert;
import org.junit.Test;


public class JugadorTest {
    
    @Test
    public void testCrearJugadorConNombre(){
        String nuevoNombre = "Tomas";
        Jugador nuevoJugador = new Jugador(nuevoNombre, Bando.BANDO1);
        Assert.assertSame(nuevoJugador.obtenerNombre(), nuevoNombre);
    }

    @Test
    public void testVerificarReduccionDePuntos() {
        Jugador nuevoJugador = new Jugador("Andoni", Bando.BANDO1);
        nuevoJugador.agregarUnidad(new Infanteria(Bando.BANDO1, new Casillero()) );

        Assert.assertSame(nuevoJugador.obtenerPuntos(), 19);
    }

    @Test
    public void testVerificarQueNoPuedaTomarMasEntidadesQueLasPermitidas() {
        Jugador nuevoJugador = new Jugador("Bernardo", Bando.BANDO1);

        for(int i = 0; i < 20; i++)
            nuevoJugador.agregarUnidad(new Infanteria( Bando.BANDO1, new Casillero() ) );

        int cantidadUnidadesEsperadas = nuevoJugador.obtenerCantidadUnidades();

        nuevoJugador.agregarUnidad(new Infanteria(Bando.BANDO1, new Casillero() ) );

        Assert.assertSame(nuevoJugador.obtenerCantidadUnidades(), cantidadUnidadesEsperadas);
    }

    @Test
    public void testVerificarQueNoPuedaTomarMasEntidadesQueLasPermitidasEntoncesNoRestaPuntos() {
        Jugador nuevoJugador = new Jugador("Juan", Bando.BANDO1);

        for(int i = 0; i < 20; i++)
            nuevoJugador.agregarUnidad(new Infanteria( Bando.BANDO1, new Casillero() ) );

        int cantidadPuntosEsperados = nuevoJugador.obtenerPuntos();

        nuevoJugador.agregarUnidad(new Infanteria(Bando.BANDO1, new Casillero() ) );

        Assert.assertSame(nuevoJugador.obtenerPuntos(), cantidadPuntosEsperados);
    }

    @Test
    public void testMatanGuerreroAUnJugador(){
        Jugador nuevoJugador = new Jugador("Tomas", Bando.BANDO1);
        nuevoJugador.agregarUnidad(new Infanteria(Bando.BANDO1, new Casillero()));
        nuevoJugador.agregarUnidad(new Infanteria(Bando.BANDO1, new Casillero()));
        nuevoJugador.eliminarGuerrero();

        Assert.assertSame(nuevoJugador.obtenerCantidadUnidades(), 1);
    }

    @Test
    public void testMatanGuerreroAJugadorUnYEstePierde(){
        Jugador nuevoJugador = new Jugador("Eugenio", Bando.BANDO1);
        nuevoJugador.agregarUnidad(new Infanteria(Bando.BANDO1, new Casillero() ));
        nuevoJugador.eliminarGuerrero();

        Assert.assertSame(nuevoJugador.obtenerCantidadUnidades(), 0); //TODO Consultar esto
    }
}
