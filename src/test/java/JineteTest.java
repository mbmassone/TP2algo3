import Modelo.*;
import Modelo.Casillero.Casillero;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class JineteTest {

    @Test
    public void testJineteAtacaEnemigoCercano(){
        Jinete jinete = new Jinete(Bando.BANDO2,new Casillero() );
        Catapulta catapulta = new Catapulta(Bando.BANDO1,new Casillero());

        jinete.accion(catapulta);
        Assert.assertSame(catapulta.getVida(),45);
    }



    @Test
    public void testJineteMataEnemigoCercano(){
        Casillero casilleroCatapulta = new Casillero();
        Jinete jinete = new Jinete(Bando.BANDO2,new Casillero());
        Catapulta catapulta = new Catapulta(Bando.BANDO1, casilleroCatapulta);

        casilleroCatapulta.agregarUnidad(catapulta);

        for (int i = 0 ; i < 10 ; i++){
            jinete.accion(catapulta);
        }
        Assert.assertTrue(casilleroCatapulta.estaLibre());
    }

    @Test
    public  void testJinetePuedeRecibirCuracion(){
        Jinete jinete = new Jinete(Bando.BANDO2,new Casillero());
        Curandero curandero = new Curandero(Bando.BANDO2 , new Casillero());

        curandero.accion(jinete);

        Assert.assertSame(jinete.getVida(),115);

    }

    @Test
    public void testJineteAtacaAliado(){
        Jinete jinete = new Jinete(Bando.BANDO1, new Casillero());
        Curandero curanderoAliado = new Curandero(Bando.BANDO1, new Casillero());

        assertThrows(AtacarAliadoExcepcion.class, () ->{
            jinete.accion(curanderoAliado);
        });
    }
}
