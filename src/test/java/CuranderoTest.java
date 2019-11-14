import Modelo.Casillero.Casillero;
import Modelo.Curandero;
import Modelo.CurarEnemigoExcepcion;
import Modelo.Infanteria;
import Modelo.Jugador;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CuranderoTest {
    @Test
    public void curanderoCuraAliado(){
        Jugador jugador = new Jugador("Eugenio");
        Curandero curandero = new Curandero(jugador, new Casillero());
        Infanteria infanteriaAliada = new Infanteria(jugador, new Casillero());
        Infanteria infanteriaEnemiga = new Infanteria(new Jugador("Tomas"), new Casillero());

        infanteriaEnemiga.accion(infanteriaAliada);
        infanteriaEnemiga.accion(infanteriaAliada);

        curandero.accion(infanteriaAliada);

        Assert.assertSame(infanteriaAliada.getVida(), 95);
    }
    @Test
    public void curanderoCuraEnemigo(){
        Curandero curandero = new Curandero(new Jugador("Bernardo"), new Casillero());
        Infanteria infanteriaEnemiga = new Infanteria(new Jugador("Juan"), new Casillero());

        assertThrows(CurarEnemigoExcepcion.class, () ->{
            curandero.accion(infanteriaEnemiga);
        });
    }
    @Test
    public void curanderoSeCuraAsiMismo(){
        Curandero curandero = new Curandero(new Jugador("Stephanie"), new Casillero());
        curandero.accion(curandero);

        Assert.assertSame(curandero.getVida(),90);
    }

}
