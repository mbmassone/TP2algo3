import Modelo.Casillero.Casillero;
import Modelo.Infanteria;
import Modelo.Jugador;
import org.junit.Assert;
import org.junit.Test;


public class JugadorTest {

    @Test
    public void testCrearJugadorConNombre(){
        String nuevoNombre = "Tomas";
        Jugador nuevoJugador = new Jugador(nuevoNombre);
        Assert.assertSame(nuevoJugador.obtenerNombre(), nuevoNombre);
    }

    @Test
    public void testVerificarReduccionDePuntos() {
        Jugador nuevoJugador = new Jugador("Andoni");
        nuevoJugador.agregarUnidad(new Infanteria(nuevoJugador) );

        Assert.assertSame(nuevoJugador.obtenerPuntos(), 19);
    }

    @Test
    public void testVerificarQueNoPuedaTomarMasEntidadesQueLasPermitidas() {
        Jugador nuevoJugador = new Jugador("Bernardo");

        for(int i = 0; i < 20; i++)
            nuevoJugador.agregarUnidad(new Infanteria(nuevoJugador) );

        int cantidadUnidadesEsperadas = nuevoJugador.obtenerCantidadUnidades();

        nuevoJugador.agregarUnidad(new Infanteria(nuevoJugador) );

        Assert.assertSame(nuevoJugador.obtenerCantidadUnidades(), cantidadUnidadesEsperadas);
    }

    @Test
    public void testVerificarQueNoPuedaTomarMasEntidadesQueLasPermitidasEntoncesNoRestaPuntos() {
        Jugador nuevoJugador = new Jugador("Juan");

        for(int i = 0; i < 20; i++)
            nuevoJugador.agregarUnidad(new Infanteria(nuevoJugador) );

        int cantidadPuntosEsperados = nuevoJugador.obtenerPuntos();

        nuevoJugador.agregarUnidad(new Infanteria(nuevoJugador) );

        Assert.assertSame(nuevoJugador.obtenerPuntos(), cantidadPuntosEsperados);
    }

    @Test
    public void testMatanGuerreroAUnJugador(){
        Jugador nuevoJugador = new Jugador("Tomas");
        nuevoJugador.agregarUnidad(new Infanteria(nuevoJugador) );
        nuevoJugador.agregarUnidad(new Infanteria(nuevoJugador) );
        nuevoJugador.eliminarUnidad();

        Assert.assertSame(nuevoJugador.obtenerCantidadUnidades(), 1);
    }

    @Test
    public void testMatanGuerreroAJugadorUnYEstePierde(){
        Jugador nuevoJugador = new Jugador("Eugenio");
        nuevoJugador.agregarUnidad(new Infanteria(nuevoJugador) );
        nuevoJugador.eliminarUnidad();

        Assert.assertSame(nuevoJugador.obtenerCantidadUnidades(), 0); //TODO Consultar esto
    }
}
