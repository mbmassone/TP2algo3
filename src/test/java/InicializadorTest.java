 import Modelo.Bando;
 import Modelo.Casillero.Casillero;
 import Modelo.Infanteria;
 import Modelo.Inicializador;
 import Modelo.Jugador.Jugador;
 import Modelo.Tablero.Tablero;
 import org.junit.Assert;
 import org.junit.Test;

public class InicializadorTest {
    @Test
    public void testAgregarGuerreroAlJuego(){ //TODO
        Inicializador inicializador = new Inicializador(new Tablero());

        inicializador.agregarUnidad(new Jugador("Andoni", Bando.BANDO1), 5, 5, new Infanteria(Bando.BANDO1, new Casillero()));

        //Assert.assertSame();
    }
}
