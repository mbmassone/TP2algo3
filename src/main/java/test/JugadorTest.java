package test;

import Modelo.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class JugadorTest {
    @Test
    public void testCrearJugadorConNombre(){
        String nuevoNombre = "Tomas";
        Jugador nuevoJugador = new Jugador(nuevoNombre);
        Assert.assertTrue(nuevoJugador.obtener_nombre() == nuevoNombre);
    }
}
