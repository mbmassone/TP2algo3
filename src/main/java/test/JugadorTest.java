package test;

import Modelo.Jugador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JugadorTest {
    @Test
    void testCrearJugadorConNombre(){
        String nuevoNombre = "Tomas";
        Jugador nuevoJugador = new Jugador(nuevoNombre);
        Assertions.assertTrue(nuevoJugador.obtener_nombre() == nuevoNombre);
    }
}
