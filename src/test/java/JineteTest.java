import Modelo.*;
import Modelo.Casillero.Casillero;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class JineteTest {

    @Test
    public void testJineteAtacaEnemigoCercano(){
        Jinete jinete = new Jinete(new Jugador("Lucas"), new Casillero() );
        Catapulta catapulta = new Catapulta(new Jugador("Mauro"), new Casillero());

        jinete.accion(catapulta);
        Assert.assertSame(catapulta.getVida(),45);
    }



    @Test
    public void testJineteMataEnemigoCercano(){
        Casillero casilleroCatapulta = new Casillero();
        Jinete jinete = new Jinete(new Jugador("Santiago"), new Casillero());
        Catapulta catapulta = new Catapulta(new Jugador("Bruno"), casilleroCatapulta);

        casilleroCatapulta.agregarUnidad(catapulta);

        for (int i = 0 ; i < 10 ; i++){
            jinete.accion(catapulta);
        }
        Assert.assertTrue(casilleroCatapulta.estaLibre());
    }

    @Test
    public  void testJinetePuedeRecibirCuracion(){
        Jugador jugador = new Jugador("Laura");
        Jinete jinete = new Jinete(jugador, new Casillero());
        Curandero curandero = new Curandero(jugador, new Casillero());

        curandero.accion(jinete);

        Assert.assertSame(jinete.getVida(),115);

    }

    @Test
    public void testJineteAtacaAliado(){
        Jugador jugador = new Jugador("Juan");
        Jinete jinete = new Jinete(jugador, new Casillero());
        Curandero curanderoAliado = new Curandero(jugador, new Casillero());

        assertThrows(AtacarAliadoExcepcion.class, () ->{
            jinete.accion(curanderoAliado);
        });
    }
}
